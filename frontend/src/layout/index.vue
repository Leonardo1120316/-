<template>
    <div class="common-layout">
      <el-container>
        <!-- 左侧菜单 -->
        <el-aside width="200px" class="aside" :class="{fold:LayOutSettingStore.fold}">
            <logo></logo>
            <el-scrollbar class="scrollbar">
              <el-menu background-color="#001529" text-color="white" :default-active="$route.path">
                <Menu :menuList="useStore.menuRoutes"></Menu>
              </el-menu>
            </el-scrollbar>
        </el-aside>
        <!-- 右侧内容 -->
        <el-container style="height:100vh">
          <!-- 头部导航栏 -->
          <el-header class="tabbar">
            <tabbar></tabbar>
          </el-header>
          <!-- 右部内容栏 -->
          <el-main>
            <Main></Main>
          </el-main>
        </el-container>
      </el-container>
    </div>
</template>
   
<script setup lang="ts">
import logo from './logo/index.vue'
import Menu from './menu/index.vue'
import Main from './main/index.vue'
import { useRoute } from 'vue-router'
import tabbar from './tabbar/index.vue'
import useLayOutSettingStore from '@/store/modules/setting'
//获取仓库route配置
import useUserStore from '@/store/modules/user';
import { onMounted } from 'vue'
let LayOutSettingStore = useLayOutSettingStore()

const $route = useRoute()

let useStore = useUserStore();
onMounted(async()=>{
  await useStore.userInfo()
})
</script>
<script lang="ts">
export default {
    name: 'Layout'
}
</script>

<style scoped lang="scss">
.aside{
  background-color: $base-meun-background;
  transition: all 0.3s;
  .scrollbar{
     width: 100%;
     height: calc(100vh - $base-meun-logo-height);
     .el-menu{
       border-right: none;
     }
  }
}
.tabbar{
  background-color: $base-tabbar-color;
}
.fold{
   width: $base-meun-min-width;
}
</style>
   