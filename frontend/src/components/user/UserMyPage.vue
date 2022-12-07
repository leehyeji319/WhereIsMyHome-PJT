<template>
  <div>
    <v-card max-width="1000" class="mt-8">
      <v-row>
        <v-col cols="12" md="4">
          <v-img
            class="ml-5"
            contain
            src="https://t3.ftcdn.net/jpg/03/46/83/96/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg"
            height="300px"
            sizes="80"
          ></v-img>
        </v-col>

        <v-col cols="12" md="8">
          <v-list class="mt-8 mr-8 py-8" two-line color="yellow lighten-5">
            <v-list-item>
              <v-list-item-title cols="12" md="5">이름 </v-list-item-title>
              <v-col cols="12" md="7">{{ userInfo.userName }}</v-col>
            </v-list-item>
            <v-list-item>
              <v-list-item-title cols="12" md="5">닉네임 </v-list-item-title>
              <v-col cols="12" md="7">{{ userInfo.userNickname }}</v-col>
            </v-list-item>
            <v-list-item>
              <v-list-item-title cols="12" md="5">연락처 </v-list-item-title>
              <v-col cols="12" md="7">{{ userInfo.userPhone }}</v-col>
            </v-list-item>
          </v-list>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="12" md="4">
          <v-btn class="mb-3" rounded color="yellow lighten-4" @click="modify"> 수정 </v-btn>
        </v-col>
        <v-col cols="12" md="8">
          <v-btn class="mb-3" rounded color="yellow lighten-4" @click="modify"> 수정 </v-btn>
        </v-col>
      </v-row>
    </v-card>
  </div>
</template>

<script>
import { mapState } from "vuex";

const memberStore = "memberStore";

export default {
  name: "UserMyPage",
  components: {},
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
};
</script>

<style></style>
