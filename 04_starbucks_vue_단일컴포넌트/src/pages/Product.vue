<script setup>
import { ref, reactive, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const p = reactive({});
onMounted(async () => {
  const currentRoute = useRoute();
  const query = currentRoute.query;
  // const prodNo = query.prodNo;
  // let url = `http://localhost:3000/product/${prodNo}`;
  // console.log(url);

  //PATH variable 을 사용할때
  const param = currentRoute.params;
  const prodNo = param.prodNo;
  let url = `http://localhost:3000/product/${prodNo}`;
  console.log(url);

  try {
    const response = await fetch(url);
    const productData = await response.json();
    Object.assign(
      p,
      await axios.get(url).then((res) => {
        return res.data;
      })
    );
    console.log(p);
  } catch (err) {
    console.log('상품 로드 실패');
  }
});
</script>
<template lang="">
  <div>
    <img
      :src="'/images/' + p.prodNo + '.jpg'"
      :alt="`${p.prodName}상품의 이미지 입니다.`"
    />
    <hr />
    <div class="detail">
      <ul>
        <li class="prodNo">{{ p.prodNo }}</li>
        <li class="prodName">{{ p.prodName }}</li>
        <li class="quantity">
          <input type="number" value="1" min="1" max="99" />
        </li>
        <li><button>장바구니 담기</button></li>
      </ul>
    </div>
  </div>
</template>
<style lang=""></style>
