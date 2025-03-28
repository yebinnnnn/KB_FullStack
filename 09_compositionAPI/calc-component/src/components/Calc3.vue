<template>
  <div>
    X : <input type="text" v-model.number="state.x" /><br />
    Y : <input type="text" v-model.number="state.y" /><br />
  </div>
  <button @click="calcAdd">계산</button>
  <div>결과: {{ state.result }}</div>
</template>
<script>
import { reactive } from 'vue';
export default {
  name: 'Calc3',
  //   반응성 reactive import
  setup() {
    const state = reactive({ x: 10, y: 20, result: 30 });
    const calcAdd = () => {
      state.result = state.x + state.y;
    };
    return { state, calcAdd };
  },
};
</script>
