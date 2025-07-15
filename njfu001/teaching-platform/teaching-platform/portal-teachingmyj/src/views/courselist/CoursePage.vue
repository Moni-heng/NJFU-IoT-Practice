<template>
  <div className="coursepage" id="coursepage">
    <Welcome
      title="欢迎来到 南京林业大学 在线课程中心"
      content="这里汇聚了众多技术方向的在线课程，你可以加入我们参与课程学习，提升核心竞争力。"
      topbgjpg="/images/covers/backgrounds/8-06.png"
    />
    <TabAndList ref="tabAndListCourse"/>
  </div>
</template>

<script setup>
import {ref, onMounted, onBeforeUnmount} from 'vue';
import Welcome from '@/views/homeview/components/Welcome.vue';
import TabAndList from '@/views/courselist/components/TabAndList.vue';
import {useRoute} from 'vue-router';

const tabAndListCourse = ref(null);
const route = useRoute();

const handleScroll = () => {
  const mainBody = document.getElementById('mainBody');
  const coursepage = document.getElementById('coursepage');

  if (!mainBody || !coursepage) return;
  if (route.path !== '/appcourse') return;

  if (mainBody.scrollTop + mainBody.offsetHeight >= coursepage.offsetHeight + 50) {
    tabAndListCourse.value?.getNextList();
  }
};

onMounted(() => {
  const mainBody = document.getElementById('mainBody');
  if (!mainBody) return;
  mainBody.scrollTop = 0;

  setTimeout(() => {
    mainBody.addEventListener('scroll', handleScroll);
  }, 100);
});

onBeforeUnmount(() => {
  const mainBody = document.getElementById('mainBody');
  if (mainBody) {
    mainBody.removeEventListener('scroll', handleScroll);
  }
});
</script>

<style scoped>
.coursepage {
  padding: 16px;
}
</style>
