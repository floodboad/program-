<template>
  <vxe-grid ref="xGrid" v-bind="gridOptions" v-on="gridEvents" @cell-click="handles">
    <template #operate="{ row }">
      <PopConfirmButton
        circle
        circleIcon="ant-design:delete-outlined"
        title="确认删除吗？"
        @confirm="removeRowEvent(row)"
      />
    </template>
  </vxe-grid>
  <DefUser @register="registerDefUserModal" @success="handleDefUserSelect" ref="defUserRef" />
</template>
<script lang="ts">
  import { defineComponent, reactive, ref,onMounted } from 'vue';
  import { VxeGridInstance, VxeGridListeners, VxeGridProps, VxeTablePropTypes } from 'vxe-table';
  import { useI18n } from '/@/hooks/web/useI18n';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { PopConfirmButton } from '/@/components/Button';
  import { ActionEnum, VALIDATE_API } from '/@/enums/commonEnum';
  import { getValidateRuleObj } from '/@/api/lamp/common/formValidateService';
  import { Api, page as pageRequest } from '/@/api/learnpm/pm/pmProjectSponsor';
  import { columns, customFormSchemaRules, formItems } from './pmProjectSponsor.data';
  import { jsonToSheetXlsx } from '/@/components/Excel';
  import DefUser from './reference/defUser.vue';
  import { useModal } from '/@/components/Modal';
  export default defineComponent({
    name: '项目赞助企业',
    components: { PopConfirmButton, DefUser },
    setup: function () {
      const { t } = useI18n();
      const { createMessage } = useMessage();
      const pmProjectId = ref<string>('');
        const defUserRef= ref<any>(null);
        const [registerDefUserModal, { openModal:openDefUserModal }] = useModal();
      const typeRef = ref<ActionEnum>(ActionEnum.ADD);
      const xGrid = ref<VxeGridInstance>({});
      const validRules = ref<VxeTablePropTypes.EditRules>({});
      const tableData = ref<any>;

      const gridOptions = reactive<VxeGridProps>({
        id: 'PmProjectSponsor',
        height: 600,
        rowConfig: {
          // 自定义行数据唯一主键的字段名（默认自动生成）
          keyField: 'id',
          // 当鼠标移到行时，是否要高亮当前行
          isHover: true,
        },
        // 自定义列配置项
        customConfig: {
          // 是否启用 localStorage 本地保存，会将列操作状态保留在本地（需要有 id）
          storage: true,
        },
        formConfig: {
          items: formItems(),
        },
        toolbarConfig: {
          perfect: true,
          buttons: [
            { code: 'myInsert', name: '新增' },
            {
              code: 'delete',
              name: '删除',
              status: 'danger',
            },
           /* {
              code: 'exportXls',
              name: '导出'
            },			*/
          ],
        },
        // 分页配置项
        pagerConfig: {
          // pageSize: 10,
        },
        // 数据代理配置项（基于 Promise API）
        proxyConfig: {
          // 只接收Promise，具体实现自由发挥
          ajax: {
            // 当点击工具栏查询按钮或者手动提交指令 query或reload 时会被触发
            query: ({ page, sorts, filters, form }) => {
              const queryParams: any = { model: form  };

              if (!pmProjectId.value) {
                createMessage.warn('请先保存数据');
                return Promise.reject('请先保存数据');
              }
              // 处理排序条件
              const firstSort = sorts[0];
              if (firstSort) {
                queryParams.sort = firstSort.property;
                queryParams.order = firstSort.order;
              }
              queryParams.size = page.pageSize;
              queryParams.current = page.currentPage;
              queryParams.model.pmProjectId = pmProjectId.value;
              // 处理筛选条件
              filters.forEach(({ property, values }) => {
                queryParams[property] = values.join(',');
              });
              return pageRequest(queryParams).then((r) => {
                r.total = Number(r.total);
				//保存导出xls数据
				tableData.value = r.records;
                return r;
              });
            },
          },
        },
        columns: columns(),
        editRules: validRules,
        editConfig: {
          trigger: 'click',
          mode: 'row',
          showStatus: true,
          autoClear: true,
        },
      });

      const gridEvents: VxeGridListeners = {
        toolbarButtonClick({ code }) {
          const $grid = xGrid.value;
          switch (code) {
            case 'myInsert': {
              $grid.insert({
                pmProjectId: pmProjectId.value,
              });
              break;
            }
			case 'delete': {
              $grid.removeCheckboxRow();
              break;
            }
            case 'exportXls':{
              let data ;
              data = tableData.value;
              jsonToSheetXlsx({
                data,
                header: {
                  id: 'ID',
                  pmProjectId: t('learnpm.pm.pmProjectSponsor.pmProjectId'),
                  sponsorId: t('learnpm.pm.pmProjectSponsor.sponsorId'),
                  sponsorName: t('learnpm.pm.pmProjectSponsor.sponsorName'),
                  amountMoney: t('learnpm.pm.pmProjectSponsor.amountMoney'),
                  taxation: t('learnpm.pm.pmProjectSponsor.taxation'),
                  managementExpense: t('learnpm.pm.pmProjectSponsor.managementExpense'),
                  systemMaintenanceCost: t('learnpm.pm.pmProjectSponsor.systemMaintenanceCost'),
                  contacts: t('learnpm.pm.pmProjectSponsor.contacts'),
                  contactNumber: t('learnpm.pm.pmProjectSponsor.contactNumber'),
                  attachment: t('learnpm.pm.pmProjectSponsor.attachment'),
                  attribute1: t('learnpm.pm.pmProjectSponsor.attribute1'),
                  attribute2: t('learnpm.pm.pmProjectSponsor.attribute2'),
                  attribute3: t('learnpm.pm.pmProjectSponsor.attribute3'),
                  attribute4: t('learnpm.pm.pmProjectSponsor.attribute4'),
                  attribute5: t('learnpm.pm.pmProjectSponsor.attribute5'),
                  attribute6: t('learnpm.pm.pmProjectSponsor.attribute6'),
                  attribute7: t('learnpm.pm.pmProjectSponsor.attribute7'),
                  attribute8: t('learnpm.pm.pmProjectSponsor.attribute8'),
                  attribute9: t('learnpm.pm.pmProjectSponsor.attribute9'),
                  attribute10: t('learnpm.pm.pmProjectSponsor.attribute10'),
                  createdTime: t('lamp.common.createdTime'),
                  createdBy:t('lamp.common.createBy'),
                  updatedBy:t('lamp.common.updateBy'),
                  updatedTime:t('lamp.common.updatedTime'),
                },
                filename: '导出.xlsx',
              });
			  break;
            }
          }
        },
      };

      const getRecordset = () => {
        const $grid = xGrid.value;
        const recordset = $grid.getRecordset();
        if (typeRef.value === ActionEnum.COPY) {
          return { insertRecords: $grid.getData() };
        }
        return recordset;
      };

      const fullValidate = () => {
        const $grid = xGrid.value;
        return $grid.fullValidate();
      };

      async function load(type: ActionEnum, tId?: string) {
        pmProjectId.value = '';
        typeRef.value = type;
        if (type !== ActionEnum.ADD) {
          pmProjectId.value = tId || '';
          reload();
        }

        if (type !== ActionEnum.VIEW) {
          let validateApi = Api[VALIDATE_API[type]];
          const rules = await getValidateRuleObj(validateApi, customFormSchemaRules());
          const $grid = xGrid.value;
          $grid && rules && (validRules.value = rules);
        }
      }

      const insertEvent = async (row: any) => {
        const $grid = xGrid.value;
        const record = {
          pmProjectId: pmProjectId.value,
        };
        const { row: newRow } = await $grid.insertAt(record, row);
        await $grid.setActiveCell(newRow, 'key');
      };

      const removeRowEvent = async (row: any) => {
        const $grid = xGrid.value;
        if ($grid) {
          $grid.remove(row);
          createMessage.success(t('common.tips.deleteSuccess'));
        }
      };

      function reload() {
        const $grid = xGrid.value;
        $grid.commitProxy('query');
      }

      async function reset() {
        const $grid = xGrid.value;
        await $grid.revertData();
        await $grid.clearAll();
        await $grid.clearData();
        await $grid.remove();
        $grid.getRefMaps().refForm.value.reset();
      }
      onMounted(() => {
          const { formConfig, columns } = gridOptions
              if (columns) {
                //debugger;
                var i;
                for(i=0;i<columns.length;i++){
                const columnItem = columns[i]
                }
              }

              if (formConfig && formConfig.items) {
                //debugger;
                var i=0;
                for(i=0;i<formConfig.items.length;i++){
                const columnItem = formConfig.items[i]
                }

              }
      });
        const index = ref(-1)
        const row = ref<any>(null)

        function handles (ev) {
            row.value = ev.visibleData[ev.$rowIndex]
            index.value = ev.$rowIndex
            console.log(ev, 'eevvv')
            if (ev.cell.classList.contains('col--actived') && ev._columnIndex === 2) {
                var data={"record":{"id":null}};
                openDefUserModal(true , data);
            }
        }


        async function handleDefUserSelect(){
            if(defUserRef.value.selectRowList.length>0) {
                var uservo = defUserRef.value.selectRowList[0]
                row.value.sponsorName = uservo.unitName;
                row.value.contacts = uservo.contactName;
                row.value.contactNumber = uservo.phone;

            }

        }


        return {
        t,
        xGrid,
        gridOptions,
        gridEvents,
        load,
        reset,
        insertEvent,
        removeRowEvent,
        getRecordset,
        fullValidate,
            registerDefUserModal,
            handles,
            handleDefUserSelect,
            defUserRef
      };
    },
  });
</script>
