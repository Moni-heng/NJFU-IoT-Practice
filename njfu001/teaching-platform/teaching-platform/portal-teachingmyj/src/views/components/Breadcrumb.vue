<script setup>
import { computed } from 'vue'

const props = defineProps({
  data: {
    type: [String, Array],
    default: '在线课程',
  },
  returnPath: {
    type: String,
    default: '/',
  },
})

// 计算属性：如果data是数组，格式化成字符串显示
const displayData = computed(() => {
  if (Array.isArray(props.data)) {
    // 这里假设数组元素是对象或者字符串，优先取 name 字段
    return props.data.map(item => (typeof item === 'string' ? item : item.name || '')).join(' / ')
  }
  return props.data
})

// 跳转函数
function goBack() {
  // Vue 3 中模板外访问 $router 需要通过 useRouter，或者用 emit 事件交给父组件
  // 这里假设在模板内直接用$router可用
  if (typeof window !== 'undefined' && window.$router) {
    window.$router.push(props.returnPath)
  } else if (typeof window !== 'undefined') {
    // fallback
    window.location.href = props.returnPath
  }
}
</script>

<template>
  <div class="breadcrumb">
    <span class="freext-font-bt2" @click="$router.push(returnPath)">全部</span>
    <span style="padding:0 6px"> / </span>
    <span>{{ displayData }}</span>
  </div>
</template>

<style lang="scss" scoped>
.breadcrumb {
  color: #ddd;
  font-size: 14px;
  line-height: 1;
  color: var(--color-font4);

  .freext-font-bt2 {
    color: var(--color-font4);
    cursor: pointer;

    &:hover,
    &:active {
      color: var(--color-main);
    }
  }
}
</style>
