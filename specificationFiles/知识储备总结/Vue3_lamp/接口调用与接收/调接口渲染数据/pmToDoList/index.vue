<template>
  <a-table
    :columns="columns"
    :data-source="dataSource"
    bordered
  >
    <template #bodyCell="{ column, text, record }">
      <template v-if="arys.includes(column.dataIndex)">
        <div>
          <a-input
            v-if="editableData[record.id]"
            v-model:value="editableData[record.id][column.dataIndex]"
            style="margin: -5px 0"
          />
          <template v-else>
            {{ text }}
          </template>
        </div>
      </template>
      <template v-else-if="column.dataIndex === 'operation'">
        <div class="editable-row-operations">
          <span v-if="editableData[record.id]">
            <a-typography-link @click="save(record)">保存
            </a-typography-link>
            <a @click="cancel(record.id)">取消</a>
          </span>
          <span v-else>
            <a @click="edit(record.id)">编辑</a>
          </span>
        </div>
      </template>
    </template>
  </a-table>
</template>
<script lang="ts" setup>
import { cloneDeep } from 'lodash-es'
import { reactive, ref } from 'vue'
import type { UnwrapRef } from 'vue'

import {
  DescriptionsItem as ADescriptionsItem,
  Descriptions as ADescriptions,
  Table as ATable,
  RadioGroup as ARadioGroup,
  Button as AButton,
  TimelineItem as ATimelineItem,
  Timeline as ATimeline,
  TypographyLink as ATypographyLink,
  Popconfirm as APopconfirm
  /*  Checkbox as ACheckbox,
    Form as AForm,
    InputPassword as AInputPassword */
} from 'ant-design-vue'

import { defHttp } from '/@/utils/http/axios'

const arys = ['approverName', 'processName', 'businessType', 'processInstanceId', 'createdTime']

const columns = [
  {
    customRender: ({ index }) => {
      return index + 1
    },
    title: '序号'
  },
  {
    title: '标题',
    dataIndex: 'approverName',
  },
  {
    title: '审批业务',
    dataIndex: 'processName',
  },
  {
    title: '审批类型',
    dataIndex: 'businessType',
  },
  {
    title: '申请单位',
    dataIndex: 'processInstanceId',
  },
  {
    title: '申请时间',
    dataIndex: 'createdTime',
  },
   {
    title: '申请时间',
    dataIndex: 'createdTime',
  },
   {
    title: '申请时间',
    dataIndex: 'createdTime',
  },
  {
    title: '操作',
    dataIndex: 'operation',
  },
]

interface RootObject {
  processInstanceId: string
  processName: string
  createdTime: string
  id: string
  businessType: string
  title: string
  approverName: string
  toDoId: ToDoId
}

interface ToDoId {
  phone: string
  userId: string
  userName: string
}

interface DataItem {
  id: string
  name: string
  age: number
  address: string
}

 let data = []
async function getData () {
  const value = await defHttp.post({
    url: '/learnpm/pmApprovalProcessInstance/backlogdataVolumeList',
    headers: {
      ApplicationId: '1',
      Authorization: 'bGFtcF93ZWI6bGFtcF93ZWJfc2VjcmV0',
      TenantId: '1',
      Token: 'test',
    },
  })
  
  data = value.map(item => {
    item.toDoId = JSON.parse(item.toDoId)
    return item
  })
  dataSource.value = data
  console.log(data, 'data')
}

getData()

const dataSource = ref(data)
const editableData: UnwrapRef<Record<string, DataItem>> = reactive({})

const edit = (id: string) => {
  editableData[id] = cloneDeep(dataSource.value.filter(item => id === item.id)[0])
}
const save = (record: {}) => {
  Object.assign(dataSource.value.filter(item => record.id === item.id)[0], editableData[record.id])
  delete editableData[record.id]
  
  defHttp.post({
    url: '/learnpm/pmApprovalProcessInstance/updateToDoInfo',
    data: record
  })
  
}
const cancel = (id: string) => {
  delete editableData[id]
}
</script>
<style scoped>
.editable-row-operations a {
  margin-right: 8px;
}
</style>
