import './assets/main.css';
// 전역 CSS 파일을 import 해 놓을 파일 (main.js)
//부트스트랩 추가
import { createApp } from 'vue';
import App from './App.vue';

//createApp(App).mount('#app');
import router from './router'; //./router/index.js 로 적어도 됨.
const app = createApp(App);
app.use(router);
app.mount('#app');
