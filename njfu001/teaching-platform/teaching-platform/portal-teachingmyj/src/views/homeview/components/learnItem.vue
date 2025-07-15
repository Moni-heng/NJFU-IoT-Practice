<script setup>
import proxy from '@/config/proxy'
const env = import.meta.env.MODE || 'development'
const host = proxy[env].host
import chapter from '@/assets/images/course/chapter.svg' // 必须添加这行导入

const props = defineProps({
  datalist: {
    type: Array,
    default: () => []
  },
  itemType: {
    type: String,
    default: 'course'
  }
})
</script>

<template>
  <div class="item item-course"
       v-for="item in datalist" :key="item.id">
    <div class="pic">
      <img :src="`${host}${item.coverUrl}`" alt=""/>
    </div>
    <div class="desc">
      <div class="title">{{ item.name }}</div>
      <div class="title">{{ item.categories }}</div>
      <div class="classhour-credit">
        <div class="num">
          <span><img :src="chapter" style="margin-right: 4px;"/>{{ item.classhourNum }}学时</span>
          <span>
            <span v-show="itemType=='course'"><i class="fa fa-graduation-cap" aria-hidden="true"
                                                 style="margin-right: 4px;"/>{{
                item.credit
              }}学分</span>
          </span>
        </div>
      </div>
    </div>
  </div>
</template>


<style lang="scss" scoped>
.item-course {
  background: linear-gradient(90deg, rgba(232, 239, 255, 1) 0%, rgba(224, 231, 255, 1) 100%);
}

.item {
  display: flex;
  align-items: center;
  margin-bottom: 18px;
  cursor: pointer;
  border-radius: 10px;
  margin-right: 20px;

  .pic {
    flex: 0 0 230px;
    height: 132px;
    border-radius: 10px;
    position: relative;
    overflow: hidden;

    img {
      width: 100%;
      height: 100%;
      transition: all 0.3s ease-in;
      transform: scale(0.88);
      border-radius: 10px;
    }
  }
  &:hover {
    .pic img {
      transform: scale(1.08);
    }
  }
  .desc {
    margin-left: 20px;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    padding: 6px 0;
    height: 132px;
    width: 210px;

    .title {
      font-size: 14px;
      display: -webkit-box;
      -webkit-box-orient: vertical;
      overflow: hidden;
      text-overflow: ellipsis;
      -webkit-line-clamp: 2
    }

    .classhour-credit {
      color: #aaa;
      font-size: 12px;

      .num {
        display: flex;
        justify-content: space-between;
        padding-right: 24px;
        span {
          display: flex;
          align-items: center;
        }
        img {
          display: inline-block;
          margin-right: 2px;
        }
      }
    }
  }
}
</style>
