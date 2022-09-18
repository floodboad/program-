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
  </BasicModal>
  <template>
    <DefUser @register="registerDefUserModal" @success="handleDefUserSelect" ref="defUserRef" />
  </template>
</template>
<script lang="ts">
  import { defineComponent, ref, unref } from 'vue';
  import DefUser from '../pmCompanyFinance/reference/defUser.vue';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { BasicForm, useForm } from '/@/components/Form/index';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { useI18n } from '/@/hooks/web/useI18n';
  import { ActionEnum, VALIDATE_API } from '/@/enums/commonEnum';
  import { getValidateRules } from '/@/api/lamp/common/formValidateService';
  import { Api, save, update } from '/@/api/learnpm/pm/pmCompanyFinance';
  import { customFormSchemaRules, editFormSchema } from './pmCompanyFinance.data';
  import { useModal } from '/@/components/Modal';
  import { buildUUID } from '/@/utils/uuid';
  import { useFunctionItemStore } from '/@/store/modules/function';

  export default defineComponent({
    name: '编辑公司财务人员',
    components: { BasicModal, BasicForm, DefUser },
    emits: ['success', 'register'],
    setup(_, { emit }) {
      const visible = ref<boolean>(false);
      const { t } = useI18n();
      const type = ref<ActionEnum>(ActionEnum.ADD);
      const { createMessage } = useMessage();
      const id = ref('');
      const functionItemStore = useFunctionItemStore();
      const defUserRef = ref<any>(null);
      const [registerDefUserModal, { openModal: openDefUserModal }] = useModal();

      const [
        registerForm,
        { setFieldsValue, resetFields, updateSchema, validate, resetSchema, getFieldsValue },
      ] = useForm({
        name: 'PmCompanyFinanceEdit',
        labelWidth: 100,
        schemas: editFormSchema(type, defUserReference),
        showActionButtonGroup: false,
        disabled: (_) => {
          return unref(type) === ActionEnum.VIEW;
        },
        baseColProps: { span: 24 },
        actionColOptions: {
          span: 23,
        },
      });

      const [registerModel, { setModalProps: setProps, closeModal: close }] = useModalInner(
        async (data) => {
          setProps({ confirmLoading: false });
          await resetSchema(editFormSchema(type, defUserReference));
          await resetFields();
          type.value = data?.type || ActionEnum.ADD;

          if (unref(type) !== ActionEnum.ADD) {
            // 赋值
            const record = { ...data?.record };
            id.value = record.id;
            await setFieldsValue(record);
          }

          if (unref(type) !== ActionEnum.VIEW) {
            let validateApi = Api[VALIDATE_API[unref(type)]];
            await getValidateRules(validateApi, customFormSchemaRules(type)).then(async (rules) => {
              rules && rules.length > 0 && (await updateSchema(rules));
            });
          }
        },
      );
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
        } catch (err) {
          //产生新的交易id
          functionItemStore.setTransactionId(buildUUID());
          createMessage.error('操作失败!');
        } finally {
          setProps({ confirmLoading: false });
        }
      }

      function defUserReference() {
        visible.value = true;
        var data = { record: { id: id.value } };
        //console.log('record:'+JSON.stringify(data));
        openDefUserModal(true, data);
      }

      function handleDefUserSelect() {
        //debugger;
        //TODO:根据业务需求，自己回填字段
        if (defUserRef.value.selectRowList.length > 0) {
          const params = getFieldsValue();
          //console.log('params :' + JSON.stringify(params));
          params.phone = defUserRef.value.selectRowList[0].mobile;
          params.userName = defUserRef.value.selectRowList[0].username;
          visible.value = false;
          setFieldsValue(params);
          //console.log('handleSelect first row id :' + msLongzhuExpenseTypeRef.value.selectRowList[0].id);
        }
      }

      return {
        type,
        t,
        registerModel,
        registerForm,
        handleSubmit,
        handleDefUserSelect,
        defUserReference,
        visible,
        defUserRef,
        registerDefUserModal,
      };
    },
  });
</script>
