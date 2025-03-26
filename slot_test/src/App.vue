<script>
import CheckboxItem from './components/CheckboxItem.vue';
export default {
  name: 'App',
  components: { CheckboxItem },
  data() {
    return {
      checkboxData: 'ONE',
    };
  },
};
</script>

<template>
  <p>슬롯 : 부모컴포넌트에서 자식 컴포넌트로 정보를 전달하는 방법이다.</p>
  <ul>
    <!-- li요소를 자식 컴포넌트로 옮겨보자! -->
    <!-- <li><input type="checkbox" /><span>ONE</span></li> -->
    <CheckboxItem :checkboxData="checkboxData">
      <template v-slot:default>
        <span>{{ checkboxData }}</span>
        <span>{{ checkboxData }}</span>
        <span>{{ checkboxData }}</span>
      </template>
      <template v-slot:icon>
        <img :src="checkboxData" alt="" />
      </template>
    </CheckboxItem>
  </ul>
</template>

<style scoped></style>
