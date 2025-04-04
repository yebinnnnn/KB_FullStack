<script setup>
import HelloWorld from './components/HelloWorld.vue'
import TheWelcome from './components/TheWelcome.vue'
import { useCounterStore } from '@/stores/counter.js'

const store = useCounterStore()
const { count, increment, doubleCount } = store
//현재 ref.value의  0 값을 갖고온다. (ref 객체를 갖고오지 않는다.)
//const count=store.count
//const increment=store.increment 와 같은 의미다.
console.log(store.count.value) //value 로 접근하는게 아니다.=>undefined 로 나옴.
console.log('현재 값:' + store.count)

store.increment() //store 내부의 count value 값을 변경시킨것.(비낕의 count 값을 건드린것은 아니다.)
console.log('increment 값' + store.count)
//캐시값을 갖고온다.
console.log('doubleCount값:' + store.doubleCount)
</script>

<template></template>

<style scoped></style>
