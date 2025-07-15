<script setup>
import HeaderView from '@/views/components/HeaderView.vue';
</script>

<template>
  <header-view />
  <div id="app">
    <div class="main-body" id="mainBody">
      <router-view />
    </div>
  </div>
</template>

<style>
#app {
  height: 100vh;
}

.main-body {
  border: 1px solid;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 100%;
  height: 100%;
  padding-top: 60px;
  overflow-y: auto;
}
</style>
