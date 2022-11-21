<template>
  <div>
    <BasicHeader name="로그인" />
    <div class="container my-5">
      <div class="d-flex flex-column align-items-center">
        <form class="row g-1 p-0 p-md-4" style="max-width: 32rem;">
          <ul class="nav nav-tabs tab-body-header rounded d-inline-flex w-50 mb-4">
            <li class="nav-item flex-grow-1 text-center">
              <input value="common" v-model="userType" class="d-none" type="radio" id="common">
              <label :class="[userType=='common' ? 'active' : '']" class="nav-link cursor-pointer" for="common">일반 회원</label>
            </li>
            <li class="nav-item flex-grow-1 text-center">
              <input value="company" v-model="userType" class="d-none" type="radio" id="company">
              <label :class="[userType=='company' ? 'active' : '']" class="nav-link cursor-pointer" for="company">기업 회원</label>
            </li>
          </ul>
          <div class="col-12">
            <div class="mb-2">
              <label class="form-label" for="userId">아이디</label>
              <input v-model="userId" id="userId" type="text" class="form-control form-control-lg" placeholder="아이디를 입력하세요">
            </div>
          </div>
          <div class="col-12">
            <div class="mb-2">
              <div class="form-label" for="userPassword">비밀번호</div>
              <input @keyup.enter="validateForm" v-model="userPassword" id="userPassword" type="password" class="form-control form-control-lg" placeholder="비밀번호를 입력하세요">
            </div>
          </div>
          <div class="col-12 text-center mt-4">
            <a @click="validateForm" class="w-100 btn btn-lg btn-block btn-primary lift text-uppercase">로그인</a>
          </div>
          <div class="d-flex col-12 text-center mt-2">
            <router-link to="/user/join" class="flex-grow-1 btn btn-lg btn-block btn-secondary lift fs-6 text-uppercase">회원가입</router-link>
            &nbsp;&nbsp;
            <router-link to="/user/password" class="flex-grow-1 btn btn-lg btn-block btn-secondary lift fs-6 text-uppercase">비밀번호 찾기</router-link>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import BasicHeader from "@/components/basicLayout/ThePageHeader"
export default {
  name: 'UserLogin',
  data() {
    return {
      userType: 'common',
      userId: '',
      userPassword: '',
    }
  },
  components: {
    BasicHeader,
  },
  methods: {
    
  }
}
</script>

<style>

</style>