import {  Ref, ref } from 'vue';
import { BasicColumn, FormSchema } from '/@/components/Table';
import { useI18n } from '/@/hooks/web/useI18n';
import {ActionEnum, DictEnum} from '/@/enums/commonEnum';
import { FormSchemaExt } from '/@/api/lamp/common/formValidateService';
import { dictComponentProps } from '/@/utils/lamp/common';
import { tree } from '/@/api/basic/user/baseOrg';
import { projectType } from '/@/api/learnpm/ms/msProjectTypeSettings';
const { t } = useI18n();
// 列表页字段
export const columns = (): BasicColumn[] => {
  return [
    {
      title: t('learnpm.pm.pmProject.projectName'),
      dataIndex: 'projectName',
    },
    {
      title: t('learnpm.pm.pmProject.projectCode'),
      dataIndex: 'projectCode',
    },

    {
      title: t('learnpm.pm.pmProject.projectInitiationUnitName'),
      dataIndex: 'projectInitiationUnitName',
    },
    {
      title: t('learnpm.pm.pmProject.projectRecommenderName'),
      dataIndex: 'projectRecommenderName',
    },
   /* {
      title: t('learnpm.pm.pmProject.initiatorName'),
      dataIndex: 'initiatorName',
    },
    {
      title: t('learnpm.pm.pmProject.projectApprovalDepartmentName'),
      dataIndex: 'projectApprovalDepartmentName',
    },*/
    {
      title: t('learnpm.pm.pmProject.academicGuidance'),
      dataIndex: 'academicGuidance',
    },
    {
      title: t('learnpm.pm.pmProject.projectCategoryName'),
      dataIndex: 'projectCategoryName',
    },
    {
      title: t('learnpm.pm.pmProject.projectSummary'),
      dataIndex: 'projectSummary',
    },
    {
      title: t('learnpm.pm.pmProject.projectInitiationCustomerUnitName'),
      dataIndex: 'projectInitiationCustomerUnitName',
    },
    {
      title: t('learnpm.pm.pmProject.projectInitiationYear'),
      dataIndex: 'projectInitiationYear',
    },
    {
      title: t('learnpm.pm.pmProject.customerContact'),
      dataIndex: 'customerContact',
    },
    {
      title: t('learnpm.pm.pmProject.customerContactInfo'),
      dataIndex: 'customerContactInfo',
    },
    {
      title: t('learnpm.pm.pmProject.post'),
      dataIndex: 'post',
    },
    {
      title: t('learnpm.pm.pmProject.thirdPartyName'),
      dataIndex: 'thirdPartyName',
    },
    {
      title: t('learnpm.pm.pmProject.fourthPartyName'),
      dataIndex: 'fourthPartyName',
    },
    {
      title: t('learnpm.pm.pmProject.totalProjectAmount'),
      dataIndex: 'totalProjectAmount',
    },
    {
      title: t('learnpm.pm.pmProject.totalBudgetAmount'),
      dataIndex: 'totalBudgetAmount',
    },
    {
      title: t('learnpm.pm.pmProject.estimatedMeetingTotalNum'),
      dataIndex: 'estimatedMeetingTotalNum',
    },
    {
      title: t('learnpm.pm.pmProject.investmentInvitationLetter'),
      dataIndex: 'investmentInvitationLetter',
    },


    {
      title: t('learnpm.pm.pmProject.other'),
      dataIndex: 'other',
    },
   /* {
      title: t('learnpm.pm.pmProject.complianceDocuments'),
      dataIndex: 'complianceDocuments',
    },*/
    {
      title: t('learnpm.pm.pmProject.postscript'),
      dataIndex: 'postscript',
    },
    {
      title: t('learnpm.pm.pmProject.meetingBudgetOccupied'),
      dataIndex: 'meetingBudgetOccupied',
    },
    {
      title: t('learnpm.pm.pmProject.meetingSchedule'),
      dataIndex: 'meetingSchedule',
    },
    {
      title: t('learnpm.pm.pmProject.completedSessions'),
      dataIndex: 'completedSessions',
    },
    {
      title: t('learnpm.pm.pmProject.actualBudgetSpent'),
      dataIndex: 'actualBudgetSpent',
    },
    {
      title: t('learnpm.pm.pmProject.remainingBudgetAmount'),
      dataIndex: 'remainingBudgetAmount',
    },
    {
      title: t('learnpm.pm.pmProject.consolidatedTaxAmount'),
      dataIndex: ['echoMap','consolidatedTaxAmount'],
    },
    {
      title: t('learnpm.pm.pmProject.budgetOccupationReturnAmount'),
      dataIndex: ['echoMap','budgetOccupationReturnAmount'],
    },
/*    {
      title: t('learnpm.pm.pmProject.projectManagementFeeProportion'),
      dataIndex: 'projectManagementFeeProportion',
    },
    {
      title: t('learnpm.pm.pmProject.projectManagementFeeAmount'),
      dataIndex: 'projectManagementFeeAmount',
    },

    {
      title: t('learnpm.pm.pmProject.foundationManagementFee'),
      dataIndex: 'foundationManagementFee',
    },
    {
      title: t('learnpm.pm.pmProject.taxRate'),
      dataIndex: 'taxRate',
    },
    {
      title: t('learnpm.pm.pmProject.taxAmount'),
      dataIndex: 'taxAmount',
    },
    {
      title: t('learnpm.pm.pmProject.totalAmountAfterProjectDiscount'),
      dataIndex: 'totalAmountAfterProjectDiscount',
    },*/
    {
      title: t('learnpm.pm.pmProject.meetingPlanNum'),
      dataIndex: 'meetingPlanNum',
    },
    {
      title: t('learnpm.pm.pmProject.appliedNum'),
      dataIndex: 'appliedNum',
    },
    {
      title: t('learnpm.pm.pmProject.appliedAmount'),
      dataIndex: 'appliedAmount',
    },
    {
      title: t('learnpm.pm.pmProject.projectStauts'),
      dataIndex: ['echoMap','projectStauts'],
    },
    {
      title: t('learnpm.pm.pmProject.meetingPlanningStatus'),
      dataIndex: ['echoMap','meetingPlanningStatus'],
    },
    {
      title: t('learnpm.pm.pmProject.projectSource'),
      dataIndex: ['echoMap','projectSource'],
    },
    {
      title: t('learnpm.pm.pmProject.adjustStatus'),
      dataIndex: ['echoMap','adjustStatus'],
    },

    {
      title: t('lamp.common.createdTime'),
      dataIndex: 'createdTime',
      sorter: true,
      width: 180,
    },
  ];
};
// 列表页字段
export const schemaindColumns = (): BasicColumn[] => {
  return [
    {
      title: t('learnpm.pm.pmProject.projectName'),
      dataIndex: 'projectName',
    },
    {
      title: t('learnpm.pm.pmProject.meetingSchedule'),
      dataIndex: 'meetingSchedule',
    },
    {
      title: t('learnpm.pm.pmProject.remainingBudgetAmount'),
      dataIndex: 'remainingBudgetAmount',
    },

  ];
};

