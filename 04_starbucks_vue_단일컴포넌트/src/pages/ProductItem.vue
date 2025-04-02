<script setup>
import { ref, reactive, onMounted } from 'vue';

const props = defineProps({ childProduct: {} });
const childProduct = reactive(props.childProduct);
const imageSrc = ref('');
onMounted(() => {});
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
<style scoped>
* {
  box-sizing: border-box;
}
/* div.table .td { */
.td {
  width: 32%;
  border: 1px solid;
  display: inline-block;
}

.td > ul {
  list-style-type: none;
  margin-left: 0px;
}

.td > ul img {
  width: 80%;
  max-width: 300px;
}

.td > ul > li.prod_name {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
