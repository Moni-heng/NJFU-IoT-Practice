<script setup>
import {ref, onMounted} from 'vue'
import LearnItem from "@/views/homeview/components/learnItem.vue";
import {getCoursesPage} from '@/apis/curriculum'
const onlineCourse = ref([])

const searchData = ref({
  pageNo: 1,
  pageSize: 9,
})

const getOnlineCourseList = () => {
  getCoursesPage(searchData.value).then((res) => {
    console.log("res======>",res)
    let data = res.data
    onlineCourse.value = data.list
  }).catch(err => {
    console.log(err);
  })
}

onMounted(()=>{
  getOnlineCourseList();
})



</script>


<template>
  <div class="module">
    <div class="wrap">
      <div class="content">
        <div class="title-wrap block1">
          <div style="display: flex; align-items: center;">
            <div class="module-title">
              <h3>最新课程</h3>
            </div>
            <p>学习新技能 加强核心竞争力</p>
          </div>
          <div class="more-btn more-btn1">查看更多</div>
        </div>

        <!--<learn-item :datalist="onlineCourse"></learn-item>-->
        <!-- <div class="lists">课程列表</div> -->

        <div class="lists">
          <learn-item :datalist="onlineCourse"></learn-item>
        </div>
      </div>
    </div>
  </div>

</template>


<style lang="scss" scoped>
.module {
  border: 1px solid;
  background: linear-gradient(90deg, rgb(233, 246, 255, 1) 0%, rgb(233, 246, 255, 0.1) 40%, rgb(233, 246, 255, 0.1) 60%, rgb(233, 246, 255, 1) 100%); //堔橙色
  padding: 24px 0 48px 0  ;

  .wrap {
    //border: 1px solid;
    width: 1470px;
    margin: 0 auto;

    .content {
      //border: 1px solid;
      width: 100%;
      border-radius: 8px;
      box-shadow: 0px 4px 4px rgba(127, 127, 127, 0.2);
      overflow: hidden;

      .title-wrap {
        //border: 1px solid;
        height: 60px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 0 20px;
        .module-title {
          font-size: 22px;
          color: #000;
          display: flex;
          font-weight: 600;

          h3 {
            font-size: 22px;
            margin: 0;
          }
        }

        p {
          margin: 0px 15px;
        }

        .more-btn {
          width: 160px;
          height: 34px;
          line-height: 34px;
          border-radius: 6px;
          text-align: center;
          //border: 1px solid;
          //margin: 6px auto 0;
          cursor: pointer;
        }

        .more-btn1 {
          border-color: #6663F3;
          color: #6663F3;

          &:hover {
            background: #6663F3;
            color: #fff;
            font-weight: 700
          }
        }
      }
      .block1 {
        background: linear-gradient(90deg, rgba(232, 239, 255, 1) 0%, rgba(204, 211, 255, 1) 100%);
      }
      .lists {
        border-top-left-radius: 8px;
        border-top-right-radius: 8px;
        padding: 16px 0px 0px 20px;
        display: flex;
        flex-wrap: wrap;
      }




    }
  }
}
</style>
