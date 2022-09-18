import { useI18n } from '/@/hooks/web/useI18n';
import { VxeGridPropTypes } from 'vxe-table';
import { FormSchemaExt } from '/@/api/lamp/common/formValidateService';

const { t } = useI18n();

export const formItems = () => {
  return [
    {
      field: 'name',
      title: t('learnpm.pm.pmProjectStakeholder.name'),
      span: 6,
      folding: false,
      itemRender: {
        name: '$input',
        props: { placeholder: '请输入用户姓名' } },
    },
    {
      field: 'projectRole',
      title: t('learnpm.pm.pmProjectStakeholder.projectRole'),
      span: 6,
      folding: false,
      itemRender: {
        name: '$select',
        options: [],
        props: { placeholder: '请输入项目角色' } },
    },
    {
      field: 'phone',
      title: t('learnpm.pm.pmProjectStakeholder.phone'),
      span: 6,
      folding: false,
      itemRender: {
	   name: '$input',
	  props: { placeholder: '请输入用户手机号' } },
    },

    {
      span: 24,
      align: 'center',
      collapseNode: true,
      itemRender: {
        name: '$buttons',
        children: [
          {
            props: {
              type: 'submit',
              content: t('common.queryText'),
              status: 'primary',
            },
          },
          { props: { type: 'reset', content: t('common.resetText') } },
        ],
      },
    },
  ];
};

export const columns = (): VxeGridPropTypes.Columns => {
  return [
    { type: 'checkbox', width: 50, fixed: 'left' },
    { type: 'seq', width: 40, fixed: 'left' },
    {
      field: 'name',
      title: t('learnpm.pm.pmProjectStakeholder.name'),
      editRender: {	  name: '$input',
        attrs: { placeholder: '请输入用户姓名' } },

    },
    {
      field: 'projectRole',
      title: t('learnpm.pm.pmProjectStakeholder.projectRole'),
      editRender: {
        name: '$select',
        options: [],
        props: { placeholder: '请输入项目角色' } },
    },
    {
      field: 'phone',
      title: t('learnpm.pm.pmProjectStakeholder.phone'),
      editRender: {	  name: '$input',
attrs: { placeholder: '请输入用户手机号' } },
    },
    {
      title: t('common.column.action'),
      width: 160,
      fixed: 'right',
      slots: { default: 'operate' },
    },
  ];
};

export const customFormSchemaRules = (): Partial<FormSchemaExt>[] => {
  return [
];
};

