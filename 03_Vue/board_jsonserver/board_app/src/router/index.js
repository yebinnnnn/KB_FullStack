import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // {
    //   path: '/',
    //   name: 'home',
    //   component: HomeView,
    // },
    {
      path: '/boards',
      name: 'boards',
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/Boards.vue'),
    },
    {
      path: '/write',
      name: 'write',
      component: () => import('../views/Write.vue'),
    },
  ],
});

export default router;
