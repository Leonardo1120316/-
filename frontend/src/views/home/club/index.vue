<template>
    <div style="height:100%">
        <el-card style="max-width: 100%;height:100%">
            <template #header>
                <div class="card-header">
                    <div class="card-header-left">
                        <span>社团管理</span>
                    </div>
                    <div class="card-header-right">
                        <el-button type="primary" @click="btnClick">我的社团</el-button>
                    </div>
                </div>
            </template>
            <DataTable :column="column" :tableData="tableData" @onDel="deleteModal" @onEdit="editModal"></DataTable>
            <el-dialog v-model="addDialogVisible" title="我的社团" width="800" :before-close="handleClose">
                <DataTable :column="column" :tableData="tableData" @onDel="deleteModal" @onEdit="editModal"></DataTable>
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
                    <el-input v-model="form.clubname"></el-input>
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
            确认删除用户?
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
import { getClubList, addClub, editClub, delClub } from '@/api/club'
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
    clubname: '',
    email: ''
})
const column = ref([
    {
       label:'社团ID',
       column:'id'
    },
    {
       label:'社团名称',
       column:'clubname'
    },
    {
       label:'社团邮箱',
       column:'email'
    },
    {
        label: '操作',
        operation: true,
        confirmBtn: '加入',
        delBtn: '查看'
    },
])
const tableData = ref([])
onMounted(async () => {
    let res = await getClubList()
    tableData.value = res.data;
})
const add = async() => {
    try {
        let obj = {...{id: row.id},...form.value}
        await addClub({club: obj})
        ElMessageBox({
            type: 'success',
            message: "编辑成功"
        })
        addDialogVisible.value=false;
        let res = await getClubList()
        tableData.value = res.data;
    } catch (error) {
        addDialogVisible.value=false;
        ElMessageBox({
            type: 'error',
            message: "编辑失败"
        })
    }
}
const edit = async(record) => {
    try {
        let obj = {...{id: record.id},...form.value}
        await editClub({club: obj})
        ElMessageBox({
            type: 'success',
            message: "编辑成功"
        })
        editDialogVisible.value=false;
        let res = await getClubList()
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
        await delClub({ id: record.id })
        ElMessageBox({
            type: 'success',
            message: "删除成功"
        })
        deleteDialogVisible.value=false;
        let res = await getClubList()
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
