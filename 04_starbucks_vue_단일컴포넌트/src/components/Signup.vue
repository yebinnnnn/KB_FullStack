<script>
export default {
  name: 'Singup',
  data() {
    return {
      customer: {
        id: 'id77',
        pwd: 'pwd77',
        name: 'TEST77',
      },
      idExist: true,
    };
  },
  methods: {
    async iddupchk() {
      const url = `http://localhost:3000/iddupchk/${this.customer.id}`;
      try {
        const res = await fetch(url);
        if (res.status == 200) {
          this.idExist = false;
        } else {
          this.idExist = true;
        }
      } catch (err) {
        // 네트워크 오류, 잘못된 URL
        alert(err.message);
      }
    },
    submitForm() {
      const url = 'http://localhost:3000/signup';
      const requestData = this.customer; //요청전달데이터(JS객체)
      const requestJson = JSON.stringify(requestData); //JSON.stringify() : JS객체-> JSON문자열로 변환
      //JSON.parse() : JSON문자열 -> JS객체로 변환
      console.log(requestJson);
      const requestInit = {
        method: 'POST',
        body: requestJson,
        headers: {
          'Content-Type': 'application/json', //"multipart/form-data"
        },
      };
      fetch(url, requestInit)
        .then((res) => {
          return res.text();
        })
        .then((responseData) => {
          alert(responseData);
        })
        .catch((err) => {
          alert(err.message);
        });
    },
  },
};
</script>
<template>
  <form @submit.prevent="submitForm">
    ID :
    <input
      type="text"
      v-model="customer.id"
      v-on:focus="
        idExist = true;
        $event.target.select();
      "
    />
    <button type="button" class="bt" v-on:click.stop="iddupchk">
      중복확인
    </button>
    <br />
    PWD : <input type="password" v-model="customer.pwd" />
    <br />
    PWD1 : <input type="password" /><br />
    NAME : <input type="text" v-model="customer.name" />
    <br />
    <button class="bt" v-show="!idExist">가입</button>
  </form>
</template>
<style scoped>
.bt {
  background: #006633;
  color: #fff;
  border-radius: 3px;
  text-align: center;
  margin: 0 20px;
  max-width: 570px;
}
</style>
