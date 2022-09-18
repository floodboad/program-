import { useI18n } from '/@/hooks/web/useI18n';
import { VxeGridPropTypes } from 'vxe-table';
import { FormSchemaExt } from '/@/api/lamp/common/formValidateService';

const { t } = useI18n();

export const formItems = () => {
  return [

    {
      field: 'complianceMaterialsName',
      title: t('learnpm.pm.pmComplianceMaterials.complianceMaterialsName'),
      span: 6,
      folding: false,
      itemRender: {
	   name: '$input',
	  props: { placeholder: '请输入合规材料名称' } },
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
      field: 'complianceMaterialsName',
      title: t('learnpm.pm.pmComplianceMaterials.complianceMaterialsName'),
      editRender: {	  name: '$input',
attrs: { placeholder: '请输入合规材料名称' } },
    },
    {
      field: 'illustrate',
      title: t('learnpm.pm.pmComplianceMaterials.illustrate'),
      editRender: {	  name: '$input',
attrs: { placeholder: '请输入说明' } },
    },
    {
      field: 'isValid',
      title: t('learnpm.pm.pmComplianceMaterials.isValid'),
      editRender: {
	    name: '$select',
	    options: [],
	    props: { placeholder: '请选择是否有效' } },
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

