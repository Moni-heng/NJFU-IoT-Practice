<template>
  <div class="item" @click="goCourseDetail(item.id, item.coverUrl)">
    <div class="card-top">
      <img :src="`${host}${item.coverUrl}`" alt="课程封面" />
    </div>
    <div class="card-bot">
      <div class="title">{{ item.name }}</div>
      <div class="title">{{ item.categories }}</div>
      <div class="desc">
        <div class="num">
          <span><img :src="chapter" style="margin-right: 4px;" />{{ item.classhourNum }}学时</span>
          <span><i class="fa fa-graduation-cap" aria-hidden="true" style="margin-right: 4px;" />{{ item.credit }}学分</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import proxy from '@/config/proxy'
import chapter from '@/assets/images/course/chapter.svg'

const env = import.meta.env.MODE || 'development'
const host = proxy[env]?.host || '' // mock模式或未配置时空字符串

const props = defineProps({
  item: {
    type: Object,
    default: () => ({})
  }
})

// 直接跳转新窗口到课程详情页（带参数）
const goCourseDetail = (id, coverUrl) => {
  window.open(`/appcourseinfo?id=${id}&logo=${coverUrl}`)
}
</script>

<style scoped lang="scss">
.item {
  width: 230px;
  background: #fff;
  margin-right: 22px;
  margin-bottom: 32px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  overflow: hidden;
  transition: all 0.4s;
  cursor: pointer;
}
.item:hover {
  transform: translateY(-10px);
}
.item:nth-child(6n) {
  margin-right: 0;
}

.card-top {
  position: relative;
  height: 132px;
}
.card-top img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.card-bot {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 10px 16px 14px;
  height: 100px;
}

.title {
  color: #555;
  font-size: 13px;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  overflow: hidden;
  text-overflow: ellipsis;
  -webkit-line-clamp: 2;
}

.desc {
  color: #aaaaaa;
  font-size: 12px;
}

.desc .num {
  display: flex;
  justify-content: space-between;
  padding-right: 4px;
}

.desc span {
  display: flex;
  align-items: center;
}

.desc img {
  display: inline-block;
  margin-right: 2px;
}
</style>
