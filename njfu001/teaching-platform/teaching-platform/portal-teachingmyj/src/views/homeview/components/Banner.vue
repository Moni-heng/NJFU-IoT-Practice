<template>
  <div class="content">
    <div class="banners">
      <el-carousel height="360px" autoplay >
        <el-carousel-item v-for="item in banners" :key="item.param8" style="cursor: pointer;">
          <!--          <img :src="`${sysStore.domainDev}${item.img}`" @click=""/>-->
          <img :src="item.param8" @click=""/>
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>
</template>


<script setup>
import {getPcodeList} from "@/apis/commonApi.js";
import {ref,onMounted} from "vue";

const banners= ref([])

const getBannerList=()=>{
  getPcodeList({"codeType": 4}).then(res =>{
    console.log('res->',res)
    banners.value=res.data

  })
}
onMounted(()=>{
  console.log('getBannerList()====')
  getBannerList()
})

</script>

<style scoped>

</style>
