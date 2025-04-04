<template>
  <InputName />
  <h3>검색어 : {{ searchName }}</h3>
  <div>
    <Child1 />
    <Child2 />
    <Child3 />
  </div>
</template>
<script>
import Child1 from './components/Child1.vue';
import Child2 from './components/Child2.vue';
import Child3 from './components/Child3.vue';
import InputName from './components/InputName.vue';
export default {
  name: 'App',
  components: { Child1, Child2, Child3, InputName },
  data() {
    return { searchName: 'John' };
  },
};
</script>
