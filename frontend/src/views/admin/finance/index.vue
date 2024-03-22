<template>
    <div style="height:100%">
        <el-card style="max-width: 100%;height:100%">
            <template #header>
                <div class="card-header">
                    <div class="card-header-left">
                        <span>社团管理</span>
                    </div>
                    <div class="card-header-right">
                        <el-button type="primary" @click="btnClick">新增</el-button>
                    </div>
                </div>
            </template>
            <DataTable :column="column" :tableData="tableData" @onDel="deleteModal" @onEdit="editModal"></DataTable>
            <el-dialog v-model="addDialogVisible" title="新增" width="500" :before-close="handleClose">
                <el-form v-model="form">
                    <el-form-item label="社团名称">
                        <el-input v-model="form.financename"></el-input>
                    </el-form-item>
                    <el-form-item label="社团邮箱">
                        <el-input v-model="form.email"></el-input>
                    </el-form-item>
                </el-form>
                <template #footer>
                    <div class="dialog-footer">
                        <el-button @click="editDialogVisible = false">取消</el-button>
                        <el-button type="primary" @click="add">
                            确定
                        </el-button>
                    </div>
                </template>
            </el-dialog>
            <el-dialog v-model="editDialogVisible" title="修改" width="500" :before-close="handleClose">
            <el-form v-model="form">
                <el-form-item label="社团名称">
                    <el-input v-model="form.financename"></el-input>
                </el-form-item>
                <el-form-item label="社团邮箱">
                    <el-input v-model="form.email"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <div class="dialog-footer">
                    <el-button @click="editDialogVisible = false">取消</el-button>
                    <el-button type="primary" @click="edit(row)">
                        确定
                    </el-button>
                </div>
            </template>
        </el-dialog>
        <el-dialog v-model="deleteDialogVisible" title="删除" width="500" :before-close="handleClose">
            确认删除记录?
            <template #footer>
                <div class="dialog-footer">
                    <el-button @click="deleteDialogVisible = false">取消</el-button>
                    <el-button type="primary" @click="del(row)">
                        确定
                    </el-button>
                </div>
            </template>
        </el-dialog>
        </el-card>
    </div>
</template>

<script setup lang="ts">
import { getFinanceList, addFinance, editFinance, delFinance } from '@/api/finance'
import { ElMessageBox } from 'element-plus'
import { onMounted, ref } from 'vue'
let row
let editDialogVisible = ref(false)
let deleteDialogVisible = ref(false)
let addDialogVisible = ref(false)
const deleteModal = (record) => {
    deleteDialogVisible.value=true;
    row = record
    console.log(row)
}
const editModal = (record) => {
    editDialogVisible.value=true;
    row = record
}
const btnClick = () => {
    addDialogVisible.value = true;
}
const form = ref({
    financename: '',
    email: ''
})
const column = ref([
    {
       label:'财务ID',
       column:'id'
    },
    {
       label:'财务名称',
       column:'financename'
    },
    {
       label:'财务邮箱',
       column:'email'
    },
    {
        label: '操作',
        operation: true,
    },
])
const tableData = ref([])
onMounted(async () => {
    let res = await getFinanceList()
    tableData.value = res.data;
})
const add = async() => {
    try {
        let obj = {...{id: row.id},...form.value}
        await addFinance({finance: obj})
        ElMessageBox({
            type: 'success',
            message: "添加成功"
        })
        addDialogVisible.value=false;
        let res = await getFinanceList()
        tableData.value = res.data;
    } catch (error) {
        addDialogVisible.value=false;
        ElMessageBox({
            type: 'error',
            message: "添加失败"
        })
    }
}
const edit = async(record) => {
    try {
        let obj = {...{id: record.id},...form.value}
        await editFinance({finance: obj})
        ElMessageBox({
            type: 'success',
            message: "编辑成功"
        })
        editDialogVisible.value=false;
        let res = await getFinanceList()
        tableData.value = res.data;
    } catch (error) {
        editDialogVisible.value=false;
        ElMessageBox({
            type: 'error',
            message: "编辑失败"
        })
    }
}
const del = async (record) => {
    try {
        await delFinance({ id: record.id })
        ElMessageBox({
            type: 'success',
            message: "删除成功"
        })
        deleteDialogVisible.value=false;
        let res = await getFinanceList()
        tableData.value = res.data;
    } catch (error) {
        deleteDialogVisible.value=false;
        ElMessageBox({
            type: 'error',
            message: "删除失败"
        })
    }
}
const handleClose = (done: () => void) => {
    done();
}
</script>

<style lang='scss' scoped>
.card-header {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;

    .card-header-left {
        width: 40%;
        font-size: larger;
        font-weight: bolder;
    }

    .card-header-right {
        margin-right: 20px;
    }
}
</style>
