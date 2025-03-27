<script>
import { ref, reactive } from 'vue';
import HelloWorld from './components/HelloWorld.vue';
export default {
  components: { HelloWorld },
  onMounted: {},
  setup() {
    //create() 역할, data()+methods+ computed
    const refNum = ref(10);
    refNum.value = 20;

    const refObj = ref({ title: 'aaa' });
    refObj.value.title = 'BBB';

    const refArr = ref([]);
    //const 로 선언되어있어서 값을 변경할 수 없으므로 값 자체가 아니라 value 로 접근
    const source = [10, 20, 30];
    // refArr.value = source;
    // refArr.value[0] = 111;
    // console.log(source);
    // 헐~ source 값까지 변경이됨. 콜바이레퍼런스 형태의 참조
    //메모리 어떻게 그리는지 살펴보기

    Object.assign(refArr.value, source); //이게 객체 내용을 복붙하는거~
    refArr.value[0] = 200;
    console.log(source);

    // reactive. 객체를 반환한다.
    const reactiveObj = reactive({ title: 'Hello' });
    reactiveObj.title = 'KB';

    const reactiveArr = reactive([]);
    Object.assign(reactiveArr, source);
    reactiveArr[0] = 111;
    console.log(source);

    const parentMsg = 'HELLOWORLD';
    return { refNum, refObj, refArr, reactiveObj, reactiveArr, parentMsg };
  },
};
</script>

<template>
  <HelloWorld :childMsg="parentMsg" />
  <ul>
    <li>{{ refNum }}</li>
    <input type="text" v-model="refNum" />
    <li>
      {{ refObj }}
    </li>
    <input type="text" v-model="refObj.title" />
    <li>{{ refArr }}</li>
    <input type="text" v-model.number="refArr[1]" />
    <li>{{ reactiveObj }}</li>
    <input type="text" v-model="reactiveObj.title" />
    <li>{{ reactiveArr }}</li>
  </ul>
</template>

<style scoped></style>
