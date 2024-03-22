<template>
 <div>
   <template v-for="item in menuList" :key="item.path">
      <!-- 没有子路由  -->
      <template v-if="!item.meta.hidden">
         <el-menu-item v-if="!item.children" :index="item.path" @click="goRoute">
         <template #title>
              <el-icon>
                <component :is="item.meta.icon"></component>
              </el-icon>
              <span :class="{fold:LayoutSettingStore.fold}" class="text">{{ item.meta.title }}</span>
         </template>
         </el-menu-item>
      </template>
       <!-- 含有一个子路由  -->
      <template v-if="!item.meta.hidden">
       <el-menu-item v-if="item.children&&item.children.length==1" :index="item.children[0].path" @click="goRoute">
         <template #title>
              <el-icon>
                <component :is="item.children[0].meta.icon"></component>
              </el-icon>
              <span :class="{fold:LayoutSettingStore.fold}" class="text">{{ item.children[0].meta.title }}</span>
         </template>
       </el-menu-item>
      </template>
       <!-- 含有多个子路由  -->
      <template v-if="!item.meta.hidden">
       <el-sub-menu :index="item.path" v-if="item.children&&item.children.length>1" @click="goRoute">
         <template #title>
              <el-icon>
                <component :is="item.meta.icon"></component>
              </el-icon>
              <span :class="{fold:LayoutSettingStore.fold}" class="text">{{ item.meta.title }}</span>
         </template>
           <Menu :menuList="item.children" :class="{fold:LayoutSettingStore.fold}"></Menu>
       </el-sub-menu>
      </template>
   </template>
 </div>
</template>

<script setup lang="ts">
import{ defineProps } from 'vue'
import useLayOutSettingStore from '@/store/modules/setting';
import { useRouter } from 'vue-router'
let LayoutSettingStore = useLayOutSettingStore();
defineProps(['menuList'])
let $router = useRouter();
const goRoute = (vc: any) => {
    $router.push(vc.index);
}
</script>
<script lang="ts">
export default {
   name: 'Menu'
}
</script>


<style lang='css' scoped>
.fold{
   display: none;
}
.text{
  overflow: hidden;
  white-space: nowrap;
}
</style>
