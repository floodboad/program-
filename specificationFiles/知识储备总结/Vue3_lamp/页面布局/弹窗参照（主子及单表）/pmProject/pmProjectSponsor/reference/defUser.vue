<template>
  <BasicModal
    v-bind="$attrs"
    okText="确定"
    @register="registerModal"
    title="选择企业信息"
    @ok="handleSubmit"
    :maskClosable="false"
    :keyboard="true"
    width="80%"
  >
    <BasicTable @register="registerTable" />
  </BasicModal>
</template>
<script lang="ts">
  import { defineComponent, ref } from 'vue';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { BasicTable, useTable } from '/@/components/Table';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { useI18n } from '/@/hooks/web/useI18n';
  import { handleFetchParams } from '/@/utils/lamp/common';
  import { page } from '/@/api/learnpm/ms/msPartnerInfoManagement';
  import { userColumns, userSearchFormSchema } from '/@/views/learnpm/ms/msPartnerInfoManagement/msPartnerInfoManagement.data';

  export default defineComponent({
    name: 'defUserModal',
    components: { BasicModal, BasicTable },
    emits: ['success', 'register'],
    setup(_, { emit }) {
      const { t } = useI18n();
      const searchId = ref<string>('');
      const { createMessage } = useMessage();
      const selectRowList = ref([])
      const [registerTable, { reload, clearSelectedRowKeys,getSelectRows }] = useTable({
        title: '选择企业信息',
        api: page,
        columns: userColumns(),
        formConfig: {
          labelWidth: 120,
          schemas: userSearchFormSchema(),
          baseColProps: { xs: 24, sm: 12, md: 12, lg: 12, xl: 8 },
          autoSubmitOnEnter: true,
          resetButtonOptions: {
            preIcon: 'ant-design:rest-outlined',
          },
          submitButtonOptions: {
            preIcon: 'ant-design:search-outlined',
          },
        },
        beforeFetch: handleFetchParams,
        searchInfo: {
          searchId,
        },
        pagination: {
          pageSize: 10,
        },
        useSearchForm: true,
        showTableSetting: true,
        bordered: true,
        immediate: false,
        canResize: false,
        rowKey: 'id',
        rowSelection: {
          type: 'radio',
        },
      });

      const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
        setModalProps({ confirmLoading: false });
        clearSelectedRowKeys();
        searchId.value = data.record.id;
        reload();
      });

      async function handleSubmit() {
        try {
          setModalProps({ confirmLoading: true });
          //debugger;
          selectRowList.value = getSelectRows();
          if (selectRowList.value && selectRowList.value.length > 0) {
            closeModal();
            emit('success');
          } else {
            createMessage.warn('请选择用户信息');
          }
        } finally {
          setModalProps({ confirmLoading: false });
        }
      }

      return { t, registerModal, registerTable, handleSubmit,selectRowList };
    },
  });
</script>
