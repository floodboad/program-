<style type="text/css">
  .ant-page-header-heading-title {
    margin-right: 12px;
    margin-bottom: 0;
    color: rgba(0, 0, 0, 0.85);
    font-weight: 600;
    font-size: 20px;
    line-height: 32px;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
    padding:20px 0 0 20px;
  }
  .ant-table-tbody{
    height: 100%;
  }
  .ant-table {
    min-height: 352px !important;
  }
</style>
<template>
  <div>
    <PageWrapper class="high-form" contentBackground contentClass="p-4" title="">
      <div style="background: #fff;">
        <p class="ant-page-header-heading-title">项目信息详情</p>
        <BasicForm @register="registerForm">
        </BasicForm>
      </div>
      <template #leftFooter>
        <a-button  class="ml-4" type="primary" @click="handleBack" >
          返回
        </a-button>
        <a-button v-if="type !== ActionEnum.VIEW"  class="ml-4" type="primary" @click="handleSubmit(1)"
        >
          保存
        </a-button>
        <a-button v-if="type !== ActionEnum.VIEW && type !== ActionEnum.ADJUST"  class="ml-4" type="primary" @click="handleSubmit(2)"
        >
          提交
        </a-button>
      </template>
    </PageWrapper>
    <PageWrapper contentBackground>
      <template #footer>
        <a-tabs
          default-active-key="1"
          @change="
            (key) => {
              formState.showTab = key;
            }
          "
        >
          <a-tab-pane key="1" tab="项目赞助企业" >
            <pmProjectSponsor  ref="pmProjectSponsorRef" />
          </a-tab-pane>
          <a-tab-pane key="2" tab="项目干系人" >
            <pmProjectStakeholder  ref="pmProjectStakeholderRef" />
          </a-tab-pane>

        </a-tabs>
      </template>
    </PageWrapper>

    <template>
      <DefUser @register="registerDefUserModal" @success="handleDefUserSelect" ref="defUserRef" />
    </template>
  </div>
