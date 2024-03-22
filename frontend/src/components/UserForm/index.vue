<template>
  <div class="box">
    <el-card style="max-width: 100%; height: 100%;">
      <template #header>
        <div class="card-header">
          <div class="block" style="margin: 10px;">
            <el-avatar :size="50" :src="user.avatarUrl" />
          </div>
          <span>{{ user.username }}</span>
        </div>
      </template>
      <div class="card-body">
        <el-descriptions title="个人信息">
          <el-descriptions-item label="用户名称:">{{user.username}}</el-descriptions-item>
          <el-descriptions-item label="用户账号:">{{user.userAccount}}</el-descriptions-item>
          <el-descriptions-item label="性别:">{{ user.gender==null ? "":(user.gender? "女":"男") }}</el-descriptions-item>
          <el-descriptions-item label="邮箱:">{{user.email}}</el-descriptions-item>
          <el-descriptions-item label="电话:">{{user.phone}}</el-descriptions-item>
        </el-descriptions>
      </div>
      <template #footer>
        <div class="card-footer">
          <el-descriptions title="简介">
          <el-descriptions-item label="简介:">{{user.introduce}}</el-descriptions-item>
        </el-descriptions>
        </div>
      </template>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref, watch } from "vue"
const props = defineProps(['UserInformation'])
let user = ref(props.UserInformation)
watch(()=>props.UserInformation,(newVal)=>{
   user.value = newVal;
})
</script>


<style lang='scss' scoped>
.card-head {}
</style>
