<script setup></script>
<template>
  <header>
    <!-- HEAD -->
    <div class="logo"></div>
    <nav>
      <ul class="menu">
        <!-- <li class="products"><a href="#">음료</a></li>
        <li class="cart"><a href="#">장바구니</a></li>
        <li class="orders"><a href="#">주문목록</a></li>
        <li><a href="#">로그인</a></li>
        <li><a href="#">로그아웃</a></li>
        <li><a href="#">가입</a></li> -->
        <li class="products"><router-link to="/Products">음료</router-link></li>
        <li class="cart"><a href="#">장바구니</a></li>
        <li class="orders"><a href="#">주문목록</a></li>
        <li><router-link to="/login">로그인</router-link></li>
        <li><a href="#">로그아웃</a></li>
        <li><router-link to="/signup">가입</router-link></li>
      </ul>
    </nav>
  </header>
</template>
<style scoped></style>
