<template>
  <v-layout row wrap>
    <v-flex xs12 class="text-xs-center" mt-5>
      <h1>Sign Up</h1>
    </v-flex>
    <v-flex xs12 sm6 offset-sm3 mt-3>
      <form>
        <v-layout column>
          <v-flex>
            <v-text-field
              name="email"
              label="Email"
              id="email"
              type="email"
              required
              v-model="user.userId"
            ></v-text-field>
          </v-flex>
          <v-flex>
            <v-text-field
              name="password"
              label="Password"
              id="password"
              type="password"
              required
              v-model="user.userPassword"
            ></v-text-field>
          </v-flex>
          <!-- <v-flex>
            <v-text-field
              name="confirmPassword"
              label="Confirm Password"
              id="confirmPassword"
              type="password"
              required
            ></v-text-field>
          </v-flex> -->
          <v-flex>
            <v-text-field
              name="userName"
              label="userName"
              id="userName"
              required
              v-model="user.userName"
            ></v-text-field>
          </v-flex>
          <v-flex>
            <v-text-field
              name="userPhone"
              label="userPhone"
              id="userPhone"
              required
              v-model="user.userPhone"
            ></v-text-field>
          </v-flex>
          <v-flex>
            <v-text-field
              name="userNickname"
              label="userNickname"
              id="userNickname"
              required
              v-model="user.userNickname"
            ></v-text-field>
          </v-flex>
          <v-flex>
            <v-text-field name="address" label="address" v-model="user.companyInfo.address"></v-text-field>
          </v-flex>
          <v-flex>
            <v-text-field
              name="registrationNumber"
              label="registrationNumber"
              id="registrationNumber"
              v-model="user.companyInfo.registrationNumber"
            ></v-text-field>
          </v-flex>

          <v-flex class="text-xs-center" mt-5>
            <v-btn color="yellow" @click="submit">Sign Up</v-btn>
          </v-flex>
        </v-layout>
      </form>
    </v-flex>
  </v-layout>
</template>

<script>
import Constant from "@/common/Constant.js";
import { mapActions } from "vuex";

export default {
  name: "UserRegister",
  data() {
    return {
      user: {
        userId: "",
        userPassword: "",
        userName: "",
        userPhone: "",
        userNickname: "",
        companyInfo: {
          address: "",
          registrationNumber: "",
        },
      },
    };
  },
  methods: {
    ...mapActions("memberStore", [Constant.REGISTER_USER]),
    submit() {
      // this.$v.$touch();
      // console.log(this[Constant.REGISTER_BOARD]);
      if (this.user) this[Constant.REGISTER_USER](this.user);
      this.move();
    },
    moveList() {
      this.$router.push({ name: "main" });
    },
  },
};
</script>

<style></style>
