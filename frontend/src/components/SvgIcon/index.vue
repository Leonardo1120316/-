<template>
    <svg :width="width" :height="height">
        <use :xlink:href="prefix+name"  :fill="color" />
    </svg>
</template>

<script setup lang="ts">
defineProps({
    prefix: {
        type: String,
        default: '#icon-'
    },
    name: String,
    color: {
        type: String,
        default: "black"
    },
    width: {
        type: Number,
        default: '16px'
    },
    height: {
        type: Number,
        default: '16px'
    },
})
</script>

<style lang='stylus' scoped>

</style>
