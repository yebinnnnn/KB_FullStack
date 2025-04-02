<script setup>
import ProductItem from '@/pages/ProductItem.vue';
import Search from '@/pages/Search.vue';
import { ref, reactive, onMounted } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import axios from 'axios';

const router = useRouter();
const products = reactive([]);
const currentPage = ref(1);
const currentRoute = useRoute();

onMounted(async () => {
  console.log('mounted');
  Object.assign(products, await requestProducts());
  console.log(products);
});
const requestProducts = () => {
  let url = 'http://localhost:3000/product';
  // return fetch(url).then((res) => {
  //   return res.json();
  // });
  return axios.get(url).then((res) => {
    return res.data;
  });
};
const clickProduct = (event) => {
  // this : vm객체
  console.log(event.target); //실제이벤트가 발생한 객체(이미지를 클릭했을경우) img객체
  console.log('---------');
  console.log(event.currentTarget); //div객체
  const prodNo = event.currentTarget.getAttribute('class').split(' ')[1]; //[0]는 td, [1]는 C0001

  //location.href = './product.html?prodNo=' + prodNo; //상품상세요청
  const path = '/product/' + prodNo;
  router.push(path);
  // event.stopPropagation(); 대신 @click.stop수식어사용가능
};
</script>
<template>
  <Search @searchProductEvent="childEventHandler" />
  <router-view :key="currentRoute.params.prodNo"></router-view>

  <div class="table">
    <ProductItem
      v-for="p in products"
      :key="p.prodNo"
      @click.stop="clickProduct"
      v-bind:childProduct="p"
    />
  </div>
</template>
<style scoped>
* {
  box-sizing: border-box;
}

div.productlist > div.table {
  width: 80%;
  border: 1px solid;
}
</style>
