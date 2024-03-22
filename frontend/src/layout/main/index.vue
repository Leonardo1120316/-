<template>
 <router-view v-slot="{ Component }">
  <transition name="fade">
    <component :is="Component" v-if="flag"/>
  </transition>
 </router-view>
</template>

<script setup lang="ts">
import { watch, ref, nextTick } from 'vue'
import useLayOutSettingStore from '@/store/modules/setting';

let flag = ref(true);
const LayoutSettingStore = useLayOutSettingStore();
watch(()=>LayoutSettingStore.refresh,()=>{
  flag.value=false;
  nextTick(()=>{
    flag.value=true;
  })
})
</script>
<script lang="ts">
export default {
    name: 'Main'
}
</script>

<style scoped>
.fade-enter-from{
 opacity: 0;
}
.fade-enter-active{
 transition: all 1s;
}
.fade-enter-to{
 opacity: 100;
}
</style>
