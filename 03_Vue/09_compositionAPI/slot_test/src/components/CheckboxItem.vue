<script>
export default {
  //name 옵션. props 옵션 등으로 불린다.
  name: 'CheckboxItem',
  props: {
    checkboxData: {
      type: String,
      required: true,
    },
  },
  data() {
    return {};
  },
  mounted() {
    this.data = this.CheckboxData + '입니다.';
  },
};
</script>
<template>
  <!-- <li>
    <input type="checkbox" /><span>{{ data }}</span>
  </li> -->
  <!-- 늘어나면 유지보수하기 어려움. 부모쪽에서 전달해야 할  props 가 너무 많다 -->
  <li>
    <!--
    <input type="checkbox" />
    <span>{{ data }}</span>
    <span>{{ data }}</span>
    <span>{{ data }}</span> -->
    <input type="checkbox" />
    <!-- 속성값 뿐만 아니라 템플릿 자체를 전달할때 slot 이 사용됨. -->
    <slot></slot>
    <hr />
    <slot name="icon"></slot>
  </li>
</template>
<style></style>
