//统一管理项目用户相关接口
import request from "@/utils/request";
//统一管理接口
enum API {
    LOGIN_URL = "/user/login",
    USERINFO_URL = "/user/current",
    REGISTER_URL = "/user/register",
    LOGOUT_URL = "/user/logout",
    USERLIST_URL = "/user/search",
    EDIT_URL = '/user/update',
    DEL_URL = '/user/delete',
    ADD_URL = '/user/add'
}
//暴露请求函数
//登录接口方法
export const reqLogin = (data: any)=>request.post<any, any>(API.LOGIN_URL,data);
export const reqUserInfo = ()=> request.get<any,any>(API.USERINFO_URL);
export const reqRegister = (data: any)=>request.post<any, any>(API.REGISTER_URL,data);
export const reqLogout = ()=> request.post<any,any>(API.LOGOUT_URL);
//获取用户列表
export const getUserList = ()=> request.get<any,any>(API.USERLIST_URL);
//修改用户
export const editUser = (data:any)=> request.post<any,any>(API.EDIT_URL,data);
//删除用户
export const delUser = (data:any)=> request.post<any,any>(API.DEL_URL,data);
//增加用户
export const addUser = (data:any)=> request.post<any,any>(API.ADD_URL,data);