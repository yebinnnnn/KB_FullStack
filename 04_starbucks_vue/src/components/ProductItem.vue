<script>
export default {
  name: 'ProductItem',
  props: ['childProduct'],
};
</script>
<template>
  <div :class="`td ${childProduct.prodNo}`">
    <ul>
      <li>
        <img
          :src="`./images/${childProduct.prodNo}.jpg`"
          :alt="`${childProduct.prodName}상품의 이미지입니다`"
        />
      </li>
      <li>{{ childProduct.prodName }}</li>
    </ul>
  </div>
</template>
<style scoped></style>
