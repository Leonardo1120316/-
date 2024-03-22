<template>
    <div class="tabbar">
        <div class="tabbar_left">
           <breadcrumb></breadcrumb>
        </div>
        <!-- 右侧按钮 -->
        <div class="tabbar_right">
            <setting></setting>
        </div>
    </div>
</template>

<script setup lang="ts">
import breadcrumb from './breadcrumb/index.vue'
import setting from './setting/index.vue'
</script>
<script lang="ts">
export default {
    name: 'Tabbar'
}
</script>

<style lang='scss' scoped>
.tabbar {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    // background-image: linear-gradient(to right,white,black,white);
    .tabbar_left {
        display: flex;
    }

    .tabbar_right {
        display: flex;
        align-items: center;
        el-button {
            background-color: white;
        }
    }
}</style>
