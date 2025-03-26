<script>
export default {
  name: 'Search',
  data() {
    return {
      word: '',
    };
  },
  methods: {
    search() {
      //this.word에 해당하는 이름을 포함한 상품을 검색한다
      const eventName = 'searchProductEvent';
      const eventValue = this.word + '상품을 검색했습니다';
      this.$emit(eventName, eventValue); //이벤트 강제발생
    },
  },
};
</script>
<template>
  <div>
    <input
      type="text"
      placeholder="검색할 상품명을 입력하세요"
      v-model="word"
      @keyup.enter="search"
    />
    <button @click="search">검색</button>
  </div>
</template>
<style scoped></style>
