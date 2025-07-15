<script setup>
import { ref, watch, nextTick } from 'vue'
import arrow from '@/assets/images/arrow.svg'

let list = ref(null)
let listHeight = ref(0)
let isExpand = ref(false)
const categoryId = ref('')
const labelId = ref('')

const props = defineProps({
  categories: {
    type: Array,
    default: () => []
  },
  labels: {
    type: Array,
    default: () => []
  },
})

const emits = defineEmits(['changeCategoryId', 'changeLabelId'])

const changeCategoryId = (id) => {
  categoryId.value = id
  emits("changeCategoryId", id)
}

const changeLabelId = (id) => {
  labelId.value = id
  emits("changeLabelId", id)
}

watch(() => props.labels, () => {
  nextTick(() => {
    computedHeight()
  })
})

const computedHeight = () => {
  listHeight.value = list.value?.clientHeight || 0
  if (listHeight.value > 72) {
    list.value.style.height = '72px'
  }
}

const showMore = () => {
  isExpand.value = !isExpand.value
  if (isExpand.value) {
    if (listHeight.value > 72) {
      list.value.style.height = listHeight.value + 'px'
    }
  } else {
    if (listHeight.value > 72) {
      list.value.style.height = '72px'
    }
  }
}
</script>

<template>
  <div class="category">
    <div class="item">
      <div class="item-t">分类：</div>
      <div class="all" :class="{ active: categoryId === '' }" @click="changeCategoryId('')">全部</div>
      <div class="item-list">
        <span
          v-for="item in props.categories"
          :key="item.id"
          class="tag"
          :class="{ active: categoryId === item.id }"
          @click="changeCategoryId(item.id)"
        >
          {{ item.name }}
        </span>
      </div>
    </div>
    <div class="item">
      <div class="item-t">标签：</div>
      <div class="all" :class="{ active: labelId === '' }" @click="changeLabelId('')">全部</div>
      <div class="list-w">
        <div class="item-list item-list1" ref="list">
          <span
            v-for="item in props.labels"
            :key="item.id"
            class="tag"
            :class="{ active: labelId === item.id }"
            @click="changeLabelId(item.id)"
          >
            {{ item.name }}
          </span>
        </div>
      </div>
      <div class="more" v-if="listHeight > 72" @click="showMore">
        <div class="txt" :style="{ bottom: '14px' }">
          {{ isExpand ? '收起' : '更多' }}
          <img :class="{ expand: isExpand }" :src="arrow" />
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.category {
  margin: 20px auto;
  width: 100%;
  background: #fff;
  position: relative;
  border-radius: 20px;
  padding: 16px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.05);
}

.item {
  display: flex;
  font-size: 14px;
  margin-bottom: 16px;

  .item-t {
    flex: 0 0 52px;
    color: #333;
    line-height: 24px;
  }

  .all {
    flex: 0 0 54px;
    height: 24px;
    line-height: 24px;
    text-align: center;
    color: #7f7f7f;
    font-size: 13px;
    margin-right: 12px;
    margin-bottom: 12px;
    cursor: pointer;
  }

  .active {
    background: rgba(94, 134, 244, 0.1);
    border-radius: 12px;
    color: #5e86f4 !important;
  }

  .item-list {
    display: flex;
    align-items: center;
    flex-wrap: wrap;
    position: relative;

    span {
      padding: 2px 10px;
      color: #7f7f7f;
      margin-bottom: 12px;
      cursor: pointer;
      user-select: none;
    }
  }

  .item-list1 {
    overflow: hidden;
    transition: height 0.4s;
  }

  .more {
    flex: 0 0 42px;
    color: #5e86f4;
    position: relative;
    cursor: pointer;

    .txt {
      position: absolute;
      left: 0;
      bottom: 14px;
      display: flex;
      align-items: center;
      font-size: 12px;

      img {
        margin-left: 2px;
        height: 12px;
      }
    }
    .expand {
      transform: rotate(180deg);
    }
  }
}
</style>
