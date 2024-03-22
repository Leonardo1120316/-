<template>
 <div class="logo" v-if="setting.loginHidden">
     <img :src="`../../..${setting.logo}`" alt="">
     <p :class="{fold:LayoutSettingStore.fold}" class="text">{{ setting.title }}</p>
 </div>
</template>

<script setup lang="ts">
import setting from '@/setting'
import useLayOutSettingStore from '@/store/modules/setting';
let LayoutSettingStore = useLayOutSettingStore();
</script>
<script lang="ts">
export default {
    name: 'Logo'
}
</script>

<style lang='scss' scoped>
.logo{
    width: 100%;
    height: $base-meun-logo-height;
    display: flex;
    align-items: center;
    justify-content: center;
    img{
        height:40px;
        width:40px;
        margin: 0px 3px;
        }
    }
    p{
        display: inline-block;
        color: white;
        font-size: $base-logo-title-fontSize;
    }
    
.fold{
   display: none;
}
.text{
  overflow: hidden;
  white-space: nowrap;
}
</style>
