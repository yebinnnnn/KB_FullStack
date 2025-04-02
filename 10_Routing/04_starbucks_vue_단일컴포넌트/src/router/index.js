import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import Products from '@/pages/Products.vue';
import Login from '@/pages/Login.vue';
import Signup from '@/pages/Signup.vue';
import NotFound from '@/pages/NotFound.vue';
import Product from '@/pages/Product.vue';

const router = createRouter({
  history: createWebHistory(), //라우팅 모드설정
  routes: [
    { path: '/', component: Home }, //각각의 라우트
    {
      path: '/products',
      component: Products,
      name: 'Products',
      children: [{ path: '/product/:prodNo', component: Product }],
    },
    { path: '/product/:prodNo', component: Product }, // /products/C0002 이 형태의 URI 로 전달
    //currentRout.param 속성으로 가능
    { path: '/login', component: Login },
    { path: '/signup', component: Signup },
    { path: '/:paths(.*)*', name: 'NotFound', component: NotFound },
  ],
});
export default router; //쓸 수 있도록 export
