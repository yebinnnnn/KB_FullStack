<script setup>
import HelloWorld from './components/HelloWorld.vue';
import TheWelcome from './components/TheWelcome.vue';
import { useCounterStore } from './stores/counter';
import { computed } from 'vue';

const store = useCounterStore();
const { increment } = store;
const count = computed(() => store.count);

console.log(store);
increment();
</script>

<template>
  {{ store.count }}{{ store.doubleCount }}<br />
  {{ count }}
</template>

<style scoped></style>
