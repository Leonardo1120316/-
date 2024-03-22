<template>
    <el-icon style="margin-right: 10px;" @click="changeIcon">
        <component :is="LayoutSettingStore.fold?'Fold':'Expand'" ></component>
    </el-icon>
    <el-breadcrumb separator-icon="ArrowRight">
        <el-breadcrumb-item v-for="(item,index) in $route.matched" :key="index" class="breadItem" :to="item.path">
            <el-icon>
                <component :is="item.meta.icon"></component>
            </el-icon>
            <span>
                {{ item.meta.title }}
            </span>
        </el-breadcrumb-item>
    </el-breadcrumb>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router';
import useLayOutSettingStore from '@/store/modules/setting'
let LayoutSettingStore = useLayOutSettingStore()
const $route = useRoute()
const changeIcon = () => {
    LayoutSettingStore.fold = !LayoutSettingStore.fold
}
const handler = ()=>{

}
</script>
<script lang="ts">
export default {
    name: 'Breadcrumb'
}
</script>

<style lang='scss' scoped>
.breadItem{
    display: flex;
    align-items: center;
}
</style>
