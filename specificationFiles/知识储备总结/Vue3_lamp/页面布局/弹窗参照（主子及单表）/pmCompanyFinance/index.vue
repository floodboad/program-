<template>
  <PageWrapper dense contentFullHeight>
    <BasicTable @register="registerTable">
      <template #toolbar>
        <a-button
          type="primary"
          color="error"
         preIcon="ant-design:delete-outlined"
         @click="handleBatchDelete"
         v-hasAnyPermission="['learnpm:pm:pmCompanyFinance:delete']"
          >{{ t('common.title.delete') }}</a-button
        >
      <a-button
          type="primary"
          preIcon="ant-design:plus-outlined"
          @click="handleAdd"
          v-hasAnyPermission="['learnpm:pm:pmCompanyFinance:add']"
          >{{ t('common.title.add') }}</a-button
        >
      <a-button
          type="primary"
          preIcon="ant-design:export-outlined"
          @click="exportXls"
        >
          {{ t('common.title.export') }}
        </a-button>      
      </template>
      <template #bodyCell="{ column, record }">
       <template v-if="column.dataIndex === 'action'">
        <TableAction
          :actions="[
           {
                tooltip: t('common.title.view'),
                icon: 'ant-design:search-outlined',
                onClick: handleView.bind(null, record),
              },
            {
              tooltip: t('common.title.edit'),
              icon: 'ant-design:edit-outlined',
              onClick: handleEdit.bind(null, record),
              auth: 'learnpm:pm:pmCompanyFinance:edit',
            },
            {
              tooltip: t('common.title.copy'),
              icon: 'ant-design:copy-outlined',
              onClick: handleCopy.bind(null, record),
              auth: 'learnpm:pm:pmCompanyFinance:copy',
            },
            {
              tooltip: t('common.title.delete'),
              icon: 'ant-design:delete-outlined',
              color: 'error',
              auth: 'learnpm:pm:pmCompanyFinance:delete',
              popConfirm: {
                title: t('common.tips.confirmDelete'),
                confirm: handleDelete.bind(null, record),
              },
            },
          ]"
          :stopButtonPropagation="true"
        />
      </template>
	  </template>
    </BasicTable>
    <EditModal @register="registerModal" @success="handleSuccess" />
  </PageWrapper>
