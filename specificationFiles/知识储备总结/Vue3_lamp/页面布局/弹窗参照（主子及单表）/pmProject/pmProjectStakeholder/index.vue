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
  import DefUser from '../pmProjectStakeholder/reference/defUser.vue';
  import { defineComponent, reactive, ref, onMounted } from 'vue';
  import { VxeGridInstance, VxeGridListeners, VxeGridProps, VxeTablePropTypes } from 'vxe-table';
  import { useI18n } from '/@/hooks/web/useI18n';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { PopConfirmButton } from '/@/components/Button';
  import { ActionEnum, VALIDATE_API } from '/@/enums/commonEnum';
  import { getValidateRuleObj } from '/@/api/lamp/common/formValidateService';
  import { Api, page as pageRequest } from '/@/api/learnpm/pm/pmProjectStakeholder';
  import { columns, customFormSchemaRules, formItems } from './pmProjectStakeholder.data';
  import { dictComponentProps } from '/@/utils/lamp/common';
  import { DictEnum } from '/@/enums/commonEnum';
  import { useModal } from '/@/components/Modal';
  import { useForm } from '/@/components/Form/index';
  export default defineComponent({
    name: '项目干系人',
    components: { PopConfirmButton, DefUser },
    setup: function () {
      const defUserRef = ref<any>(null);
      const { t } = useI18n();
      open;
      const { createMessage } = useMessage();
      const pmProjectId = ref<string>('');
      const [registerDefUserModal, { openModal: openDefUserModal }] = useModal();
      const typeRef = ref<ActionEnum>(ActionEnum.ADD);
      const xGrid = ref<VxeGridInstance>({});
      const validRules = ref<VxeTablePropTypes.EditRules>({});
      const tableData = ref<any>();
      let uservo = reactive<any>([]);
      const id = ref<any>(null);
      const gridOptions = reactive<VxeGridProps>({
        id: 'PmProjectStakeholder',
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
              const queryParams: any = { model: form };

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
      const [, { setFieldsValue, getFieldsValue }] = useForm({});
      const gridEvents: VxeGridListeners = {
        toolbarButtonClick({ code }) {
          const $grid = xGrid.value;
          switch (code) {
            case 'myInsert': {
              var data = { record: { id: id.value } };
              openDefUserModal(true, data);
              boolean.value = false;
              break;
            }
            case 'delete': {
              $grid.removeCheckboxRow();
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
        const { formConfig, columns } = gridOptions;
        if (columns) {
          var i;
          for (i = 0; i < columns.length; i++) {
            const columnItem = columns[i];
            if (columnItem && columnItem.editRender && columnItem.field === 'projectRole') {
              var retVal;
              retVal = dictComponentProps(DictEnum.LEARNPM_ROLE_COE);
              retVal.api(retVal.params).then((data) => {
                columnItem.editRender.options = data.data;
              });
            }
          }
        }

        if (formConfig && formConfig.items) {
          var i = 0;
          for (i = 0; i < formConfig.items.length; i++) {
            const columnItem = formConfig.items[i];

            if (columnItem && columnItem.itemRender && columnItem.field === 'projectRole') {
              var retVal;
              retVal = dictComponentProps(DictEnum.LEARNPM_ROLE_COE);
              retVal.api(retVal.params).then((data) => {
                console.log(data);
                columnItem.itemRender.options = data.data;
              });
            }
          }
        }
      });

      const index = ref(-1);
      const row = ref<any>(null);
      const boolean = ref(false);

      function handles(ev) {
        row.value = ev.visibleData[ev.$rowIndex];
        index.value = ev.$rowIndex;
        console.log(ev, 'eevvv');
        if (ev.cell.classList.contains('col--actived') && ev._columnIndex === 2) {
          var data = { record: { id: id.value } };
          console.log('handle');
          boolean.value = true;
          openDefUserModal(true, data);
        }
      }

      function remove() {
        xGrid.value.remove(row.value);
        boolean.value = false;
      }

      async function handleDefUserSelect(ev) {
        console.log(ev, 'vvv');
        //TODO:根据业务需求，自己回填字段
        if (defUserRef.value.selectRowList.length > 0) {
          var uservo = defUserRef.value.selectRowList[0];
          const $table = xGrid.value;
          const record = {
            name: uservo.username,
              userId: uservo.id,
            phone: uservo.mobile,
          };
          console.log(boolean.value, 'bool');
          if (boolean.value) {
            remove();
          }
          await $table.insertAt(record, index.value);
        }
      }
      return {
        handles,
        handleDefUserSelect,
        defUserRef,
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
      };
    },
  });
</script>
