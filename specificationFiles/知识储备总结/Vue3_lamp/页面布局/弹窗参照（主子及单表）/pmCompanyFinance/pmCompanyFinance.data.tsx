import { Ref } from 'vue';
import { dateUtil } from '/@/utils/dateUtil';
import { BasicColumn, FormSchema } from '/@/components/Table';
import { useI18n } from '/@/hooks/web/useI18n';
import { ActionEnum,DictEnum } from '/@/enums/commonEnum';
import { FormSchemaExt } from '/@/api/lamp/common/formValidateService';
import { dictComponentProps } from '/@/utils/lamp/common';

const { t } = useI18n();
// 列表页字段,用于弹出对话框参照
export const userColumns: BasicColumn[] = [
  {
    title: t('learnpm.pm.pmCompanyFinance.userId'),
    dataIndex: 'userId',
	ifShow:false,
  },
  {
    title: t('learnpm.pm.pmCompanyFinance.phone'),
    dataIndex: 'phone',
  },
  {
    title: t('learnpm.pm.pmCompanyFinance.userName'),
    dataIndex: 'userName',
  },
  {
    title: t('learnpm.pm.pmCompanyFinance.remark'),
    dataIndex: 'remark',
  },
  {
    title: t('learnpm.pm.pmCompanyFinance.isValid'),
	dataIndex: ['echoMap','isValid'],
  },
  {
    title: t('lamp.common.createdTime'),
    dataIndex: 'createdTime',
    sorter: true,
    width: 180,
  },
 ];
// 列表页字段
export const columns = (): BasicColumn[] => {
    return [
  {
    title: t('learnpm.pm.pmCompanyFinance.userId'),
    dataIndex: 'userId',
	ifShow:false,
  },
  {
    title: t('learnpm.pm.pmCompanyFinance.phone'),
    dataIndex: 'phone',
  },
  {
    title: t('learnpm.pm.pmCompanyFinance.userName'),
    dataIndex: 'userName',
  },
  {
    title: t('learnpm.pm.pmCompanyFinance.remark'),
    dataIndex: 'remark',
  },
  {
    title: t('learnpm.pm.pmCompanyFinance.isValid'),
	dataIndex: ['echoMap','isValid'],
  },
  // {
  //   title: t('lamp.common.createdTime'),
  //   dataIndex: 'createdTime',
  //   sorter: true,
  //   width: 180,
  // },
  ];
};

// 列表页搜索表单字段,用于弹���对话框参照
export const userSearchFormSchema: FormSchema[] = [
  {
    field: 'phone',
    label: t('learnpm.pm.pmCompanyFinance.phone'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'userName',
    label: t('learnpm.pm.pmCompanyFinance.userName'),
    colProps: { span: 6 },
    component: 'Input',
  },
  // {
  //   field: 'remark',
  //   label: t('learnpm.pm.pmCompanyFinance.remark'),
  //   colProps: { span: 6 },
  //   component: 'Input',
  // },
  {
    field: 'isValid',
    label: t('learnpm.pm.pmCompanyFinance.isValid'),
    colProps: { span: 6 },
    component: 'ApiSelect',
	componentProps: {
        ...dictComponentProps(DictEnum.LEARNPM_IS_VALID),
      }, 
  },
//  {
//       field: 'createTimeRange',
//       label: t('lamp.common.createdTime'),
//       component: 'RangePicker',
//       colProps: { span: 6 },
//     },
];
export const searchFormSchema = (): FormSchema[] =>{
return  [
  {
    field: 'phone',
    label: t('learnpm.pm.pmCompanyFinance.phone'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'userName',
    label: t('learnpm.pm.pmCompanyFinance.userName'),
    colProps: { span: 6 },
    component: 'Input',
  },
  // {
  //   field: 'remark',
  //   label: t('learnpm.pm.pmCompanyFinance.remark'),
  //   colProps: { span: 6 },
  //   component: 'Input',
  // },
  {
    field: 'isValid',
    label: t('learnpm.pm.pmCompanyFinance.isValid'),
    colProps: { span: 6 },
    component: 'ApiSelect',
	componentProps: {
        ...dictComponentProps(DictEnum.LEARNPM_IS_VALID),
      }, 
  },
//  {
//       field: 'createTimeRange',
//       label: t('lamp.common.createdTime'),
//       component: 'RangePicker',
//       colProps: { span: 6 },
//     },
];
};
// 编辑页字段
  
export const editFormSchema = (_type: Ref<ActionEnum>,defUserReference): FormSchema[] => {
  return [
  {
    field: 'id',
    label: 'ID',
    component: 'Input',
    required: false,
    show: false,
  },
  {
    field: 'userId',
    label: t('learnpm.pm.pmCompanyFinance.userId'),
    component: 'Input',
    required: false,
    show: false,
  },
  {
    field: 'phone',
    label: t('learnpm.pm.pmCompanyFinance.phone'),
    colProps: { span: 12 },
    component: 'Input',
	  required: false,
  },
  {
    field: 'userName',
    label: t('learnpm.pm.pmCompanyFinance.userName'),
    component: 'InputSearch',
    colProps: { span: 12 },
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
	required: false,
  },
  {
    field: 'remark',
    label: t('learnpm.pm.pmCompanyFinance.remark'),
    component: 'Input',
    colProps: { span: 12 },
	required: false,
  },
  {
    field: 'isValid',
    label: t('learnpm.pm.pmCompanyFinance.isValid'),
    component: 'ApiSelect',
    componentProps: {
        ...dictComponentProps(DictEnum.LEARNPM_IS_VALID),
      },
    colProps: { span: 12 },
  },
];
};
// 前端自定义表单验证规则
export const customFormSchemaRules = (_): Partial<FormSchemaExt>[] => {
  return [
  ];
};
