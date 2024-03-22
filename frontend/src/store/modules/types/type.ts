import type { RouteRecordRaw } from "vue-router";
//定义小仓库state类型
export interface UserState {
     token: string|null;
     menuRoutes: RouteRecordRaw[],
     username: string,
     avatar: string,
     session: string
}