export const searchFormSchema = (): FormSchema[] => {
  return [
    {
	  label: t('learnpm.pm.pmProject.projectName'),
	  field: 'projectName',
	  colProps: { span: 6 },
	  component: 'Input',
    },
    {
	  label: t('learnpm.pm.pmProject.projectCode'),
	  field: 'projectCode',
	  colProps: { span: 6 },
	  component: 'Input',
    },

    {
	  label: t('learnpm.pm.pmProject.projectInitiationUnitName'),
	  field: 'projectInitiationUnitName',
	  colProps: { span: 6 },
	  component: 'Input',
    },

    {
	  label: t('learnpm.pm.pmProject.projectRecommenderName'),
	  field: 'projectRecommenderName',
	  colProps: { span: 6 },
	  component: 'Input',
    },

    {
	  label: t('learnpm.pm.pmProject.initiatorName'),
	  field: 'initiatorName',
	  colProps: { span: 6 },
	  component: 'Input',
    },

    {
	  label: t('learnpm.pm.pmProject.projectApprovalDepartmentName'),
	  field: 'projectApprovalDepartmentName',
	  colProps: { span: 6 },
	  component: 'Input',
    },
    {
	  label: t('learnpm.pm.pmProject.academicGuidance'),
	  field: 'academicGuidance',
	  colProps: { span: 6 },
	  component: 'Input',
    },

    {
	  label: t('learnpm.pm.pmProject.projectCategoryName'),
	  field: 'projectCategoryName',
	  colProps: { span: 6 },
	  component: 'Input',
    },
    {
	  label: t('learnpm.pm.pmProject.projectSummary'),
	  field: 'projectSummary',
	  colProps: { span: 6 },
	  component: 'Input',
    },

    {
	  label: t('learnpm.pm.pmProject.projectInitiationCustomerUnitName'),
	  field: 'projectInitiationCustomerUnitName',
	  colProps: { span: 6 },
	  component: 'Input',
    },
    {
	  label: t('learnpm.pm.pmProject.projectInitiationYear'),
	  field: 'projectInitiationYear',
	  colProps: { span: 6 },
	  component: 'Input',
    },
    {
	  label: t('learnpm.pm.pmProject.customerContact'),
	  field: 'customerContact',
	  colProps: { span: 6 },
	  component: 'Input',
    },
    {
	  label: t('learnpm.pm.pmProject.customerContactInfo'),
	  field: 'customerContactInfo',
	  colProps: { span: 6 },
	  component: 'Input',
    },
    {
	  label: t('learnpm.pm.pmProject.post'),
	  field: 'post',
	  colProps: { span: 6 },
	  component: 'Input',
    },
    {
	  label: t('learnpm.pm.pmProject.thirdPartyName'),
	  field: 'thirdPartyName',
	  colProps: { span: 6 },
	  component: 'Input',
    },
    {
	  label: t('learnpm.pm.pmProject.fourthPartyName'),
	  field: 'fourthPartyName',
	  colProps: { span: 6 },
	  component: 'Input',
    },
    {
      field: 'createTimeRange',
      label: t('lamp.common.createdTime'),
      component: 'RangePicker',
      colProps: { span: 6 },
    },
  ];
};

