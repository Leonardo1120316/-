<template>
    <div>
       <el-row class="contentBox">
         <el-col :span="12" :xs="0"></el-col>
         <el-col :span="12" :xs="24" class="formBox">
             <el-form class="form" :model="loginForm" :rules="rules" ref="loginForms">
                <h1>{{setting.title}}</h1>
                <el-form-item class="el-input" prop="userAccount">
                  <el-input :prefix-icon="User" v-model="loginForm.userAccount">账号</el-input>
                </el-form-item>
                <el-form-item class="el-input"  prop="userPassword">
                  <el-input type="password" :prefix-icon="Lock" v-model="loginForm.userPassword" show-password="true">密码</el-input>
                </el-form-item>
                <el-form-item class="el-input"  prop="checkPassword">
                  <el-input type="password" :prefix-icon="Lock" v-model="loginForm.checkPassword" show-password="true">校验</el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" size="default" class="el-button" @click="register" :loading="loading">注册</el-button>
                </el-form-item>
             </el-form>
         </el-col>
       </el-row>
    </div>
   </template>
   
   <script lang="ts" setup>
   import { User, Lock} from '@element-plus/icons-vue';
   import setting from '@/setting'
   import { reactive, ref } from 'vue';
   import useUserStore from '@/store/modules/user'
   import { useRouter } from 'vue-router'; 
   import { ElNotification } from 'element-plus';
   import { getTime } from '@/utils/time'
   let loginForms = ref()
   const $router = useRouter()
   const useStore = useUserStore()
   const loginForm = reactive({
      userAccount: 'admin',
      userPassword: '123456',
      checkPassword: '123456',
   })
   //自定义校验规则函数
   const validatorUserName = (rule:any,value:any,callback:any) => {
      if(value.length<5){
         callback(new Error("密码长度小于5位"))
      }else if(value.length>10){
         callback(new Error("密码长度大于10位"))
      }else{
         callback()
      }
   }
   const validatorPassword = (rule:any,value:any,callback:any) => {
      if(value.length<5){
         callback(new Error("密码长度小于5位"))
      }else if(value.length>10){
         callback(new Error("密码长度大于10位"))
      }else{
         callback()
      }
   }
   const rules = {
      userAccount: [
         // {required: true,message: '用户名不能为空',triggle:"blur"},
         // {min: 6,message: '用户名长度小于6位',triggle:"change"},
         // {max: 16,message: '用户名长度大于16位',triggle:"change"}
         {trigger:'change',validator:validatorUserName}
      ],
      userName: [
      // {required: true,message: '密码不能为空',triggle:"blur"},
      //    {min: 6,message: '密码长度小于6位',triggle:"change"},
      //    {max: 16,message: '密码长度大于16位',triggle:"change"}
      {trigger:'change',validator:validatorPassword}
      ]
   }
   let loading = ref(false)
   //收集表单数据
   const register = async () => {
      await loginForms.value.validate();
      //后端发送登录请求
      loading.value=true
      try {
         await useStore.userRegister(loginForm);
         $router.push('/login')
         ElNotification({
            type: 'success',
            title: '注册成功'
         })
         loading.value=false
       }catch(error){
        $router.push('/register')
         loading.value=false
         ElNotification({
            type: 'error',
            message: '注册失败'
         })
       }
   }
   </script>
   
   <style lang='scss' scoped>
   .contentBox{
      color: #eee;
      height: 100vh;
      width: 100vw;
      background: url('@/assets/images/background.jpg') no-repeat;
      background-size: cover;
      h1{
         margin: 20px 20px;
      }
      .formBox{
      height: 100vh;
      width: 100vw;
      //   .form{
      //    margin: 30vh 10px;
      //    }
      .form{
         position: relative;
         top: 30vh;
         background-color: #2d3a4b;
         padding: 20px 35px;
         border-radius: 2%;
         box-sizing: content-box;
         margin: 0 10vw;
         .el-input{
            background-color: #2d3a4b;
         }
         .el-button{
             width: 100%;
         }
      }
      }
   }
   </style>
   