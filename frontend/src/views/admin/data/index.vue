<template>
    <div class="box">
        <el-col :span="12" class="innerbox">
            <div id="userCount" class="Count"></div>
            <div id="activityCount" class="Count"></div>
        </el-col>
        <el-col :span="12" class="innerbox">
            <div id="financeCount" class="finance"></div>
        </el-col>
    </div>
</template>
   
<script setup lang="ts">
import * as echarts from 'echarts'; // 导入 echarts
import { onMounted, ref } from "vue";
let userData = {}
let activityData = {}
let financeData = {}
onMounted(() => {
    // 基于准备好的dom，初始化echarts实例
    var userChart = echarts.init(document.getElementById('userCount'));
    var activityChart = echarts.init(document.getElementById('activityCount'));
    var financeChart = echarts.init(document.getElementById('financeCount'));
    // 绘制社团用户图表
    userChart.setOption({
        title: {
            text: '社团用户数量'
        },
        tooltip: {},
        xAxis: {
            data: ['吉他社', '舞蹈社', 'IT社']
        },
        yAxis: {},
        series: [
            {
                name: '各社团用户数量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }
        ]
    });
    // 绘制社团活动图表
    activityChart.setOption({
        title: {
            text: '社团活动数量'
        },
        tooltip: {},
        xAxis: {
            data: ['吉他社', '舞蹈社', 'IT社']
        },
        yAxis: {},
        series: [
            {
                name: '各社团活动数量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }
        ]
    });
    // 绘制财务活动图表
    financeChart.setOption({
        title: {
            text: '社团财务支出'
        },
        tooltip: {},
        xAxis: {
            data: ['吉他社', '舞蹈社', 'IT社']
        },
        yAxis: {},
        series: [
            {
                type: 'pie',
                name: '各社团财务支出',
                data: [5, 20, 36, 10, 10, 20]
            }
        ]
    });
})
</script>
   
<style lang='scss' scoped>
.box {
    height: 100%;
    width: 100%;

    .innerbox {
        height: 100%;
        .Count {
            height: 50%;
            width: 100%;
            margin: auto auto;
            div{
                width: 100%;
            }
        }
        .finance{
            width: 100%;
            height: 100%;
        }
    }
}
</style>
   