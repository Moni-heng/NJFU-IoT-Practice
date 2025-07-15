import { createRouter, createWebHistory } from 'vue-router'
import IndexPage from "@/views/layout/IndexPage.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: IndexPage,
      redirect: '/appdashboard/',
      children: [
        {
          path: '/appdashboard/',
          name: 'Home',
          component: () => import('@/views/homeview/HomePage.vue'),
        },
        {
          path: '/appcourse',
          name: 'Course',
          component: () => import('@/views/courselist/CoursePage.vue'),
        },
        {
          path: '/appvlabpage',
          name: 'vlabpage',
          component: () => import('@/views/vlabpage/VirtualLabPage.vue'),
        },
        {
          path: '/appexamcert',
          name: 'appexamcert',
          component: () => import('@/views/personal/ExamCertPage.vue'),
          children: [
            {
              path: 'appexam',
              name: 'appexam',
              component: () => import('@/views/personal/myexam/MyExamIndex.vue'),
            },
            {
              path: 'appcert',
              name: 'appcert',
              component: () => import('@/views//personal/MyCert.vue'),
            },
          ]
        },
        {
          path: '/apppersonal',
          name: 'Personal',
          component: () => import('@/views/personal/personalPage.vue'),
          children: [
            {
              path: 'myVirtualLab',
              name: 'myVirtualLab',
              component: () => import('@/views/personal/myvlab/MyVirtualLab.vue'),
              meta: {title: '我的实验', active: 'myVirtualLab', icon: 'icon-xunixianshi1'},
            },
          ]
        },
        // ✅ 添加课程详情页
        {
          path: '/appcourseinfo',
          name: 'CourseInfoPage',
          component: () => import('@/views/courseinfo/CourseInfoPage.vue')
        }
      ]
    }
  ]
})

export default router
