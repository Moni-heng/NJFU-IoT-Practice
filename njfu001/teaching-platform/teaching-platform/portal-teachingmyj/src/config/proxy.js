export default {
  development: {
    // 开发环境接口请求
    host: 'http://localhost:8080',
    // 开发环境 cdn 路径
    cdn: '',
    apiAddr: "localhost:8012",
    unityUrl: 'http://localhost:8003',
  },
  test: {
    // 测试环境接口地址
    host: 'http://locahost:8012',
    // 测试环境 cdn 路径
    cdn: '',
    apiAddr: "localhost:8003",
    unityUrl: 'http://localhost:8003',
  },
  product: {
    // 正式环境接口地址
    host: 'http://localhost:8012',
    // 正式环境 cdn 路径
    cdn: '',
    apiAddr: "localhost:8012",
    unityUrl: 'http://localhost:8003',
  },
};
