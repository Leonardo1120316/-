import SvgIcon from '@/components/SvgIcon/index.vue'
import UserForm from '@/components/UserForm/index.vue'
import DataTable from '@/components/DataTable/index.vue'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

const allGlobalComponent = { SvgIcon, UserForm, DataTable }

//对外暴露对象
export default{
    //使用install方法注册全局组件
    install(app){
        //遍历注册全局组件
        Object.keys(allGlobalComponent).forEach((key)=>{
            app.component(key,allGlobalComponent[key])
        })
        //注册ElementPlusIcon
        for (const [key,component] of Object.entries(ElementPlusIconsVue)){
            app.component(key,component)
        }
    }
}