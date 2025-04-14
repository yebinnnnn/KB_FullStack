<template>
  <div>
    <h2>게시글 상세 페이지</h2>
    <p>게시글 ID: {{ id }}</p>
    <p>게시글 내용 : {{ content }}</p>
    <!-- 게시글 정보 불러오기 등 구현 -->
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const route = useRoute();
const id = route.params.id.toString(); //params 는 왜
const content = ref('');

onMounted(async () => {
  const res = await axios.get(`/api/boards/${id}`);
  content.value = res.data.board_content;
  // 여기에 axios 등으로 id에 해당하는 게시글 가져오기
  console.log('게시글 ID:', id);
});
</script>
