<template>
  <PageWrapper dense contentFullHeight>
    <BasicTable @register="registerTable">
      <template #toolbar>
        <a-button
          type="primary"
          color="error"
          preIcon="ant-design:delete-outlined"
          @click="handleBatchDelete"
          v-hasAnyPermission="['learnpm:pm:pmProject:delete']"
        >
          {{ t('common.title.delete') }}
        </a-button>
        <a-button
          type="primary"
          preIcon="ant-design:plus-outlined"
          @click="handleAdd"
          v-hasAnyPermission="['learnpm:pm:pmProject:add']"
        >
          {{ t('common.title.add') }}
        </a-button>
      <!--  <a-button
          type="primary"
          preIcon="ant-design:export-outlined"
          @click="exportXls"
        >
          {{ t('common.title.export') }}
        </a-button>-->
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
                auth: 'learnpm:pm:pmProject:edit',
               ifShow: record.projectStauts === '01'  || record.projectStauts === '03'
              },
              {
                tooltip: t('common.title.delete'),
                icon: 'ant-design:delete-outlined',
                color: 'error',
                auth: 'learnpm:pm:pmProject:delete',
                 ifShow: record.projectStauts === '01'  || record.projectStauts === '03',
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
  import { copy, page, remove } from '/@/api/learnpm/pm/pmProject';
  import { columns, searchFormSchema } from './pmProject.data';
  import EditModal from './tabpaneindex.vue';
  import { useFunctionItemStore } from '/@/store/modules/function';
  import {buildUUID} from '/@/utils/uuid.ts';
  import { jsonToSheetXlsx } from '/@/components/Excel';

  export default defineComponent({
    // 若需要开启页面缓存，请将此参数跟菜单名保持一致
    name: '项目信息',
    components: {
      BasicTable,
      PageWrapper,
      TableAction,
      EditModal,
    },
    setup() {
      const { t } = useI18n();
      const { createMessage, createConfirm } = useMessage();
      const [registerModal, { openModal }] = useModal();
      const functionItemStore = useFunctionItemStore();
      const { replace } = useRouter();
	  const tableData = ref<any>;
      // 表格
      const [registerTable, { reload, getSelectRowKeys }] = useTable({
        title: t('learnpm.pm.pmProject.table.title'),
        api: page,
        columns: columns(),
        formConfig: {
          name: 'PmProjectSearch',
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

      async function batchDelete(ids: string[]) {
        await remove(ids);
        createMessage.success(t('common.tips.deleteSuccess'));
        handleSuccess();
      }

      // 点击单行删除
      function handleDelete(record: Recordable, e: Event) {
        e?.stopPropagation();
        if (record?.id) {
          batchDelete([record.id]);
        }
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
            projectName: t('learnpm.pm.pmProject.projectName'),
            projectCode: t('learnpm.pm.pmProject.projectCode'),
            projectInitiationUnitId: t('learnpm.pm.pmProject.projectInitiationUnitId'),
            projectInitiationUnitName: t('learnpm.pm.pmProject.projectInitiationUnitName'),
            projectRecommenderId: t('learnpm.pm.pmProject.projectRecommenderId'),
            projectRecommenderName: t('learnpm.pm.pmProject.projectRecommenderName'),
            initiatorId: t('learnpm.pm.pmProject.initiatorId'),
            initiatorName: t('learnpm.pm.pmProject.initiatorName'),
            projectApprovalDepartmentId: t('learnpm.pm.pmProject.projectApprovalDepartmentId'),
            projectApprovalDepartmentName: t('learnpm.pm.pmProject.projectApprovalDepartmentName'),
            academicGuidance: t('learnpm.pm.pmProject.academicGuidance'),
            projectCategoryId: t('learnpm.pm.pmProject.projectCategoryId'),
            projectCategoryName: t('learnpm.pm.pmProject.projectCategoryName'),
            projectSummary: t('learnpm.pm.pmProject.projectSummary'),
            projectInitiationCustomerUnitId: t('learnpm.pm.pmProject.projectInitiationCustomerUnitId'),
            projectInitiationCustomerUnitName: t('learnpm.pm.pmProject.projectInitiationCustomerUnitName'),
            projectInitiationYear: t('learnpm.pm.pmProject.projectInitiationYear'),
            customerContact: t('learnpm.pm.pmProject.customerContact'),
            customerContactInfo: t('learnpm.pm.pmProject.customerContactInfo'),
            post: t('learnpm.pm.pmProject.post'),
            thirdPartyName: t('learnpm.pm.pmProject.thirdPartyName'),
            fourthPartyName: t('learnpm.pm.pmProject.fourthPartyName'),
            totalProjectAmount: t('learnpm.pm.pmProject.totalProjectAmount'),
            totalBudgetAmount: t('learnpm.pm.pmProject.totalBudgetAmount'),
            estimatedMeetingTotalNum: t('learnpm.pm.pmProject.estimatedMeetingTotalNum'),
            investmentInvitationLetter: t('learnpm.pm.pmProject.investmentInvitationLetter'),
            schedule: t('learnpm.pm.pmProject.schedule'),
            meetingNotify: t('learnpm.pm.pmProject.meetingNotify'),
            other: t('learnpm.pm.pmProject.other'),
            complianceDocuments: t('learnpm.pm.pmProject.complianceDocuments'),
            postscript: t('learnpm.pm.pmProject.postscript'),
            meetingBudgetOccupied: t('learnpm.pm.pmProject.meetingBudgetOccupied'),
            meetingSchedule: t('learnpm.pm.pmProject.meetingSchedule'),
            completedSessions: t('learnpm.pm.pmProject.completedSessions'),
            actualBudgetSpent: t('learnpm.pm.pmProject.actualBudgetSpent'),
            remainingBudgetAmount: t('learnpm.pm.pmProject.remainingBudgetAmount'),
            projectManagementFeeProportion: t('learnpm.pm.pmProject.projectManagementFeeProportion'),
            projectManagementFeeAmount: t('learnpm.pm.pmProject.projectManagementFeeAmount'),
            projectImplExpensesTaxRate: t('learnpm.pm.pmProject.projectImplExpensesTaxRate'),
            projectImplExpensesTaxAmount: t('learnpm.pm.pmProject.projectImplExpensesTaxAmount'),
            totalProjectImplCost: t('learnpm.pm.pmProject.totalProjectImplCost'),
            totalExecutionLaborCost: t('learnpm.pm.pmProject.totalExecutionLaborCost'),
            foundationManagementFeeProportion: t('learnpm.pm.pmProject.foundationManagementFeeProportion'),
            foundationManagementFee: t('learnpm.pm.pmProject.foundationManagementFee'),
            taxRate: t('learnpm.pm.pmProject.taxRate'),
            taxAmount: t('learnpm.pm.pmProject.taxAmount'),
            totalAmountAfterProjectDiscount: t('learnpm.pm.pmProject.totalAmountAfterProjectDiscount'),
            projectStauts: t('learnpm.pm.pmProject.projectStauts'),
            meetingPlanningStatus: t('learnpm.pm.pmProject.meetingPlanningStatus'),
            projectSource: t('learnpm.pm.pmProject.projectSource'),
            adjustStatus: t('learnpm.pm.pmProject.adjustStatus'),
            attribute1: t('learnpm.pm.pmProject.attribute1'),
            attribute2: t('learnpm.pm.pmProject.attribute2'),
            attribute3: t('learnpm.pm.pmProject.attribute3'),
            attribute4: t('learnpm.pm.pmProject.attribute4'),
            attribute5: t('learnpm.pm.pmProject.attribute5'),
            attribute6: t('learnpm.pm.pmProject.attribute6'),
            attribute7: t('learnpm.pm.pmProject.attribute7'),
            attribute8: t('learnpm.pm.pmProject.attribute8'),
            attribute9: t('learnpm.pm.pmProject.attribute9'),
            attribute10: t('learnpm.pm.pmProject.attribute10'),
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
        handleCopy,
        handleEdit,
          handleEditPlan,
        handleDelete,
        handleBatchDelete,
        handleSuccess,
        exportXls
      };
    },
  });
</script>
