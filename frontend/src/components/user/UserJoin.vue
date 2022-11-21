<template>
  <div>
    <BasicHeader name="회원가입" />
    <div class="container my-5">
      <div class="d-flex flex-column align-items-center">
        <ul class="nav nav-tabs tab-body-header rounded d-inline-flex w-25 mb-4">
          <li class="nav-item flex-grow-1 text-center">
            <input value="common" v-model="userType" class="d-none" type="radio" id="common">
            <label :class="[userType=='common' ? 'active' : '']" class="nav-link cursor-pointer" for="common">일반 회원</label>
          </li>
          <li class="nav-item flex-grow-1 text-center">
            <input value="company" v-model="userType" class="d-none" type="radio" id="company">
            <label :class="[userType=='company' ? 'active' : '']" class="nav-link cursor-pointer" for="company">기업 회원</label>
          </li>
        </ul>
        <form class="row g-1 p-0 p-md-4 w-100">
          <table>
            <tr>
              <td style="width: 15%;" class="px-4 border-top border-dark"><label class="mb-4 form-label" for="userName">이름 <span class="text-danger">*</span></label></td>
              <td class="px-4"><input v-model="userName" id="userName" type="text" class="mb-4 form-control form-control-lg"></td>
            </tr>
            <tr>
              <td class="px-4 border-top border-dark"><label class="mb-4 form-label" for="userId">아이디 <span class="text-danger">*</span></label></td>
              <td v-if="userIdChk" class="px-4">
                <input v-model="userId" @change="idcheck" id="userId" type="text" class="mb-4 form-control form-control-lg">
              </td>
              <td v-else class="px-4 form-floating">
                <input v-model="userId" @change="idcheck" id="userId" type="text" class="mb-4 form-control is-invalid form-control-lg">
                <label for="userId" class="ps-5 text-danger">중복된 아이디가 존재합니다. 다른 아이디를 입력하세요.</label>
              </td>
            </tr>
            <tr>
              <td class="px-4 border-top border-dark"><label class="mb-4 form-label" for="userPassword">비밀번호 <span class="text-danger">*</span></label></td>
              <td v-if="userPwdChk" class="px-4">
                <input v-model="userPassword"  id="userPassword" type="password" class="mb-4 form-control form-control-lg">
              </td>
              <td v-else class="px-4 form-floating">
                <input v-model="userPassword"  id="userPassword" type="password" class="mb-4 form-control is-invalid form-control-lg">
                <label for="userPassword" class="ps-5 text-danger">비밀번호가 일치하지 않습니다. </label>
              </td>
            </tr>
            <tr>
              <td class="px-4 border-top border-dark"><label class="mb-4 form-label" for="userRePassword">비밀번호 확인 <span class="text-danger">*</span></label>
              </td>
              <td v-if="userPwdChk" class="px-4">
                <input v-model="userRePassword" @change="passwordcheck" id="userRePassword" type="password" class="mb-4 form-control form-control-lg">
              </td>
              <td v-else class="px-4 form-floating">
                <input v-model="userRePassword" @change="passwordcheck" id="userRePassword" type="password" class="mb-4 form-control is-invalid form-control-lg">
                <label for="userRePassword" class="ps-5 text-danger">비밀번호가 일치하지 않습니다. </label>
              </td>
            </tr>
            <tr>
              <td class="px-4 border-top border-dark"><label class="mb-4 form-label" for="userEmail">이메일 <span class="text-danger">*</span></label></td>
              <td class="px-4"><input v-model="userEmail" id="userEmail" type="email" class="mb-4 form-control form-control-lg"></td>
            </tr>
            <tr>
              <td class="px-4 border-top border-dark"><label class="mb-4 form-label" for="userEmail">휴대전화 <span class="text-danger">*</span></label></td>
              <td class="px-4"><input v-model="userPhone" id="userPhone" type="text" class="mb-4 form-control form-control-lg"></td>
            </tr>
            <tr v-if="userType === 'company'">
              <td class="px-4 border-top border-dark"><label class="mb-4 form-label" for="userAddress">주소 <span class="text-danger">*</span></label></td>
              <td class="px-4"><input v-model="userAddress" id="userAddress" type="text" class="mb-4 form-control form-control-lg"></td>
            </tr>
          </table>
          <div class="col-12 text-center mt-4">
            <router-link to="/user/login" class="btn px-4 btn-block btn-secondary lift text-uppercase">로그인 이동</router-link>&nbsp;
            <a @click="join" class="btn px-4 btn-block btn-primary lift text-uppercase">회원가입</a>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>


<script>
import BasicHeader from "@/components/basicLayout/ThePageHeader"
// import http from "@/common/axios";

export default {
  name: 'UserJoin',
  data() {
    return {
      userId: '',
      userPassword: '',
      userRepassword: '',
      userName: '',
      userNickname: '',
      userPhone: '',
      companyAddress: '',
      companyRegistrationNumber: '',
      userValidateId: true,
      userValidateNickname: true,
      userValidatePassword: true,
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