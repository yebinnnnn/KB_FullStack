<template>
  <div class="InputName"></div>
  <input name="name" v-model="name" />
</template>
<script>
export default {
  name: 'Child1',
};
</script>
<style scoped>
.child {
  background-color: yellow;

  border: solid 1px black;
  margin: 1.5em;
  padding: 1em;
}
</style>
