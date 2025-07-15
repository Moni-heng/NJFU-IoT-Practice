
<template>
  <div className="module">
    <div className="wrap">
      <!-- 分类筛选组件 -->
      <CategoryFilter
        :categories="categories"
        :labels="labels"
        @changeCategoryId="changeCategoryId"
        @changeLabelId="changeLabelId"
      />

      <!-- 课程列表组件 -->
      <Lists
        :courseList="courseList"
        :loadMoreHint="loadMoreHint"
        :reachMaxCourseNum="reachMaxCourseNum"
        :loading="loading"
      />
    </div>
  </div>
</template>

<script setup>
import {ref, onMounted, watch, nextTick} from 'vue'
import {getCategorysAll, getTagItemList, getCoursesPage} from '@/apis/commonApi'
import CategoryFilter from "@/views/courselist/components/CategoryFilter.vue";
import Lists from "@/views/courselist/components/Lists.vue";
import {useRouter} from 'vue-router'

// 1. 数据定义
// 分类数据
let categories = ref([])
// 标签数据
let labels = ref([])
// 筛选条件
let categoryId = ref('')
let labelId = ref('')
// 课程列表数据
let courseList = ref([])
// 分页数据
const searchData = ref({
  pageNo: 1,
  pageSize: 12,
  pageTotal: 0,
  total: 0
})
// 加载状态
const loading = ref(false)
const loadMoreHint = ref('')
const reachMaxCourseNum = ref(false)
// 路由相关
const Route = useRouter()

// 2. 数据获取方法
// 获取课程分类列表
const getCategoryList = () => {
  getCategorysAll().then((res) => {
    categories.value = res.data
  }).catch(err => {
    console.error(err.responseJSON?.description || '获取分类数据错误')
  })
}

// 获取标签列表
const getTagList = () => {
  getTagItemList().then(res => {
    const data = res.data
    data.forEach(item => {
      item.labelId = item.id // 标签数据处理（文档步骤6-8）
    })
    labels.value = data
  }).catch(err => {
    console.error(err.responseJSON?.description || '获取标签数据失败')
  })
}

// 获取课程列表（文档步骤1.3）
const getCourseList = () => {
  loading.value = true
  if (searchData.value.pageNo) {
    reachMaxCourseNum.value = false
    loadMoreHint.value = ''
  }
  let params = {
    pageNo: searchData.value.pageNo,
    pageSize: searchData.value.pageSize,
    firstCateId: categoryId.value, // 分类筛选条件
    tagId: labelId.value, // 标签筛选条件
  }
  getCoursesPage(params).then((res) => {
    const data = res.data
    searchData.value.total = Number(data.total) // 总条数
    // 分页数据处理：第一页清空原有列表，非第一页追加数据
    const lists = searchData.value.pageNo === 1 ? [] : courseList.value
    if (data.list) {
      data.list.forEach(item => {
        lists.push(item)
      })
    }
    courseList.value = lists
    // 计算总页数
    searchData.value.pageTotal = Math.ceil(searchData.value.total / searchData.value.pageSize)
    // 判断是否加载完所有数据
    if (courseList.value.length >= searchData.value.total) {
      reachMaxCourseNum.value = true
      if (searchData.value.total > 0) {
        loadMoreHint.value = '- 没有更多啦！ ㄟ(￣(￣▽(￣▽￣")▽￣)￣)ㄏ -'
      }
    } else {
      reachMaxCourseNum.value = false
      loadMoreHint.value = '滚动加载更多'
    }
  }).catch(err => {
    console.error(err.responseJSON?.description || '获取课程列表失败')
  }).finally(() => {
    loading.value = false
  })
}

// 3. 页面初始化
onMounted(() => {
  // 获取分类和标签数据
  getCategoryList()
  getTagList()
  // 初始化课程列表滚动监听（文档步骤1.3.5）
  const mainBody = document.getElementById('mainBody')
  const coursepage = document.getElementById('coursepage')
  if (mainBody && coursepage) {
    mainBody.scrollTop = 0
    setTimeout(() => {
      mainBody.addEventListener('scroll', () => {
        if (Route.path !== '/appcourse') return
        if (mainBody.scrollTop + mainBody.offsetHeight >= coursepage.offsetHeight + 50) {
          getNextList() // 滚动到底部加载更多
        }
      })
    }, 100)
  }
})

// 4. 筛选条件变化处理（文档步骤1.3.1）
// 分类切换
const changeCategoryId = (id) => {
  categoryId.value = id
  searchData.value.pageNo = 1 // 重置为第一页
  getCourseList() // 重新获取课程列表
}

// 标签切换
const changeLabelId = (id) => {
  labelId.value = id
  searchData.value.pageNo = 1 // 重置为第一页
  getCourseList() // 重新获取课程列表
}

// 5. 加载更多课程（文档步骤1.3.5）
const getNextList = () => {
  // 判断是否还有下一页
  if (searchData.value.pageNo + 1 <= searchData.value.pageTotal) {
    // 非加载中且未达最大数据量时，加载下一页
    if (!loading.value && !reachMaxCourseNum.value) {
      searchData.value.pageNo++
      getCourseList()
    }
  }
}

// 暴露方法给父组件调用（文档步骤1.3.5）
defineExpose({
  getNextList
})
</script>

<style lang="scss" scoped>
.module {
  position: relative;
}

.wrap {
  width: var(--main-width1);
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
