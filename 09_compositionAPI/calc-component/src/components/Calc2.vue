<template>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    Y : <input type="text" v-model.number="y" /><br />
  </div>
</template>
<script>
import { ref } from 'vue';

export default {
  name: 'Calc2',
  setup() {
    const x = ref(10);
    const y = ref(20);
    const result = ref(30);
    // 템플릿에서 쓸 수 있게 내보냄.
    const calcAdd = () => {
      result.value = x.value + y.value;
    };
    // 템플릿에서 바로 쓸 수 있다.
    return { x, y, result, calcAdd };
  },
};
</script>
