<template></template>
<script>
import { ref } from 'vue';

export default {
  name: 'InputTodo',
  setup(props, context) {
    const todo = ref('');
    const addTodoHandler = () => {
      if (todo.value.length >= 3) {
        context.emit('add-todo', todo.value);
        todo.value = '';
      }
    };
    return { todo, addTodoHandler };
  },
};
</script>
