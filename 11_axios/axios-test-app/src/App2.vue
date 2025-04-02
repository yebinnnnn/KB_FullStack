<template lang="">
  <div></div>
</template>
<script setup>
import axios from 'axios';

const requestAPI = async () => {
  const url = '/api/todos/1';
  const listUrl = '/api/todos/';
  let todoList;

  let response = await axios.get(listUrl);
  todoList = response.data;
  console.log(todoList);
};

requestAPI();
</script>
<style lang=""></style>
