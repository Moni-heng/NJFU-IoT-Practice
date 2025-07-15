// import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'
import 'element-plus/dist/index.css'
import '@/views/style/index.scss'
const app = createApp(App)

app.use(router)
app.use(createPinia())

app.mount('#app')
