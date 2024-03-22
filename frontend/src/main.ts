import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'virtual:svg-icons-register'
import globalComponent from '@/components/index'
import router from '@/router/index'
import pinia from './store/index'
import '@/style/index.scss'

const app = createApp(App)
//使用自定义全局组件注册插件
app.use(pinia)
app.use(router)
app.use(globalComponent)
app.use(ElementPlus)
app.mount('#app')
