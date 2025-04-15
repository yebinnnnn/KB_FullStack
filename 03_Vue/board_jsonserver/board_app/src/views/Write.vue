<template lang="">
  <div>
    글쓰기
    <button class="btn btn-primary" @click="wrcontent">작성</button>
    <!-- <router-link to="/boards"/> -->
    <button class="btn btn-primary" @click="goToBack">취소</button>
  </div>

  <div class="form-group">
    <label>제목</label>
    <input type="text" class="form-control" v-model="form.board_title" />
  </div>

  <div class="form-group">
    <label>내용</label>
    <textarea class="form-control" v-model="form.board_content"></textarea>
  </div>

  <div class="form-group">
    <label>작성자</label>
    <input type="text" class="form-control" v-model="form.board_writer" />
  </div>
</template>
<script setup>
import { useRouter } from 'vue-router';
import { onMounted, ref, reactive } from 'vue';
import axios from 'axios';

const deletewr = async (id) => {
  const url = `api/boards/${id}`;
  try {
    await axios.delete(url);
    alert('삭제 완료!');
    router.push('/boards'); // 목록으로 이동
  } catch (err) {
    console.log(err);
  }
};

const router = useRouter();
const form = ref({
  board_title: '',
  board_writer: '',
  board_content: '',
});

const goToBack = async () => {
  router.push('/boards');
};

const wrcontent = async () => {
  const url = 'api/boards';
  try {
    await axios.post(url, form.value);
    alert('등록 완료!');
    router.push('/boards'); // 목록으로 이동
  } catch (err) {
    console.log(err);
  }
};
</script>
<style lang=""></style>
