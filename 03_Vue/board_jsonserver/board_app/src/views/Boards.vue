<template>
  <div>
    <h1><i class="fa solid fa-house"></i>게시판 목록</h1>
    <!--    <button class="btn btn-primary" @click="">글쓰기</button> -->
    <router-link to="/write" /><button
      class="btn btn-primary"
      @click="towrite()"
    >
      글쓰기
    </button>
    <hr />
    {{ boards }}
    <hr />
    <!-- <div class=".row">
      <div class=".col"></div>
    </div> -->
  </div>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>제목</th>
        <th>작성자</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="b in boards" :key="b.id">
        <td>{{ b.id }}</td>
        <td @click="goToBoard(b.id)">{{ b.board_title }}</td>
        <td></td>
        <td>
          <img
            :src="`/src/assets/${b.board_writer}.png`"
            width="60px"
            class="img-thumbnail"
            :alt="오류"
          />{{ b.board_writer }}
        </td>
      </tr>
    </tbody>
  </table>
</template>
<script setup>
import { ref, reactive, onMounted } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import axios from 'axios';

const router = useRouter();
const boards = reactive([]);
const boardsRef = ref([]);
const route = useRoute();

const towrite = async () => {
  router.push('/write');
};
const load = async () => {
  const url = '/api/boards';
  //받아올때 비동기
  const res = await axios.get(url);
  const boardsData = res.data;
  //boardsRef.value 얘는 이걸로 접근 가능
  Object.assign(boards, boardsData); //리엑티브는 이렇게
  //boards.splice(0, boards.length,[])
  boardsRef.value = boardsData;
};

// const goToPage = ()=>{
//   router.push('/Page')
// }
const goToBoard = (id) => {
  router.push(`/boards/${id}`);
};

onMounted(() => {
  load();
});
</script>
<style></style>
