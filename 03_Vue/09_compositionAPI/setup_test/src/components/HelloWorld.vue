<!-- <script setup>
defineProps({
  msg: {
    type: String,
    required: true,
  },
})
</script> -->
<script>
export default {
  props: {
    childMsg: {
      type: String,
      required: true,
    },
  },
  setup(props, context) {
    const msg = props.childMsg;
    return { msg };
  },
};
</script>
<template>
  <div class="greetings">
    <h1 class="green">{{ msg }}</h1>
  </div>
</template>
<style scoped>
h1 {
  font-weight: 500;
  font-size: 2.6rem;
  position: relative;
  top: -10px;
}
h3 {
  font-size: 1.2rem;
}
.greetings h1,
.greetings h3 {
  text-align: center;
}
@media (min-width: 1024px) {
  .greetings h1,
  .greetings h3 {
    text-align: left;
  }
}
</style>
