<template>
  <PageWrapper dense contentFullHeight>
    <BasicTable @register="registerTable">
      <template #toolbar>
        <a-button
          type="primary"
          color="error"
         preIcon="ant-design:delete-outlined"
         @click="handleBatchDelete"
         v-hasAnyPermission="['paigongyun:cloud:cloudWorkerRegistration:delete']"
          >{{ t('common.title.delete') }}</a-button
        >
      <a-button
          type="primary"
          preIcon="ant-design:plus-outlined"
          @click="handleAdd"
          v-hasAnyPermission="['paigongyun:cloud:cloudWorkerRegistration:add']"
          >{{ t('common.title.add') }}</a-button
        >
      
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
              auth: 'paigongyun:cloud:cloudWorkerRegistration:edit',
            },
            {
              tooltip: t('common.title.copy'),
              icon: 'ant-design:copy-outlined',
              onClick: handleCopy.bind(null, record),
              auth: 'paigongyun:cloud:cloudWorkerRegistration:copy',
            },
            {
              tooltip: t('common.title.delete'),
              icon: 'ant-design:delete-outlined',
              color: 'error',
              auth: 'paigongyun:cloud:cloudWorkerRegistration:delete',
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
  import { defineComponent } from 'vue';
  import { useI18n } from '/@/hooks/web/useI18n';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { BasicTable, useTable, TableAction } from '/@/components/Table';
  import { PageWrapper } from '/@/components/Page';
  import { useModal } from '/@/components/Modal';

  import { handleFetchParams } from '/@/utils/lamp/common';

  import { ActionEnum } from '/@/enums/commonEnum';

  import { page, remove } from '/@/api/paigongyun/cloud/cloudWorkerRegistration';
  import EditModal from './Edit.vue';
  import { columns, searchFormSchema } from './cloudWorkerRegistration.data';
  import { useFunctionItemStore } from '/@/store/modules/function';
  import {buildUUID} from '/@/utils/uuid.ts';

  export default defineComponent({
    name: '工人注册管理维护',
    components: { BasicTable, PageWrapper, EditModal, TableAction },
    setup() {
      const { t } = useI18n();
      const { createMessage, createConfirm } = useMessage();
      const [registerModal, { openModal }] = useModal();
      const functionItemStore = useFunctionItemStore();
     //表格
      const [registerTable, { reload, getSelectRowKeys }] = useTable({
        title: t('paigongyun.cloud.cloudWorkerRegistration.table.title'),
        api: page,
        columns: columns(),
        formConfig: {
          name: 'CloudWorkerRegistrationSearch',
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
      };
    },
  });
</script>
