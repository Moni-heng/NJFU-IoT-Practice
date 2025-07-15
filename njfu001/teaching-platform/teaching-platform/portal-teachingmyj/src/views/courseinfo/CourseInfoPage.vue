<template>
  <div id="mainContainer">
    <!-- 顶部背景封面 -->
    <div id="coverContainer">
      <div id="topbkImg" :style="`background-image: url(${logo})`"></div>
      <div id="topImgCover"></div>

      <!-- 浮层内容 -->
      <div id="courseInfoOverlay" class="center-content">
        <el-row>
          <Breadcrumb :data="baseDetailsData.categories" :return-path="`/appcourse`" />
        </el-row>

        <div class="topTitle">{{ baseDetailsData.name }}</div>

        <el-row class="info-row">
          <!-- 左侧课程信息 -->
          <el-col :md="16">
            <div class="left-area">
              <div class="left-area-top">
                <div class="left-area-item">
                  <div><span>学分：</span><span>{{ baseDetailsData.credit }}</span></div>
                  <div><span>负责人：</span><span>{{ director }}</span></div>
                </div>
                <div class="left-area-item">
                  <div><span>学时：</span><span>{{ baseDetailsData.classhourNum }}</span></div>
                  <div><span>学校：</span><span>{{ baseDetailsData.collegeName }}</span></div>
                </div>
                <div class="left-area-item" style="flex: 2;">
                  <div><span>分类：</span><span>{{ formatCategories(baseDetailsData.categories) }}</span></div>
                  <div><span>讲师：</span><span>{{ teacherNames }}</span></div>
                </div>
              </div>

              <div class="left-area-down">
                <span>累计选课 <span class="outstand-info">{{ baseDetailsData.selectionNum }}人</span></span>
                <span style="margin: 0 12px;">•</span>
                <span>累计互动 <span class="outstand-info">{{ baseDetailsData.interactionNum }}次</span></span>
              </div>
            </div>
          </el-col>

          <!-- 右侧按钮区 + 学期选择 -->
          <el-col :md="8">
            <div class="right-area">
              <!-- 三个按钮 -->
              <div class="button-group">
                <div class="action-btn intro" @click="playHandle('1')">简介视频</div>
                <div class="action-btn guide" @click="playHandle('2')">引导视频</div>
                <div class="action-btn join" @click="selectedClassOpen()">加入学习</div>
              </div>

              <!-- 学期下拉选择 -->
              <el-select
                v-model="baseDetailsData.currentTerm"
                placeholder="请选择学期"
                class="term-select"
                @change="handleTermChange"
              >
                <el-option
                  v-for="item in baseDetailsData.teachingClasses"
                  :key="item.termId"
                  :label="item.termName"
                  :value="item.termId"
                >
                  <span style="float: left">{{ item.termName }}</span>
                  <span class="item-list-label-span" :style="item.planState === 1 ? 'color: #4db2fc;' : ''">
                    {{ item.planState === 1 ? '选课中' : item.planState === 3 ? '已结束' : '在运行' }}
                  </span>
                </el-option>
              </el-select>
            </div>
          </el-col>
        </el-row>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from 'vue'
import proxy from '@/config/proxy.js'
import Breadcrumb from '@/views/components/Breadcrumb.vue'
import { getCourseDetailApi } from '@/apis/curriculum'
import { ElMessage } from 'element-plus'

const env = import.meta.env.MODE || 'development'
const host = proxy[env].host

const logo = ref('')
const courseId = ref('')

const baseDetailsData = ref({
  name: '',
  credit: 0,
  classhourNum: 0,
  collegeName: '',
  categories: [],
  selectionNum: 0,
  interactionNum: 0,
  currentTerm: '',
  teachingClasses: [],
  teachers: [],
  contacts: []
})

const director = computed(() => {
  const contacts = baseDetailsData.value.contacts
  return contacts?.length > 0 ? contacts[0].name : ''
})

const teacherNames = computed(() => {
  const teachers = baseDetailsData.value.teachers
  return teachers?.length > 0 ? teachers.map(t => t.name).join('、') : ''
})

const playHandle = (type) => {
  ElMessage.info(type === '1' ? '播放简介视频' : '播放引导视频')
}

