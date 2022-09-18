<template>
  <BasicModal
    v-bind="$attrs"
    @register="registerModel"
    :title="t(`common.title.${type}`)"
    :maskClosable="false"
    @ok="handleSubmit"
    :keyboard="true"
  >
    <BasicForm @register="registerForm" />
 
	<CloudWorkTypeConf @register="registerCloudWorkTypeConfModal" @success="handleCloudWorkTypeConfSelect" ref="cloudWorkTypeConfRef" />
  </BasicModal>
</template>
<script lang="ts">
  import { defineComponent, ref, unref } from 'vue';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { BasicForm, useForm } from '/@/components/Form/index';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { useI18n } from '/@/hooks/web/useI18n';
  import { ActionEnum, VALIDATE_API } from '/@/enums/commonEnum';
  import { getValidateRules } from '/@/api/lamp/common/formValidateService';
  import { Api, save, update } from '/@/api/paigongyun/cloud/cloudWorkerRegistration';
  import { customFormSchemaRules,editFormSchema } from './cloudWorkerRegistration.data';
  import { useModal } from '/@/components/Modal';
 
  import CloudWorkTypeConf from './reference/cloudWorkTypeConf.vue';
  export default defineComponent({
    name: '编辑工人注册管理',
	 components: { BasicModal, BasicForm,CloudWorkTypeConf},
    emits: ['success', 'register'],
    setup(_, { emit }) {
      const { t } = useI18n();
      const type = ref<ActionEnum>(ActionEnum.ADD);
      const { createMessage } = useMessage();
	  const id = ref('');
	  
	const cloudWorkTypeConfRef= ref<any>(null);
	  
	const [registerCloudWorkTypeConfModal, { openModal:openCloudWorkTypeConfModal }] = useModal();

      const [registerForm, { setFieldsValue, resetFields, updateSchema, validate, resetSchema,getFieldsValue }] =
        useForm({
         name: 'CloudWorkerRegistrationEdit',
          labelWidth: 100,
		  schemas: editFormSchema(type,cloudWorkTypeConfReference),
          showActionButtonGroup: false,
          disabled: (_) => {
            return unref(type) === ActionEnum.VIEW;
          },
          baseColProps: { span: 24 },
          actionColOptions: {
            span: 23,
          },
        });

      const [registerModel, { setModalProps: setProps, closeModal: close }] = useModalInner(async (data) => {
        setProps({ confirmLoading: false });
        await resetSchema( editFormSchema(type,cloudWorkTypeConfReference)
          );
        await resetFields();
        type.value = data?.type|| ActionEnum.ADD;

        if (unref(type) !== ActionEnum.ADD) {
          // 赋值
          const record = { ...data?.record };
          id.value=record.id;
		  await setFieldsValue(record);
        }

        if (unref(type) !== ActionEnum.VIEW) {
          let validateApi = Api[VALIDATE_API[unref(type)]];
          await getValidateRules(validateApi, customFormSchemaRules(type)).then(async (rules) => {
            rules && rules.length > 0 && (await updateSchema(rules));
          });
        }
      });
	function cloudWorkTypeConfReference(){
		var data={"record":{"id":id.value}};
        //console.log('record:'+JSON.stringify(data));
        openCloudWorkTypeConfModal(true,  data );
	}
	function handleCloudWorkTypeConfSelect(){
        //debugger;
		//TODO:根据业务需求，自己回填字段
        if(cloudWorkTypeConfRef.value.selectRowList.length>0){
		  const params = getFieldsValue();
          //console.log('params :'+JSON.stringify(params));
          params.cloudWorkTypeConfId=cloudWorkTypeConfRef.value.selectRowList[0].id;
          setFieldsValue(params);
          console.log('handleSelect first row id :'+cloudWorkTypeConfRef.value.selectRowList[0].id);
        }
      }	
      async function handleSubmit() {
        try {
          const params = await validate();
          setProps({ confirmLoading: true });
          if (unref(type) !== ActionEnum.VIEW) {
            if (unref(type) === ActionEnum.EDIT) {
              await update(params);
            } else {
              params.id = null;
              await save(params);
            }
            createMessage.success(t(`common.tips.${type.value}Success`));
          }

          close();
          emit('success');
        } finally {
          setProps({ confirmLoading: false });
        }
      }

return { type,t,  registerModel, registerForm, handleSubmit 
,registerCloudWorkTypeConfModal,handleCloudWorkTypeConfSelect,cloudWorkTypeConfRef,cloudWorkTypeConfReference  
	  };
    },
  });
</script>
