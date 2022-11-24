<template>
  <v-layout row wrap>
    <v-flex xs12 class="text-xs-center" mt-5>
      <h1>Sign In</h1>
    </v-flex>
    <v-flex xs12 sm6 offset-sm3 mt-3>
      <form>
        <v-layout column>
          <v-flex>
            <v-text-field
              name="userId"
              label="아이디를 입력하세요"
              id="userId"
              required
              v-model="user.userId"
              @keyup.enter="confirm"
            >
              <!-- type="email" -->
            </v-text-field>
          </v-flex>
          <v-flex>
            <v-text-field
              name="userPassword"
              label="비밀번호를 입력하세요"
              id="userPassword"
              type="password"
              required
              v-model="user.userPassword"
              @keyup.enter="confirm"
            ></v-text-field>
          </v-flex>
          <v-flex class="text-xs-center" mt-5>
            <v-btn color="yellow" @click="confirm">Sign In</v-btn>
          </v-flex>
        </v-layout>
      </form>
    </v-flex>
  </v-layout>
</template>

<script>
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "UserLogin",
  data() {
    return {
      // isLoginError: false,
      user: {
        userId: null,
        userPassword: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    // confirm() {
    //   console.log(this.user);
    // },

    async confirm() {
      // console.log(this.user);
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      console.log("1. confirm() token >> " + token);
      if (this.isLogin) {
        await this.getUserInfo(token);
        console.log("4. confirm() userInfo :: ", this.userInfo);
        this.$router.push({ name: "main" });
      }
    },
  },
};
</script>

<style></style>
