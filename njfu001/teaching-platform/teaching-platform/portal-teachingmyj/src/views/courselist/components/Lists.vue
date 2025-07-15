<template>
  <div class="lists" v-loading="loading">
    <div class="content">
      <!-- 课程列表 -->
      <template v-if="courseList.length">
        <CourseLabItem
          v-for="item in courseList"
          :key="item.id"
          :item="item"
        />
      </template>

      <!-- 空状态 -->
      <template v-if="!courseList.length && !loading">
        <Empty :picWidth="320"/>
      </template>
    </div>

    <!-- 加载提示 -->
    <div>
      <p class="load-more-hint">
        {{ loadMoreHint }}
        <el-icon class="is-loading" v-if="loadMoreHint == '滚动加载更多'">
          <Loading/>
        </el-icon>
      </p>
    </div>
  </div>
</template>

<script setup>
import {Loading} from "@element-plus/icons-vue";
import Empty from "@/views/homeview/components/Empty.vue";
import CourseLabItem from "@/views/courselist/components/CourseLabItem.vue";

// 接收父组件参数
let props = defineProps({
  courseList: {
    type: Array,
    default: []
  },
  loadMoreHint: String,
  reachMaxCourseNum: Boolean,
  loading: Boolean
})
</script>

<style lang="scss" scoped>
.lists {
  width: 100%;
  min-height: 320px;
  margin-top: 10px;
}

.content {
  display: flex;
  flex-wrap: wrap;
}

.load-more-hint {
  text-align: center;
  font-size: 20px;
  color: #ada7a7;
  margin: 20px 0 60px;
}
</style>
