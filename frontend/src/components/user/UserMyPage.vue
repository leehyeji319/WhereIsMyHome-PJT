<template>
  <v-card max-width="375" class="mx-auto">
    <v-img
      src="https://t3.ftcdn.net/jpg/03/46/83/96/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg"
      height="300px"
      sizes="80"
      dark
    >
      <v-row class="fill-height">
        <!-- <v-card-title>
          <v-btn dark icon>
            <v-icon>mdi-chevron-left</v-icon>
          </v-btn>

          <v-spacer></v-spacer>

          <v-btn dark icon class="mr-4">
            <v-icon>mdi-pencil</v-icon>
          </v-btn>

          <v-btn dark icon>
            <v-icon>mdi-dots-vertical</v-icon>
          </v-btn>
        </v-card-title> -->

        <v-spacer></v-spacer>
      </v-row>
    </v-img>

    <v-list two-line>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title>이름: {{ userInfo.userName }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title>닉네임: {{ userInfo.userNickname }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title>연락처: {{ userInfo.userPhone }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-card>
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
