<script>
export default {
  name: 'Login',
  data() {
    return {
      //데이터(Model)
      // id: "id99",
      // pwd: "pwd99",

      customer: {
        id: 'id99',
        pwd: 'pwd99',
      },
      saveId: true,
    };
  },
  methods: {
    clickLoginButton() {
      alert('button클릭됨');
    },
    async submitForm(event) {
      alert('form서브밋됨');
      // console.log(this.id, this.pwd, this.saveId)
      console.log(this.customer, this.saveId);
      // event.preventDefault(); //폼의 submit이벤트의 디폴트핸들러 막기. 수식어 @submit.prevent로도 가능

      const url = 'http://localhost:3000/login';
      const params = new URLSearchParams();
      params.append('id', this.customer.id);
      params.append('pwd', this.customer.pwd);
      console.log(params.toString());
      // XMLHttpRequest객체활용
      const requestInit = {
        method: 'POST',
        body: params,
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        },
      };
      // fetch(url, requestInit) //1.요청하기
      //     .then((res) => {    //2-1.성공된 응답받기
      //         const responseDataPromise = res.text() //3.응답내용을 문자열로 얻기
      //         return responseDataPromise
      //     }).then((responseData) => { //4.응답내용 문자열
      //         alert(responseData)
      //     }).catch((err) => { //2-2.실패된 응답받기: 네트워크 오류, 잘못된 URL
      //         alert(err.message)
      //     })

      // try {
      //     const responseData = await fetch(url, requestInit) //1.요청하기
      //         .then((res) => {    //2-1.성공된 응답받기
      //             const responseDataPromise = res.text() //3.응답내용을 문자열로 얻기
      //             return responseDataPromise
      //         })
      //     //4.응답내용 문자열
      //     alert(responseData)
      // } catch (err) { //2-2.실패된 응답받기 :  네트워크 오류, 잘못된 URL
      //     alert(err.message)
      // }

      try {
        const res = await fetch(url, requestInit); //1.요청하기 2-1.성공된 응답받기
        const responseData = await res.text(); //3.응답내용을 문자열로 얻기
        //4.응답내용 문자열
        alert(responseData);
      } catch (err) {
        //2-2.실패된 응답받기 :  네트워크 오류, 잘못된 URL
        alert(err.message);
      }
    },
  },
};
</script>
<template>
  <form @submit.prevent="submitForm">
    <!-- <form method="post" action="http://localhost:3000/login"> -->
    <!-- <input type="text" v-model="id" placeholder="아이디 입력하세요"><br> -->
    <!-- <input type="password" v-model="pwd" placeholder="비밀번호 입력하세요"><br> -->

    <input
      type="text"
      v-model="customer.id"
      name="id"
      placeholder="아이디 입력하세요"
    /><br />
    <input
      type="password"
      v-model="customer.pwd"
      name="pwd"
      placeholder="비밀번호 입력하세요"
    /><br />
    <!-- <input type="checkbox" v-model="saveId">아이디저장<br> -->
    <div class="renew_input_box">
      <input type="checkbox" v-model="saveId" class="mem2" /><label
        >아이디저장</label
      ><br />
    </div>
    <button @click="clickLoginButton">로그인</button>
    <!-- button type="submit"과 같음 -->
    <!--버튼이 클릭되면 
            1. 버튼의 click이벤트 발생  -> 사용자정의 이벤트핸들러(clickLoginButton) 처리
            2. 폼의 submit이벤트 발생   -> 사용자정의 이벤트핸들러(submitForm) 처리
            3. 폼의 submit이벤트의 디폴트핸들러가 처리됨 
               (디폴트핸들러가 하는 일 : 
                폼의 action속성값에 해당하는 URL로 입력값(name=value)들 전송, 
                action속성값이 없으면 현재사용중인 URL로 입력값들 전송 )
            -->
  </form>
</template>
<style scoped></style>
