<template>
    <div>
        <el-table :data="tableData" border="true" style="width: 100%">
            <el-table-column :prop="item.column" :label="item.label" v-for="item in column" :key="item.id">
                <template #default="scope" v-if="item.operation">
                    <el-button link type="primary" size="small"
                        @click="record = scope.row;edit()">{{item.confirmBtn == null ? "修改": item.confirmBtn}}</el-button>
                    <el-button link type="primary" size="small"
                        @click="record = scope.row;del()">{{item.delBtn == null ? "删除": item.delBtn}}</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script setup lang="ts">
import { ref, watch } from 'vue'
const props = defineProps(["column", "tableData"])
const emits = defineEmits(["onDel","onEdit"])
const column = ref(props.column)
const tableData = ref(props.tableData)
let record
watch(() => props.tableData, (newVal) => {
    tableData.value = newVal
})
watch(() => props.column, (newVal) => {
    column.value = newVal
})
const del = () => {
    emits('onDel',record);
}
const edit = () => {
   emits('onEdit',record);
}
</script>

<style lang='scss' scoped></style>
