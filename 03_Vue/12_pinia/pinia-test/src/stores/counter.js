import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

//곱하기 2 해주는 함수가 포함된 Store가 자동으로 생성됨.
export const useCounterStore = defineStore('counter', () => {
  const count = ref(0)

  //doubleCount는 computedRef 객체를 참조.
  const doubleCount = computed(() => count.value * 2)
  function increment() {
    count.value++
  }

  return { count, doubleCount, increment }
})
