<template>

  <PageWrapper dense contentFullHeight>
    <BasicTable @register="registerTable"
                @selection-change="handleSelectionChange"
                @row-click="handleRowClick"
                @row-db-click="handleRowDbClick"
                @fetch-success="onFetchSuccess">
      <template #toolbar>
        <a-button
          type="primary"
          color="error"
          preIcon="ant-design:branches-outlined"
          @click="handleMeetingAudit"
        >
          '提交审核'
        </a-button>

      </template>

    </BasicTable>
  </PageWrapper>
</template>
<script lang="ts">
  import { useRouter } from 'vue-router';
  import { defineComponent,ref } from 'vue';
  import { useI18n } from '/@/hooks/web/useI18n';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { BasicTable, useTable, TableAction } from '/@/components/Table';
  import { PageWrapper } from '/@/components/Page';
  import { useModal } from '/@/components/Modal';
  import { handleFetchParams } from '/@/utils/lamp/common';
  import { ActionEnum } from '/@/enums/commonEnum';
  import { copy, pageList } from '/@/api/learnpm/pm/pmProject';
  import { commitPlanAudit } from '/@/api/learnpm/pm/pmProjectMeetingPlanning';
  import { schemaindColumns, searchFormSchemaind } from './pmProject.data';
  import EditModal from './tabpaneindex.vue';
  import { useFunctionItemStore } from '/@/store/modules/function';
  import {buildUUID} from '/@/utils/uuid.ts';
  import { useDrawer } from '/@/components/Drawer';

  export default defineComponent({
    // 若需要开启页面缓存，请将此参数跟菜单名保持一致
    name: '项目信息',
    components: {
      BasicTable,
      PageWrapper,
      TableAction,
      EditModal,
    },
      emits: ['select'],
    setup(_, { emit }) {
      const { t } = useI18n();
      const { createMessage, createConfirm } = useMessage();
      const [registerModal, { openModal }] = useModal();
        // 编辑页弹窗
        const [registerDrawer, { openDrawer }] = useDrawer();
      const functionItemStore = useFunctionItemStore();
      const { replace } = useRouter();
	  const tableData = ref<any>;
      // 表格
      const [registerTable, { reload, getSelectRowKeys, getSelectRows,setSelectedRowKeys }] = useTable({
        title: t('learnpm.pm.pmProject.table.title'),
        api: pageList,
        columns: schemaindColumns(),
        formConfig: {
          name: 'PmProjectSearch',
          labelWidth: 60,
          schemas: searchFormSchemaind(),
          autoSubmitOnEnter: true,
          resetButtonOptions: {
            preIcon: 'ant-design:rest-outlined',
          },
          submitButtonOptions: {
            preIcon: 'ant-design:search-outlined',
          },
        },
        beforeFetch: handleFetchParams,
        afterFetch: (v)=>{
          tableData.value = v;
          //console.log('afterFetch:'+JSON.stringify(tableData.value));
          return v;
        },
        useSearchForm: true,
        showTableSetting: true,
        bordered: true,
        rowKey: 'id',
        rowSelection: {
          type: 'radio',
          columnWidth: 40,
        },

      });

      // 直接复制
      async function handleCopy(record: Recordable, e: Event) {
        e?.stopPropagation();
        await copy(record.id);
        createMessage.success(t('common.tips.copySuccess'));
        handleSuccess();
      }
      // 弹出新增页面
      function handleAdd(e: Event) {
        e?.stopPropagation();
        //产生新的交易id
        functionItemStore.setTransactionId(buildUUID());
        console.log('新的交易id:'+functionItemStore.getTransactionId);
       replace({
          name: '项目信息维护',
          params: { type: ActionEnum.ADD, id: '0' },
        });
      }

      // 弹出查看页面
      function handleView(record: Recordable, e: Event) {
        e?.stopPropagation();
         replace({
          name: '项目信息维护',
          params: { type: ActionEnum.VIEW, id: record.id },
        });
      }

      // 弹出编辑页面
      function handleEdit(record: Recordable, e: Event) {
        e?.stopPropagation();
       replace({
          name: '项目信息维护',
          params: { type: ActionEnum.EDIT, id: record.id },
        });
      }
// 弹出编辑页面
        function handleEditPlan(record: Recordable, e: Event) {
            e?.stopPropagation();
            replace({
                name: '项目规划维护',
                params: { type: ActionEnum.ADD, parentId: record.id},
            });
        }
      // 新增或编辑成功回调
      function handleSuccess() {
        reload();
      }

    /*  async function batchDelete(ids: string[]) {
        await remove(ids);
        createMessage.success(t('common.tips.deleteSuccess'));
        handleSuccess();
      }*/
        //会议规划提交审核
       /* function handleMeetingAudit(record: Recordable, e: Event){
            e?.stopPropagation();
            try{
                commitPlanAudit(record.id)
                    .then(res => {
                        console.log(res, 'res')
                        createMessage.success("提交成功！");
                      /!*  replace({
                            name:'项目会议申请',
                            params: { type: ActionEnum.ADD, id: '0' },
                        })*!/
                    })
            } catch(err){
                createMessage.warn("申请失败！")
            }

        }*/

      // 点击批量删除
      function handleMeetingAudit() {
        const ids = getSelectRowKeys();
        if (!ids || ids.length <= 0) {
          createMessage.warning(t('common.tips.pleaseSelectTheData'));
          return;
        }else if (!ids || ids.length > 1){
            createMessage.warning('只能选择一条信息提交审核');
            return;
        }
        createConfirm({
          iconType: 'warning',
          content: '请检查是否已规划完成，确认后将不允许操作！',
          onOk: async () => {
              try{
                  commitPlanAudit(ids[0])
                      .then(res => {
                          console.log(res, 'res')
                          createMessage.success("提交成功！");
                          /*  replace({
                                name:'项目会议申请',
                                params: { type: ActionEnum.ADD, id: '0' },
                            })*/
                      })
              } catch(err){
                  createMessage.warn("申请失败！")
              }
          },
        });
      }
        // 勾选事件触发
        function handleSelectionChange() {
            emitChange();
        }
        // 选择事件
        function emitChange() {
            const selectedKeys = getSelectRows();
            emit('select', selectedKeys.length > 0 ? selectedKeys[0] : {});
        }
        // 单击行回调
        function handleRowClick(record: Recordable) {
            setSelectedRowKeys([record.id]);
            emitChange();
        }
        // 双击行回调
        function handleRowDbClick(record: Recordable) {
            setSelectedRowKeys([record.id]);
            const rows = getSelectRows();
            openDrawer(true, {
                record: rows[0],
                type: ActionEnum.EDIT,
            });
        }

        async function onFetchSuccess(result: Recordable) {
            // 请求之后对返回值进行处理
            if (result && result.items && result.items.length > 0) {
                setSelectedRowKeys([result.items[0].id]);
                emitChange();
            }
        }

      return {
        t,
        registerTable,
        registerModal,
        handleView,
        handleAdd,
        handleCopy,
        handleEdit,
          handleEditPlan,
          handleMeetingAudit,
        handleSuccess,
          handleSelectionChange,
          handleRowClick,
          handleRowDbClick,
          onFetchSuccess,
      };
    },
  });
</script>