export const values = ref([])

// 编辑页字段
export const editFormSchema = (_type: Ref<ActionEnum>, totalAmount,consolidatedAmount,defUserReference): FormSchema[] => {
  return [
    {
      field: 'id',
      label: 'ID',
      component: 'Input',
      show: false,
    },
    {
	  label: t('learnpm.pm.pmProject.projectName'),
	  field: 'projectName',
      colProps: { span: 12 },
	  component: 'Input',
    },
    {
	  label: t('learnpm.pm.pmProject.projectCode'),
	  field: 'projectCode',
      colProps: { span: 12 },
	   //component: 'InputSearch',
       component: 'Input',
      // ifShow: ({ values }) => {
      //   return true;
      // },
      // componentProps: ({ formActionType }) => {
      //   return {
      //     enterButton: '选择',
      //     onSearch: (value: string) => {
      //       defUserReference();
      //       return value;
      //     },
      //   };
      // },
    },
    {
	  label: t('learnpm.pm.pmProject.projectInitiationUnitId'),
	  field: 'projectInitiationUnitId',
	  component: 'Input',
      show: false,
    },
    {
	  label: t('learnpm.pm.pmProject.projectInitiationUnitName'),
	  field: 'projectInitiationUnitName',
      component: 'ApiTreeSelect',
      componentProps: {
        api: tree,
        labelField: 'name',
        valueField: 'id',
        allowClear: true,
        multiple: true,
        filterTreeNode: (input: string, treeNode: any) => {
          return treeNode.name.toUpperCase().indexOf(input.toUpperCase()) >= 0;
        },

        onChange: (val, key) => {
          values.value = val.map((item, index) => {
            return {
              name: key[index],
              value: item
            }
          })
          console.log(values, 'vls---')
        }

      },
      colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.projectRecommenderId'),
	  field: 'projectRecommenderId',
	  component: 'Input',
      show: false,
    },
    {
	  label: t('learnpm.pm.pmProject.projectRecommenderName'),
	  field: 'projectRecommenderName',
      component: 'Input',
 /*     componentProps: {
        api: query,
        showSearch: true,
        onChange: (e) => {
          console.log(e,"2222222222222222222");
        },
        filterOption: (input: string, option: any) => {
         debugger
          return option.label.toUpperCase().indexOf(input.toUpperCase()) >= 0;
        },
      },*/
      colProps: { span: 12 },
    },
   {
	  label: t('learnpm.pm.pmProject.initiatorId'),
	  field: 'initiatorId',
	  component: 'Input',
      show: false,
    },
    {
	  label: t('learnpm.pm.pmProject.initiatorName'),
	  field: 'initiatorName',
      component: 'InputSearch',
      ifShow: ({ values }) => {
        return true;
      },
      componentProps: ({ formActionType }) => {
        return {
          enterButton: '选择',
          onSearch: (value: string) => {
            defUserReference();
            return value;
          },
        };
      },
      colProps: { span: 12 },
    },
    /* {
	  label: t('learnpm.pm.pmProject.projectApprovalDepartmentId'),
	  field: 'projectApprovalDepartmentId',
	  component: 'Input',
      show: false,
    },
    {
	  label: t('learnpm.pm.pmProject.projectApprovalDepartmentName'),
	  field: 'projectApprovalDepartmentName',
      component: 'ApiSelect',
      componentProps: {
        api: tree,
        labelField: 'name',
        valueField: 'id',
        allowClear: true,
        multiple: true,
        filterTreeNode: (input: string, treeNode: any) => {
          return treeNode.name.toUpperCase().indexOf(input.toUpperCase()) >= 0;
        },
      },
      colProps: { span: 12 },
    },*/
    {
	  label: t('learnpm.pm.pmProject.academicGuidance'),
	  field: 'academicGuidance',
	  component: 'Input',colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.projectCategoryId'),
	  field: 'projectCategoryId',
	  component: 'Input',
      show: false,colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.projectCategoryName'),
	  field: 'projectCategoryName',
      component: 'ApiSelect',
      componentProps: {
        api: projectType,
        labelField: 'name',
        valueField: 'id',
        showSearch: true,
        filterOption: (input: string, option: any) => {
          return option.label.toUpperCase().indexOf(input.toUpperCase()) >= 0;
        },
      },colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.projectSummary'),
	  field: 'projectSummary',
	  component: 'Input',colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.projectInitiationCustomerUnitId'),
	  field: 'projectInitiationCustomerUnitId',
	  component: 'Input',
      show: false,colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.projectInitiationCustomerUnitName'),
	  field: 'projectInitiationCustomerUnitName',
	  colProps: { span: 12 },
      // component: 'ApiSelect',
      component: 'Input',
      /*componentProps: {
        api: query,
        labelField: 'username',
        valueField: 'id',
        showSearch: true,
        filterOption: (input: string, option: any) => {
          return option.label.toUpperCase().indexOf(input.toUpperCase()) >= 0;
        },
      },*/
    },
    {
	  label: t('learnpm.pm.pmProject.projectInitiationYear'),
	  field: 'projectInitiationYear',
	  component: 'Input',colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.customerContact'),
	  field: 'customerContact',
	  component: 'Input',colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.customerContactInfo'),
	  field: 'customerContactInfo',
	  component: 'Input',colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.post'),
	  field: 'post',
	  component: 'Input',colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.thirdPartyName'),
	  field: 'thirdPartyName',
	  component: 'Input',colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.fourthPartyName'),
	  field: 'fourthPartyName',
	  component: 'Input',colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.totalProjectAmount'),
	  field: 'totalProjectAmount',
	  colProps: { span: 12 },
      component: 'InputSearch',
      ifShow: ({  }) => {
        return true;
      },
      componentProps: ({ }) => {
        return {
          onBlur: (value: string) => {
            totalAmount(value);
            return value;
          },
        };
      },
    },
    {
	  label: t('learnpm.pm.pmProject.consolidatedTaxAmount'),
	  field: 'consolidatedTaxAmount',
	 colProps: { span: 12 },
      component: 'InputSearch',
      ifShow: ({  }) => {
        return true;
      },
      componentProps: ({ }) => {
        return {
          onBlur: (value: string) => {
            consolidatedAmount(value);
            return value;
          },
        };
      },
    },
    {
	  label: t('learnpm.pm.pmProject.totalBudgetAmount'),
	  field: 'totalBudgetAmount',
	  component: 'Input',colProps: { span: 12 },dynamicDisabled:true
    },
    {
	  label: t('learnpm.pm.pmProject.estimatedMeetingTotalNum'),
	  field: 'estimatedMeetingTotalNum',
	  component: 'Input',colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.investmentInvitationLetter'),
	  field: 'investmentInvitationLetter',
	  component: 'InputTextArea',colProps: { span: 12 },
    },


    {
	  label: t('learnpm.pm.pmProject.other'),
	  field: 'other',
	  component: 'InputTextArea',colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.postscript'),
	  field: 'postscript',
	  component: 'InputTextArea',colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.meetingBudgetOccupied'),
	  field: 'meetingBudgetOccupied',
      show: false,
	  component: 'Input',colProps: { span: 12 },
    },
    {
	  label: t('learnpm.pm.pmProject.projectStauts'),
	  field: 'projectStauts',
	  component: 'ApiSelect',
	  componentProps: {
        ...dictComponentProps(DictEnum.LEARNPM_PROJECT_STAUTS),
      },
      show: false,
    },
    {
	  label: t('learnpm.pm.pmProject.meetingPlanningStatus'),
	  field: 'meetingPlanningStatus',
	  component: 'ApiSelect',
	  componentProps: {
        ...dictComponentProps(DictEnum.LEARNPM_MEETING_PLANNING_STATUS),
      },
      show: false,
    },
    {
	  label: t('learnpm.pm.pmProject.projectSource'),
	  field: 'projectSource',
	  component: 'ApiSelect',
      show: false,
	  componentProps: {
        ...dictComponentProps(DictEnum.LEARNPM_PROJECT_SOURCE),
      },
    },
    {
	  label: t('learnpm.pm.pmProject.adjustStatus'),
	  field: 'adjustStatus',
	  component: 'ApiSelect',
	  componentProps: {
        ...dictComponentProps(DictEnum.LEARNPM_ADJUST_STATUS),
      },
      show: false,
    },
  ];
};

export const searchFormSchemaind = (): FormSchema[] => {
  return [
    {
      label: t('learnpm.pm.pmProject.projectName'),
      field: 'projectName',
      colProps: { span: 6 },
      component: 'Input',
    },
  /*  {
      label: t('learnpm.pm.pmProject.projectCode'),
      field: 'projectCode',
      colProps: { span: 6 },
      component: 'Input',
    },*/
  ];
};
// 前端自定义表单验证规则
export const customFormSchemaRules = (_): Partial<FormSchemaExt>[] => {
  return [
];
};