const selectedClassOpen = () => {
  if (!baseDetailsData.value.currentTerm) {
    ElMessage.warning('请先选择学期')
    return
  }
  ElMessage.success('加入学习已触发')
}

const handleTermChange = (termId) => {
  console.log('学期已更改为:', termId)
  // 这里可以添加学期变更后的逻辑
}

const getCourseDetailsData = () => {
  getCourseDetailApi(courseId.value)
    .then(res => {
      if (res.code === 200) {
        const data = res.data

        // ✅ 手动模拟学期数据（用于测试 UI）
        if (!data.teachingClasses || data.teachingClasses.length === 0) {
          data.teachingClasses = [
            {
              termId: '20242',
              termName: '2024-2025学年第2学期',
              planState: 1 // 选课中
            },
            {
              termId: '20241',
              termName: '2024-2025学年第1学期',
              planState: 2 // 在运行
            },
            {
              termId: '20231',
              termName: '2023-2024学年第2学期',
              planState: 3 // 已结束
            }
          ]
        }

        baseDetailsData.value = data

        if (data.teachingClasses && data.teachingClasses.length > 0) {
          baseDetailsData.value.currentTerm = data.teachingClasses[0].termId
        } else {
          ElMessage.warning('该课程暂无学期信息')
        }
      } else {
        ElMessage.error(res.data.msg || '获取课程详情失败')
      }
    })
    .catch(() => {
      ElMessage.error('请求出错！')
    })
}


const formatCategories = (categories) => {
  if (!categories) return ''
  return Array.isArray(categories)
    ? categories.map(c => (typeof c === 'string' ? c : c.name || '')).join(' / ')
    : categories
}

onMounted(() => {
  const params = new URLSearchParams(window.location.search)
  const id = params.get('id')
  const coverUrl = params.get('logo')
  logo.value = host + coverUrl
  courseId.value = id
  getCourseDetailsData()
})
</script>

<style lang="scss" scoped>
#mainContainer {
  width: 100%;
}
#coverContainer {
  position: relative;
  width: 100%;
}
#topbkImg {
  height: 240px;
  background-size: cover;
  background-position: center;
  border-radius: 10px;
  filter: blur(2px);
}
#topImgCover {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  height: 240px;
  background: linear-gradient(to right, rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.15));
  border-radius: 10px;
}
#courseInfoOverlay {
  position: absolute;
  top: 0;
  width: 100%;
  padding: 30px;
  color: #fff;
  box-sizing: border-box;
}
.topTitle {
  font-size: 20px;
  font-weight: bold;
  margin: 16px 0;
}
.left-area-top {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
  font-size: 14px;
}
.left-area-item {
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: 4px;
  min-width: 120px;
}
.left-area-down {
  margin-top: 10px;
  font-size: 14px;
  display: flex;
  align-items: center;
}
.outstand-info {
  color: #4db2fc;
  font-weight: bold;
}
.right-area {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  gap: 16px;
  padding-top: 20px;
}
.button-group {
  display: flex;
  gap: 12px;
  flex-wrap: wrap;
  justify-content: flex-end;
}
.action-btn {
  padding: 8px 16px;
  border-radius: 20px;
  font-size: 14px;
  font-weight: bold;
  color: white;
  cursor: pointer;
  white-space: nowrap;
}
.action-btn.intro {
  background: linear-gradient(to right, #f6b36e, #f0932b);
}
.action-btn.guide {
  background: linear-gradient(to right, #ef7d58, #de4b39);
}
.action-btn.join {
  background: linear-gradient(to right, #a678f0, #9255f5);
}
.term-select {
  width: 100%;
  border-radius: 20px;
  :deep(.el-input__inner) {
    border-radius: 20px;
    background-color: rgba(255, 255, 255, 0.2);
    border: none;
    color: white;
    &::placeholder {
      color: rgba(255, 255, 255, 0.7);
    }
  }
  :deep(.el-input__suffix) {
    .el-input__icon {
      color: white;
    }
  }
}
.item-list-label-span {
  float: right;
  margin-left: 10px;
  font-size: 12px;
}
</style>