</template>
<script lang="ts">

    import { defineComponent, onMounted, reactive, ref, unref,onUnmounted } from 'vue';
    import DefUser from '../pmProjectStakeholder/reference/defUser.vue';
    import { BasicModal } from '/@/components/Modal';
    import { BasicForm, useForm } from '/@/components/Form/index';
    import { PageWrapper } from '/@/components/Page';
    import { useRouter } from 'vue-router';
    import { useI18n } from '/@/hooks/web/useI18n';
    import { useMessage } from '/@/hooks/web/useMessage';
    import { useTabs } from '/@/hooks/web/useTabs';
    import { useLoading } from '/@/components/Loading';
    import {buildUUID} from "/@/utils/uuid";
    import { ActionEnum,  VALIDATE_API } from '/@/enums/commonEnum';
    import { Tabs } from 'ant-design-vue';
    import { Api, get, insert,updateNew ,adjust} from '/@/api/learnpm/pm/pmProject';
    import { getValidateRules } from '/@/api/lamp/common/formValidateService';
    import { customFormSchemaRules, editFormSchema, values } from './pmProject.data';
    import { useModal } from '/@/components/Modal';
    import pmProjectSponsor from './pmProjectSponsor/index.vue';
    import pmProjectStakeholder from './pmProjectStakeholder/index.vue';
    import {useFunctionItemStore} from "/@/store/modules/function";


    export default defineComponent({
        name: '项目信息维护',
        components: {
            BasicForm,
            PageWrapper,
            [Tabs.name]: Tabs,
            [Tabs.TabPane.name]: Tabs.TabPane,
            pmProjectSponsor,
            pmProjectStakeholder,
            BasicModal,
            DefUser,
        },
        emits: ['success', 'register'],
        setup(_) {
            const visible = ref<boolean>(false);
            const { t } = useI18n();
            const type = ref(ActionEnum.ADD);
            const { createMessage } = useMessage();
            const { replace, currentRoute } = useRouter();
            const { closeCurrent } = useTabs();
            const id= ref<any>(null);
            const busType= ref<any>(null);
            const timer = ref<any>(null);
            const showTab = ref<any>(null);
            const pmProjectSponsorRef= ref<any>(null);
            const pmProjectStakeholderRef= ref<any>(null);

            const formState = reactive({
                showTab: '1',
            });
            const defUserRef= ref<any>(null);
            const [registerDefUserModal, { openModal:openDefUserModal }] = useModal();
            const loadFlag1= ref<any>(null);
            const loadFlag2= ref<any>(null);
            const loadFlag3= ref<any>(null);
            const functionItemStore = useFunctionItemStore();
            const [openFullLoading, closeFullLoading] = useLoading({
                tip: t('common.requestingText'),
            });

            const [registerForm, { setFieldsValue, resetFields, updateSchema, validate ,getFieldsValue}] = useForm({
                labelWidth: 100,
                schemas: editFormSchema(type,  totalAmount,consolidatedAmount,defUserReference),
                showActionButtonGroup: false,
                baseColProps: { span: 24 },
                actionColOptions: {
                    span: 23,
                },
            });




            function getPmProjectSponsorRef() {
                return unref(pmProjectSponsorRef);
            }
            function getPmProjectStakeholderRef() {
                return unref(pmProjectStakeholderRef);
            }

            onMounted(() => {
                const { params } = currentRoute.value;
                debugger
                //console.log("进入了OnMouted！");
                id.value = params.id
                busType.value = params.busType
                load({ type: params?.type, id:id.value});
                loadFlag1.value = false;
                loadFlag2.value = false;
                loadFlag3.value = false;
                if(params?.type!=ActionEnum.ADD){
                    timer.value = setInterval(() => {
                        loadList(id.value);
                    },1000);
                }
            });

            onUnmounted(()=>{
                //;
                if(timer.value) { //如果定时器还在运行 或者直接关闭，不用判断
                    clearInterval(timer.value); //关闭
                }
            });

            const loadList1 = async (id) => {
                if(pmProjectSponsorRef.value && !loadFlag1.value){
                    pmProjectSponsorRef.value.load(ActionEnum.VIEW,id);
                    showTab.value = formState.showTab;
                    loadFlag1.value = true;
                }
            };


            const loadList2 = async (id) => {
                if(pmProjectStakeholderRef.value  && !loadFlag2.value){
                    pmProjectStakeholderRef.value.load(ActionEnum.VIEW,id);
                    showTab.value = formState.showTab;
                    loadFlag2.value = true;
                }
            };



            const load = async (data: Recordable) => {
                await resetFields();
                type.value = data?.type;

                if (![ActionEnum.ADD].includes(unref(type))) {
                    const record = await get(data?.id);
                    await setFieldsValue({ ...record });
                }

                if ([ActionEnum.ADD, ActionEnum.COPY].includes(unref(type))) {
                    let validateApi = Api[VALIDATE_API[unref(type)]];
                    const rules = await getValidateRules(validateApi, customFormSchemaRules(type));
                    rules && rules.length > 0 && (await updateSchema(rules));
                }
            };
            const loadList = async(id)=>{
                if(showTab.value!= formState.showTab){
                    if(formState.showTab==='1'){
                        loadList1(id);
                    }
                    if(formState.showTab==='2'){
                        loadList2(id);
                    }

                }
            }

            function handleBack(e: Event){
                e?.stopPropagation();
                replace({
                    name: '项目信息管理',
                });
            }
            async function handleSubmit(status) {
                try {
                    const params = await validate();
                    if (getPmProjectSponsorRef()) {
                        var errMap1 = await getPmProjectSponsorRef().fullValidate();
                        if (errMap1) {
                            let msgStr = '';
                            Object.values(errMap1).forEach((errList: any) => {
                                errList.forEach((params: any) => {
                                    const {rowIndex, column, rules} = params;
                                    rules.forEach((rule: any) => {
                                        msgStr += `第 ${rowIndex + 1} 行 ${column.title} 校验错误：${rule.message} <br/>`;
                                    });
                                });
                            });
                            notification.warn({
                                message: '校验失败',
                                description: () => {
                                    return h('div', {innerHTML: msgStr}, []);
                                },
                                duration: 5,
                            });
                            return;
                        }


                        params.pmProjectSponsorPmProjectIdInsertList = getPmProjectSponsorRef().getRecordset().insertRecords;
                        params.pmProjectSponsorPmProjectIdUpdateList = getPmProjectSponsorRef().getRecordset().updateRecords
                        params.pmProjectSponsorPmProjectIdDeleteList = getPmProjectSponsorRef().getRecordset().removeRecords.map((item) => item.id)
                    }

                    if (getPmProjectStakeholderRef()) {
                        var errMap2 = await getPmProjectStakeholderRef().fullValidate();
                        if (errMap2) {
                            let msgStr = '';
                            Object.values(errMap2).forEach((errList: any) => {
                                errList.forEach((params: any) => {
                                    const {rowIndex, column, rules} = params;
                                    rules.forEach((rule: any) => {
                                        msgStr += `第 ${rowIndex + 1} 行 ${column.title} 校验错误：${rule.message} <br/>`;
                                    });
                                });
                            });
                            notification.warn({
                                message: '校验失败',
                                description: () => {
                                    return h('div', {innerHTML: msgStr}, []);
                                },
                                duration: 5,
                            });
                            return;
                        }


                        params.pmProjectStakeholderPmProjectIdInsertList = getPmProjectStakeholderRef().getRecordset().insertRecords;
                        params.pmProjectStakeholderPmProjectIdUpdateList = getPmProjectStakeholderRef().getRecordset().updateRecords
                        params.pmProjectStakeholderPmProjectIdDeleteList = getPmProjectStakeholderRef().getRecordset().removeRecords.map((item) => item.id)
                    }

                    openFullLoading();
                    params.remainingBudgetAmount = params.totalBudgetAmount;
                    params.projectSource = '02';
                    params.meetingPlanningStatus ='01';
                    params.adjustStatus = '02';
                    if (status == 1) {
                        params.projectStauts = '01'
                    } else {
                        params.projectStauts = '02'
                    }
                    params.meetingSchedule = params.estimatedMeetingTotalNum;
                    if(!params.projectInitiationUnitId){
                        if(values.value.length>1){
                            alert("立项单位只允许选择一个单位！")
                        }
                        if(values.value.length<1){
                            alert("请选择立项单位！")
                        }
                        params.projectInitiationUnitId = values.value[0].value;
                        params.projectInitiationUnitName = values.value[0].name;
                    }

                    if (unref(type) === undefined) {
                        createMessage.success('非法操作或界面已超时！');
                    } else if (unref(type) !== ActionEnum.VIEW) {
                        if (unref(type) === ActionEnum.EDIT) {
                            await updateNew(params);
                        } else if (unref(type) === ActionEnum.ADD){
                            params.id = null;
                            await insert(params);
                        } else if(busType.value ===  ActionEnum.ADJUST) {
                          await adjust(params);
                        }
                        createMessage.success(t(`common.tips.${type.value}Success`));
                        await closeCurrent();
                        replace({
                            name: '项目信息管理',
                        });
                    }
                } catch (err) {
                    //产生新的交易id
                    functionItemStore.setTransactionId(buildUUID());
                    createMessage.error('操作失败!');
                } finally {
                    closeFullLoading();
                }
            }
            function handleDefUserSelect(){
                //TODO:根据业务需求，自己回填字段
                if(defUserRef.value.selectRowList.length>0){
                    const params = getFieldsValue();
                    //console.log('params :'+JSON.stringify(params));
                    params.initiatorId=defUserRef.value.selectRowList[0].id;
                    params.initiatorName=defUserRef.value.selectRowList[0].username;
                    setFieldsValue(params);
                    visible.value=false;
                }
            }
            function defUserReference(){
                visible.value=true;
                var data={"record":{"id":id.value}};
                //console.log('record:'+JSON.stringify(data));
                openDefUserModal(true,  data );
            }
            const totalProjectAmount = ref<any>(null);
            const consolidatedTaxAmount = ref<any>(null);

            function totalAmount(val){
                totalProjectAmount.value = val.currentTarget._value;
                if(consolidatedTaxAmount.value){
                    const vo =ref<any>(null);
                    vo.totalBudgetAmount =  val.currentTarget._value - consolidatedTaxAmount.value;
                    setFieldsValue(vo);
                }
            }
            function consolidatedAmount(val){
                consolidatedTaxAmount.value = val.currentTarget._value;
                if(totalProjectAmount.value){
                    const vo =ref<any>(null);
                    vo.totalBudgetAmount = totalProjectAmount.value - val.currentTarget._value;
                    setFieldsValue(vo);
                }

            }
            return { t, registerForm, type, handleSubmit, formState, ActionEnum, handleBack,totalAmount,consolidatedAmount,
                pmProjectSponsorRef,     pmProjectStakeholderRef,loadList, visible,handleDefUserSelect,defUserRef,registerDefUserModal,defUserReference};
        },
    });
</script>
