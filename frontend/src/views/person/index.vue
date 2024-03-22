<template>
  <div style="height: 100%;">
    <UserForm class="form" :UserInformation="user"></UserForm>
  </div>
</template>
   
<script setup lang="ts">
import { ref } from 'vue'
import { reqUserInfo } from '@/api/user'
import { onMounted } from 'vue';
let user = ref({});
onMounted(async () => {
  let result = await reqUserInfo()
  user.value = result.data
})
</script>
   
<style lang='scss' scoped>
.form{
  width: 100%;
  height: 100%;
}
</style>
   