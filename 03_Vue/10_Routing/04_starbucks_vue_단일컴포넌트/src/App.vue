<script setup>
// setup 하면  export default 필요 없어짐
// 스크립트에서 먼저 import 해야 템플릿에서 사용할 수 있다.
//vite.config.js 에서 /src 를 @로 대체 할 수 있다.
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';
import { RouterView } from 'vue-router';
// import Products from './components/Products.vue';
// import Signup from './components/Signup.vue';
// import Login from './components/Login.vue';
</script>

<template>
  <div>
    <Header />
    <section>
      <article>
        내용
        <!-- <div id="map" style="width: 100%; height: 95%; border: 1px solid"></div> -->
        <router-view></router-view>
        <!-- <Signup /> -->
        <!-- <Login /> -->
      </article>
      <aside>광고</aside>
    </section>
  </div>
  <Footer />
</template>

<style scoped>
/* @import url('/src/assets/base.css'); */
</style>
