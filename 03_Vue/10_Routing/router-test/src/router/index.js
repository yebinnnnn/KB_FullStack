import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import Members from '@/pages/Members.vue';
import Videos from '@/pages/Videos.vue';
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // 이 배열을 수정할 수 있음. 되도록이면 name 설정해주기
  routes: [
    { path: '/', name: 'home', component: Home },
    { path: '/about', name: 'about', component: About },
    { path: '/members', name: 'members', component: Members },
    { path: '/videos', name: 'videos', component: Videos },
  ],
});

export default router;
