<script>
import ProductItem from './ProductItem.vue';
import Search from './Search.vue';
export default {
  name: 'Products',
  components: { ProductItem, Search },
  data() {
    return {
      products: [],
    };
  },

  async mounted() {
    console.log('mounted');
    this.products = await this.requestProducts();
    console.log(this.products);
  },
  methods: {
    childEventHandler(eventValue) {
      alert(eventValue);
    },
    requestProducts() {
      let url = 'http://localhost:3000/product';
      return fetch(url).then((res) => {
        return res.json();
      });
    },
    clickProduct(event) {
      // this : vm객체
      console.log(event.target); //실제이벤트가 발생한 객체(이미지를 클릭했을경우) img객체
      console.log('---------');
      console.log(event.currentTarget); //div객체
      const prodNo = event.currentTarget.getAttribute('class').split(' ')[1]; //[0]는 td, [1]는 C0001

      location.href = './product.html?prodNo=' + prodNo; //상품상세요청
      // event.stopPropagation(); 대신 @click.stop수식어사용가능
    },
  },
};
</script>
<template>
  <Search @searchProductEvent="childEventHandler" />
  <div class="table">
    <!-- <div
      :class="`td ${p.prodNo}`"
      v-for="p in products"
      :key="p.prodNo"
      @click.stop="clickProduct"
    ></div> -->
    <ProductItem
      v-for="p in products"
      :key="p.prodNo"
      @click.stop="clickProduct"
      v-bind:childProduct="p"
    />
  </div>
</template>
<style scoped>
div.productlist > div.table {
  width: 80%;
  border: 1px solid;
}

div.productlist > div.table .td {
  width: 32%;
  border: 1px solid;
  display: inline-block;
}

div.productlist > div.table .td > ul {
  list-style-type: none;
  margin-left: 0px;
}

div.productlist > div.table .td > ul img {
  width: 80%;
  max-width: 300px;
}

div.productlist > div.table .td > ul > li.prod_name {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

/* 
@media scree and (max-width:960px){
    div.productlist>div.table .td{
        width:45%; 
    }
}

@media scree and (max-width:480px){
    div.productlist>div.table .td{
        width:100%; 
    }
} */
</style>
