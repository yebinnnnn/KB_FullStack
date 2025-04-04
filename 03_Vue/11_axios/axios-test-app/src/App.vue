<template lang="">
  <div>
    <h2>콘솔을 확인합니다</h2>
  </div>
</template>
<script setup>
import axios from 'axios';

const requestAPI = () => {
  const url = '/api/todos/1';
  const listurl = '/api/todos/';
  const requestAPI = () => {
    let todoList = [];
    axios.get(listurl);
  };
  // axios.get(url).then((response) => {
  //   console.log('응답객체:', response);
  // });
};

requestAPI();
</script>
<style lang=""></style>
