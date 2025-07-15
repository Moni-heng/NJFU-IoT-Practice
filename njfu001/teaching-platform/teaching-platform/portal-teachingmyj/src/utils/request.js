import axios from 'axios'
import proxy from '@/config/proxy'
import router from '../router';
// import {tryRefreshToken} from './refreshToken'

const env = import.meta.env.MODE || 'development';
const host = proxy[env].host; // 如果是mock模式 就不配置host 会走本地Mock拦截
const CODE = {
  LOGIN_TIMEOUT: 1000, REQUEST_SUCCESS: 200, REQUEST_FOBID: 1001,
};

// 登录异常弹窗处理
let isLogin = true
// 刷新标记
// let refreshing = ref(false)
const instance = axios.create({
  baseURL: host, // 'http://172.17.2.134/api-test',
  timeout: 1000, withCredentials: false,
});

instance.interceptors.request.use((config) => {
  //刷新Token请求放行
  if (config.url && (config.url.indexOf("refresh") > 0 || config.url.indexOf("login") > 0)) {
    return config;
  }
  // debugger
  const loginInfo = sessionStorage.getItem('loginInfo');
  // debugger
  if (loginInfo) {
    const loginInfoObj = JSON.parse(loginInfo)
    const access_token = loginInfoObj.access_token
    if (access_token) {
      // console.log("instance.interceptors.request-loginInfo-> ", access_token)
      // 让每个请求携带token--['X-Token']为自定义key 请根据实际情况自行修改
      config.headers["Authorization"] = "Bearer " + access_token
      if (config.url.indexOf('certificate') > 0) {
        // config.headers["Content-Type"] = "multipart/form-data"
      } else {
        config.headers["Content-Type"] = "application/json"
      }
    }
  }
  return config
});
instance.defaults.timeout = 5000;

async function refreshToken(err) {
  // 尝试刷新token
  let success = await tryRefreshToken();
  if (success) {
    // refreshing.value = false;
    return instance(err.config);
  }
  // refreshing.value = false;
  ElMessageBox.alert('请先登录！', '未登录或登录超时', {
    confirmButtonText: '重新登录', callback: () => {
      router.push('/applogin')
    },
  })
  return true;
}


const alertLoginMessage = () => {
  isLogin = false;
  sessionStorage.removeItem('userInfo');
  sessionStorage.removeItem("loginInfo");
  ElMessageBox.confirm('您的账号登录超时或在其他机器登录，请重新登录或更换账号登录！', '登录超时', {
    confirmButtonText: '重新登录', cancelButtonText: '继续浏览', type: 'warning',
  })
    .then(() => {
      router.push('/applogin')
    })
    .catch(() => {
      router.go(0)
    })
}

// const sleep = (delay) => new Promise((resolve) => setTimeout(resolve, delay))
instance.interceptors.response.use(
  async (response) => {
    console.log('response---> ',response)
    // 如果是blob响应，直接返回
    if (response.config.responseType === 'blob') {
      return response;
    }

    // 1.获取业务状态码
    let code = response.data.code;
    // 2.业务状态码为200，直接返回
    if (code === CODE.REQUEST_SUCCESS) {
      return response.data;
    }

    // 3.业务状态码为401，代表未登录
    if (code === 401 && isLogin) {
      isLogin = false;
      alertLoginMessage();
    }

    return response.data;
    /*    // 4.业务状态码为其它，返回异常
        ElMessage({
          message: response.data.msg,
          type: 'error'
        });
        throw new Error(response.data.msg);*/
  },
  async (err) => {
    if (err.response.status === 401 && isLogin) {
      // 登录异常或超时，刷新token
      return refreshToken(err);
    }
    // refreshing = false;
    return Promise.reject(err);
  },
);

export default instance;
//TOken刷新需要重新设计，校验剩余时间，根据剩余时间提前刷新，提升用户体验啊
