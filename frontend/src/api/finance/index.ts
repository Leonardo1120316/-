//统一管理项目用户相关接口
import request from "@/utils/request";
//统一管理接口
enum API {
    CLUBLIST_URL = "/finance/search",
    ADD_URL = "/finance/add",
    EDIT_URL = '/finance/update',
    DEL_URL = '/finance/delete'
}
//获取社团列表
export const getFinanceList = ()=> request.get<any,any>(API.CLUBLIST_URL);
//修改社团
export const editFinance= (data:any)=> request.post<any,any>(API.EDIT_URL,data);
//删除社团
export const delFinance= (data:any)=> request.post<any,any>(API.DEL_URL,data);
//增加社团
export const addFinance = (data:any)=> request.post<any,any>(API.ADD_URL,data);