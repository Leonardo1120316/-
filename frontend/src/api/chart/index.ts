//统一管理项目用户相关接口
import request from "@/utils/request";
//统一管理接口
enum API {
    CLUBLIST_URL = "/activity/search",
    ADD_URL = "/activity/add",
    EDIT_URL = '/activity/update',
    DEL_URL = '/activity/delete'
}
//获取社团列表
export const getActivityList = ()=> request.get<any,any>(API.CLUBLIST_URL);
//修改社团
export const editActivity= (data:any)=> request.post<any,any>(API.EDIT_URL,data);
//删除社团
export const delActivity= (data:any)=> request.post<any,any>(API.DEL_URL,data);
//增加社团
export const addActivity = (data:any)=> request.post<any,any>(API.ADD_URL,data);