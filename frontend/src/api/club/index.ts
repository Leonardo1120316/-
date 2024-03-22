//统一管理项目用户相关接口
import request from "@/utils/request";
//统一管理接口
enum API {
    CLUBLIST_URL = "/club/search",
    ADD_URL = "/club/add",
    EDIT_URL = '/club/update',
    DEL_URL = '/club/delete'
}
//获取社团列表
export const getClubList = ()=> request.get<any,any>(API.CLUBLIST_URL);
//修改社团
export const editClub= (data:any)=> request.post<any,any>(API.EDIT_URL,data);
//删除社团
export const delClub= (data:any)=> request.post<any,any>(API.DEL_URL,data);
//增加社团
export const addClub = (data:any)=> request.post<any,any>(API.ADD_URL,data);