import { SET_SESSION, GET_SESSION, REMOVE_SESSION } from './../../utils/session';
import { reqUserInfo, reqLogout } from './../../api/user/index';
import { ElMessage, resultProps } from 'element-plus';
//创建用户相关仓库
import { defineStore } from 'pinia';
import { reqLogin, reqRegister } from '@/api/user/index';
import { loginForm } from '@/api/user/type';
import type { UserState } from './types/type';
import { routes } from '@/router/routes'

const useUserStore = defineStore('User',{
    //状态管理
    state: ():UserState => {
        return {
          menuRoutes: routes,
          username: '',
          avatar: '',
          session: GET_SESSION()
        }
    },
    //异步逻辑处理
    actions: {
       async userLogin(data:loginForm){
         let resp = await reqLogin(data);
         if( resp.code == 0 ){
          SET_SESSION(resp.data)
          return "ok"
         }else{
          return Promise.reject(new Error(resp.data.message));
         }
       },
       async userRegister(data:loginForm){
        const resp = await reqRegister(data);
        if( resp.code == 0 ){
         return "ok"
        }else{
         return Promise.reject(new Error(resp.data.message));
        }
      },
       async userInfo(){
           let result = await reqUserInfo();
           if(result.code==0){
                this.username=result.data.username;
                this.avatar=result.data.avatarUrl;
           }
       },
       async userLogout(){
        try{
          await reqLogout();
          REMOVE_SESSION();
          this.username='';
          this.avatar='';
        }catch(error){
           console.log(error)
        }
       },
    },
    //计算属性
    getters: {

    }
})
//暴露仓库
export default useUserStore