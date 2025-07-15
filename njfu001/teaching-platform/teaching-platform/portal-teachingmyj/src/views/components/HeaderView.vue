<script setup>
import {ref} from "vue";
import headLogo from "../../assets/images/Index/head-logo.png"


const menus = ref([
  {
    url: '/appdashboard',
    text: '首页',
    iconpic: 'fa fa-home'
  }, {
    url: '/appvlabpage',
    text: '虚拟实验',
    iconpic: 'fa fa-eyedropper',
  }, {
    url: '/appcourse',
    text: '在线课程',
    iconpic: 'fa fa-play-circle-o'
  }, {
    url: '/appexamcert/appexam',
    text: '考试中心',
    iconpic: 'fa fa-pencil-square-o',
  }, {
    url: '/appexamcert/appcert',
    text: '证书查询',
    iconpic: 'fa fa-certificate',
  }
])

const apppercenterMenu = ref({
  url: '/apppersonal/myVirtualLab',
  text: '个人中心',
  iconpic: 'fa fa-user-o',
})
</script>

<template>
  <div class="header-view">
    <div class="main">
      <div class="left-box">
        <div class="logo">
          <img :src="headLogo">
        </div>
        <div class="menus">
          <router-link
            v-for="menu in menus"
            :key="menu.url"
            :to="menu.url"
          >
            <div>
              <i :class="menu.iconpic"></i>
              {{ menu.text }}
            </div>
          </router-link>
        </div>
      </div>

      <div class="right-box">
        <div class="menus">
          <router-link :to="apppercenterMenu.url">
            <i :class="apppercenterMenu.iconpic"></i>
            {{ apppercenterMenu.text }}
          </router-link>
        </div>
        <div class="logins">
          <div class="login">
            <span>登录</span>
            <span class="line">|</span>
            <span>注册</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.header-view {
  //border: 1px solid;
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 60px;
  background: linear-gradient(90deg, rgb(245, 230, 226, 1) 0%, rgb(248, 243, 234, 1) 40%, rgb(248, 243, 234, 1) 60%, rgb(245, 230, 226, 1) 100%);
  box-shadow: 0px 2px 6px rgba(127, 127, 127, 0.35);
  display: flex;
  justify-content: center;
}

.main {
  display: flex;
  height: 100%;
  justify-content: space-between;
  align-items: center;
  width: 80%;

  .left-box {
    display: flex;
    align-items: center;
    flex: 8;  /* This will make the left box take most of the space */
  }

  .right-box {
    display: flex;
    align-items: center;
    justify-content: flex-end; /* This will push content to the right */
    gap: 20px; /* Space between personal center and login */
  }
}

.logo {
  cursor: pointer;
  margin-right: 30px;

  img {
    height: 60px;
  }
}

.menus {
  display: flex;
  align-items: center;

  div {
    cursor: pointer;
  }

  a {
    margin-right: 42px;
    color: #596069;
    display: flex;
    align-items: center;
    gap: 5px;

    &:hover {
      color: var(--text-hover-color);
      cursor: pointer;
    }
  }

  .active {
    color: var(--text-hover-color);
    font-weight: bold;
  }
}

.logins {
  .login:hover {
    cursor: pointer;
    color: var(--text-hover-color);
  }

  .line {
    margin: 0 10px;
  }
}
</style>
