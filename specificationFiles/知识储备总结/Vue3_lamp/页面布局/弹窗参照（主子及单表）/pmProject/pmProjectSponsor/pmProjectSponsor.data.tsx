import { useI18n } from '/@/hooks/web/useI18n';
import { VxeGridPropTypes } from 'vxe-table';
import { FormSchemaExt } from '/@/api/lamp/common/formValidateService';

const { t } = useI18n();

export const formItems = () => {
 /* return [
    {
      field: 'sponsorName',
      title: t('learnpm.pm.pmProjectSponsor.sponsorName'),
      span: 6,
      folding: false,
      itemRender: {
	   name: '$input',
	  props: { placeholder: '请输入赞助企业名称' } },
    },
    {
      field: 'contacts',
      title: t('learnpm.pm.pmProjectSponsor.contacts'),
      span: 6,
      folding: false,
      itemRender: {
	   name: '$input',
	  props: { placeholder: '请输入联系人' } },
    },
    {
      field: 'contactNumber',
      title: t('learnpm.pm.pmProjectSponsor.contactNumber'),
      span: 6,
      folding: false,
      itemRender: {
	   name: '$input',
	  props: { placeholder: '请输入联系电话' } },
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
  ];*/
};

export const columns = (): VxeGridPropTypes.Columns => {
  return [
    { type: 'checkbox', width: 50, fixed: 'left' },
    { type: 'seq', width: 40, fixed: 'left' },
    {
      field: 'sponsorName',
      title: t('learnpm.pm.pmProjectSponsor.sponsorName'),
      editRender: {	  name: '$input',
attrs: { placeholder: '请输入赞助企业名称' } },
    },
    {
      field: 'amountMoney',
      title: t('learnpm.pm.pmProjectSponsor.amountMoney'),
      editRender: {	  name: '$input',
attrs: { placeholder: '请输入金额' } },
    },
    {
      field: 'taxation',
      title: t('learnpm.pm.pmProjectSponsor.taxation'),
      editRender: {	  name: '$input',
attrs: { placeholder: '请输入税费' } },
    },
    {
      field: 'managementExpense',
      title: t('learnpm.pm.pmProjectSponsor.managementExpense'),
      editRender: {	  name: '$input',
attrs: { placeholder: '请输入管理费' } },
    },
    {
      field: 'systemMaintenanceCost',
      title: t('learnpm.pm.pmProjectSponsor.systemMaintenanceCost'),
      editRender: {	  name: '$input',
attrs: { placeholder: '请输入系统维护费' } },
    },
    {
      field: 'contacts',
      title: t('learnpm.pm.pmProjectSponsor.contacts'),
      editRender: {	  name: '$input',
attrs: { placeholder: '请输入联系人' } },
    },
    {
      field: 'contactNumber',
      title: t('learnpm.pm.pmProjectSponsor.contactNumber'),
      editRender: {	  name: '$input',
attrs: { placeholder: '请输入联系电话' } },
    },
   /* {
      field: 'attachment',
      title: t('learnpm.pm.pmProjectSponsor.attachment'),
      editRender: {	  name: '$input',
attrs: { placeholder: '请输入附件' } },
    },
    {
      field: 'createdTime',
      title: t('lamp.common.createdTime'),
      sortable: true,
      width: 180,
    },*/
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