</template>
<script lang="ts">
  import { defineComponent,ref } from 'vue';
  import { useI18n } from '/@/hooks/web/useI18n';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { BasicTable, useTable, TableAction } from '/@/components/Table';
  import { PageWrapper } from '/@/components/Page';
  import { useModal } from '/@/components/Modal';

  import { handleFetchParams } from '/@/utils/lamp/common';

  import { ActionEnum } from '/@/enums/commonEnum';

  import { page, remove } from '/@/api/learnpm/pm/pmCompanyFinance';
  import EditModal from './Edit.vue';
  import { columns, searchFormSchema } from './pmCompanyFinance.data';
  import { useFunctionItemStore } from '/@/store/modules/function';
  import {buildUUID} from '/@/utils/uuid.ts';
  import { jsonToSheetXlsx } from '/@/components/Excel';
  
  export default defineComponent({
    name: '公司财务人员维护',
    components: { BasicTable, PageWrapper, EditModal, TableAction },
    setup() {
      const { t } = useI18n();
      const { createMessage, createConfirm } = useMessage();
      const [registerModal, { openModal }] = useModal();
      const functionItemStore = useFunctionItemStore();
	  const tableData = ref<Any>;
     //表格
      const [registerTable, { reload, getSelectRowKeys }] = useTable({
        title: t('learnpm.pm.pmCompanyFinance.table.title'),
        api: page,
        columns: columns(),
        formConfig: {
          name: 'PmCompanyFinanceSearch',
          labelWidth: 120,
          schemas: searchFormSchema(),
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
          // debugger;
          tableData.value = v;
          //console.log('afterFetch:'+JSON.stringify(tableData.value));
          return v;
        },		
        useSearchForm: true,
        showTableSetting: true,
        bordered: true,
        rowKey: 'id',
        rowSelection: {
          type: 'checkbox',
          columnWidth: 40,
        },
        actionColumn: {
          width: 200,
          title: t('common.column.action'),
          dataIndex: 'action',
        },
      });

      // 弹出复制页面
      function handleCopy(record: Recordable, e: Event) {
        e?.stopPropagation();
        openModal(true, {
          record,
          type: ActionEnum.COPY,
        });
      }

      // 弹出新增页面
      function handleAdd() {
        //产生新的交易id
        functionItemStore.setTransactionId(buildUUID());
        console.log('新的交易id:'+functionItemStore.getTransactionId);
        openModal(true, {
          type: ActionEnum.ADD,
        });
      }
     // 弹出查看页面
      function handleView(record: Recordable, e: Event) {
        e?.stopPropagation();
        openModal(true, {
          record,
          type: ActionEnum.VIEW,
        });
      }
      // 弹出编辑页面
      function handleEdit(record: Recordable, e: Event) {
       e?.stopPropagation();
        openModal(true, {
          record,
          type: ActionEnum.EDIT,
        });
      }

      

      async function batchDelete(ids: any[]) {
        await remove(ids);
        createMessage.success(t('common.tips.deleteSuccess'));
        handleSuccess();
      }

      // 点击批量删除
      function handleBatchDelete() {
        const ids = getSelectRowKeys();
        if (!ids || ids.length <= 0) {
          createMessage.warning(t('common.tips.pleaseSelectTheData'));
          return;
        }
        createConfirm({
          iconType: 'warning',
          content: t('common.tips.confirmDelete'),
          onOk: async () => {
            try {
              await batchDelete(ids);
            } catch (e) {}
          },
        });
      }
     //点击单行删除
      function handleDelete(record: Recordable, e: Event) {
        e?.stopPropagation();
        if (record?.id) {
          batchDelete([record.id]);
        }
      }

      function handleSuccess() {
        reload();
      }
      //导出xls
      function exportXls(){
        // console.log('res:'+res);
        // 默认Object.keys(data[0])作为header
        let data ;
        data = tableData.value;
        jsonToSheetXlsx({
          data,
          header: {
            id: 'ID',
            userId: t('learnpm.pm.pmCompanyFinance.userId'),
            phone: t('learnpm.pm.pmCompanyFinance.phone'),
            userName: t('learnpm.pm.pmCompanyFinance.userName'),
            remark: t('learnpm.pm.pmCompanyFinance.remark'),
            isValid: t('learnpm.pm.pmCompanyFinance.isValid'),
            attribute1: t('learnpm.pm.pmCompanyFinance.attribute1'),
            attribute2: t('learnpm.pm.pmCompanyFinance.attribute2'),
            attribute3: t('learnpm.pm.pmCompanyFinance.attribute3'),
            attribute4: t('learnpm.pm.pmCompanyFinance.attribute4'),
            attribute5: t('learnpm.pm.pmCompanyFinance.attribute5'),
            attribute6: t('learnpm.pm.pmCompanyFinance.attribute6'),
            attribute7: t('learnpm.pm.pmCompanyFinance.attribute7'),
            attribute8: t('learnpm.pm.pmCompanyFinance.attribute8'),
            attribute9: t('learnpm.pm.pmCompanyFinance.attribute9'),
            attribute10: t('learnpm.pm.pmCompanyFinance.attribute10'),
            createdTime: t('lamp.common.createdTime'),
            createdBy:t('lamp.common.createBy'),
            updatedBy:t('lamp.common.updateBy'),
            updatedTime:t('lamp.common.updatedTime'),   
          },
          filename: '导出.xlsx',
        });
      }
	  
      return {
       t,
        registerTable,
        registerModal,
        handleView,
        handleAdd,
        handleEdit,
        handleCopy,
        handleDelete,
        handleSuccess,
        handleBatchDelete,
        exportXls,		
      };
    },
  });
</script>
