<script setup>
const props = defineProps({
  title: String,
  content: String,
  topbgjpg: {
    type: String,
    default: '/images/welcome/mouse.jpg'
  },
});
</script>

<template>
  <div class="module">
    <el-row class="box-font">
      <div id="coverContainer">
        <div id="topbackimg" :style="`height: 242px;background-image: url(${topbgjpg});`"></div>
        <div id="topImgCover" class="topImgCover" style="height: 242px;"></div>
      </div>
      <div id="descInfo" class="wrap">
        <h2>{{ title }}</h2>
        <p>{{ content }}</p>
      </div>
    </el-row>
  </div>
</template>

<style scoped lang="scss">
#coverContainer {
  position: relative;
  width: var(--main-width1);
  height: 242px;
  overflow: hidden;
  margin: 15px auto 5px auto;
  border-radius: 8px;
}

.module {
  box-sizing: border-box;
  padding-bottom: 0;

  #topbackimg {
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
    filter: blur(10px);
  }

  #topImgCover {
    background: linear-gradient(to right, rgba(2, 2, 2, 0.9), rgba(2, 2, 2, 0.4), rgba(2, 2, 2, 0.3));
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
  }
}

#descInfo {
  position: absolute;
  left: 0;
  right: 0;
  top: 20px;
  padding-left: 20px;
}

.wrap {
  width: var(--main-width);
  margin: 0 auto;
  color: #fff;
  font-family: PingFangSC-Regular;

  h2 {
    margin: 0;
    padding-top: 40px;
    padding-bottom: 20px;
    font-size: 36px;
    font-weight: 500;
  }

  p {
    font-size: 18px;
  }
}
</style>
