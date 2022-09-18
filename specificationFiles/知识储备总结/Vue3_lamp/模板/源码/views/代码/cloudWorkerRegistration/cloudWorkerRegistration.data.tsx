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
    title: t('paigongyun.cloud.cloudWorkerRegistration.name'),
    dataIndex: 'name',
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.idNumber'),
    dataIndex: 'idNumber',
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.nativePlace'),
    dataIndex: 'nativePlace',
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.cloudWorkTypeConfId'),
    dataIndex: 'cloudWorkTypeConfId',
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.workTypeName'),
    dataIndex: 'workTypeName',
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.education'),
	dataIndex: ['echoMap','education'],
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.frontIdCard'),
    dataIndex: 'frontIdCard',
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.backIdCard'),
    dataIndex: 'backIdCard',
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
    title: t('paigongyun.cloud.cloudWorkerRegistration.name'),
    dataIndex: 'name',
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.idNumber'),
    dataIndex: 'idNumber',
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.nativePlace'),
    dataIndex: 'nativePlace',
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.cloudWorkTypeConfId'),
    dataIndex: 'cloudWorkTypeConfId',
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.workTypeName'),
    dataIndex: 'workTypeName',
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.education'),
	dataIndex: ['echoMap','education'],
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.frontIdCard'),
    dataIndex: 'frontIdCard',
  },
  {
    title: t('paigongyun.cloud.cloudWorkerRegistration.backIdCard'),
    dataIndex: 'backIdCard',
  },
  {
    title: t('lamp.common.createdTime'),
    dataIndex: 'createdTime',
    sorter: true,
    width: 180,
  },
  ];
};

// 列表页搜索表单字段,用于弹出对话框参照
export const userSearchFormSchema: FormSchema[] = [
  {
    field: 'name',
    label: t('paigongyun.cloud.cloudWorkerRegistration.name'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'idNumber',
    label: t('paigongyun.cloud.cloudWorkerRegistration.idNumber'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'nativePlace',
    label: t('paigongyun.cloud.cloudWorkerRegistration.nativePlace'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'cloudWorkTypeConfId',
    label: t('paigongyun.cloud.cloudWorkerRegistration.cloudWorkTypeConfId'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'workTypeName',
    label: t('paigongyun.cloud.cloudWorkerRegistration.workTypeName'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'education',
    label: t('paigongyun.cloud.cloudWorkerRegistration.education'),
    colProps: { span: 6 },
    component: 'ApiSelect',
	componentProps: {
        ...dictComponentProps(DictEnum.PAIGONGYUN_EDUCATION),
      }, 
  },
  {
    field: 'frontIdCard',
    label: t('paigongyun.cloud.cloudWorkerRegistration.frontIdCard'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'backIdCard',
    label: t('paigongyun.cloud.cloudWorkerRegistration.backIdCard'),
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
export const searchFormSchema = (): FormSchema[] =>{
return  [
  {
    field: 'name',
    label: t('paigongyun.cloud.cloudWorkerRegistration.name'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'idNumber',
    label: t('paigongyun.cloud.cloudWorkerRegistration.idNumber'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'nativePlace',
    label: t('paigongyun.cloud.cloudWorkerRegistration.nativePlace'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'cloudWorkTypeConfId',
    label: t('paigongyun.cloud.cloudWorkerRegistration.cloudWorkTypeConfId'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'workTypeName',
    label: t('paigongyun.cloud.cloudWorkerRegistration.workTypeName'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'education',
    label: t('paigongyun.cloud.cloudWorkerRegistration.education'),
    colProps: { span: 6 },
    component: 'ApiSelect',
	componentProps: {
        ...dictComponentProps(DictEnum.PAIGONGYUN_EDUCATION),
      }, 
  },
  {
    field: 'frontIdCard',
    label: t('paigongyun.cloud.cloudWorkerRegistration.frontIdCard'),
    colProps: { span: 6 },
    component: 'Input',
  },
  {
    field: 'backIdCard',
    label: t('paigongyun.cloud.cloudWorkerRegistration.backIdCard'),
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
// 编辑页字段
 
  
export const editFormSchema = (_type: Ref<ActionEnum>,cloudWorkTypeConfReference): FormSchema[] => {
  return [
  {
    field: 'id',
    label: 'ID',
    component: 'Input',
    required: false,
    show: false,
  },
  {
    field: 'name',
    label: t('paigongyun.cloud.cloudWorkerRegistration.name'),
    component: 'Input',
  },
  {
    field: 'idNumber',
    label: t('paigongyun.cloud.cloudWorkerRegistration.idNumber'),
    component: 'Input',
  },
  {
    field: 'nativePlace',
    label: t('paigongyun.cloud.cloudWorkerRegistration.nativePlace'),
    component: 'Input',
  },
  {
    field: 'cloudWorkTypeConfId',
    label: t('paigongyun.cloud.cloudWorkerRegistration.cloudWorkTypeConfId'),
      component: 'InputSearch',
      colProps: {
        span: 12,
      },
      ifShow: ({ values }) => {
        return true;
      },
      componentProps: ({ formActionType }) => {
        return {
          enterButton: '选择',
          onSearch: (value: string) => {
		  cloudWorkTypeConfReference();
            return value;
          },
        };
      },	
  },
  {
    field: 'workTypeName',
    label: t('paigongyun.cloud.cloudWorkerRegistration.workTypeName'),
    component: 'Input',
  },
  {
    field: 'education',
    label: t('paigongyun.cloud.cloudWorkerRegistration.education'),
    component: 'ApiSelect',
    componentProps: {
        ...dictComponentProps(DictEnum.PAIGONGYUN_EDUCATION),
      },
  },
  {
    field: 'frontIdCard',
    label: t('paigongyun.cloud.cloudWorkerRegistration.frontIdCard'),
    component: 'Input',
  },
  {
    field: 'backIdCard',
    label: t('paigongyun.cloud.cloudWorkerRegistration.backIdCard'),
    component: 'Input',
  },
];
};
// 前端自定义表单验证规则
export const customFormSchemaRules = (_): Partial<FormSchemaExt>[] => {
  return [
  ];
};
