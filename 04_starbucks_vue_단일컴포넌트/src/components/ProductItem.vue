<script>
export default {
  name: 'ProductItem',
  props: ['childProduct'],

  data() {
    return {
      imageSrc: '',
    };
  },
  mounted() {
    import(`@/assets/images/${this.childProduct.prodNo}.jpg`)
      .then((image) => {
        this.imageSrc = image.default;
        console.log('Image loaded', this.imageSrc);
      })
      .catch((error) => {
        console.error('Error loading image:', error);
      });
  },
};
</script>
<template>
  <div :class="`td ${childProduct.prodNo}`">
    <ul>
      <li>
        <img
          :src="imageSrc"
          :alt="`${childProduct.prodName}상품의 이미지입니다`"
        />
      </li>
      <li>{{ childProduct.prodName }}</li>
    </ul>
  </div>
</template>
<style scoped></style>
