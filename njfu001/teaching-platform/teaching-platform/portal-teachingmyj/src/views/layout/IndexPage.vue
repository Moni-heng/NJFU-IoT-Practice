<script setup>
import HeaderView from '@/views/components/HeaderView.vue';
</script>

<template>
  <header-view />
  <div class="main-body" id="mainBody">
    <router-view />
  </div>
</template>

<style scoped>
.main-body {
  border: 1px solid;
  width: 100%;
  height: 100%;
  padding-top: 60px;
  overflow-y: auto; /* 允许滚动 */
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
</style>
