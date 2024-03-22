<template>
    <el-button size="small" icon="Refresh" circle="true" @click="Refresh"></el-button>
    <el-button size="small" icon="FullScreen" circle="true" @click="FullScreen"></el-button>
    <el-button size="small" icon="Setting" circle="true"></el-button>
    <img :src="UserStore.avatar" style="height:20px;width:20px;margin-right:5px;margin-left:10px;border-radius: 10px;"></img>
    <el-dropdown>
        <span class="el-dropdown-link">
            {{ UserStore.username }}
            <el-icon class="el-icon--right">
                <arrow-down />
            </el-icon>
        </span>
        <template #dropdown>
            <el-dropdown-menu>
                <el-dropdown-item @click="goUser">用户信息</el-dropdown-item>
                <el-dropdown-item @click="logout">退出登录</el-dropdown-item>
            </el-dropdown-menu>
        </template>
    </el-dropdown>
</template>

<script setup lang="ts">
import useLayOutSettingStore from '@/store/modules/setting';
import useUserStore from '@/store/modules/user'
import { useRouter } from 'vue-router'
let $router = useRouter();
let UserStore = useUserStore();
let LayoutSettingStore = useLayOutSettingStore();
const Refresh = () => {
    LayoutSettingStore.refresh = !LayoutSettingStore.refresh;
}
const FullScreen = () => {
    let isFullScreen = document.fullscreenElement;
    if(isFullScreen){
        document.exitFullscreen();
    }else{
        document.documentElement.requestFullscreen();
    }
}
const logout = async()=>{
    await UserStore.userLogout()
    $router.push('/login')
}
const goUser = ()=>{
    $router.push('/person/person')
}
</script>
<script lang="ts">
export default {
    name: 'Setting'
}
</script>

<style lang='scss' scoped>

</style>
