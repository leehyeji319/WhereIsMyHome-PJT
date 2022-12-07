<template>
  <div>
    <v-app-bar app>
      <v-toolbar-title>
        <router-link to="/" tag="span" style="cursor: pointer">
          <v-img :src="require('@/assets/helpme.png')" class="my-3" contain width="200" />
        </router-link>
      </v-toolbar-title>

      <v-spacer></v-spacer>

      <v-toolbar-items class="hidden-xs-only">
        <v-btn color="#000000" plain raised v-for="item in menuItems" :key="item.title" :to="item.path">
          {{ item.title }}
        </v-btn>
      </v-toolbar-items>
      <!--로그인 이후-->
      <template v-if="userInfo">
        <v-toolbar-items class="hidden-xs-only">
          <!-- <v-avatar v-text="userInfo.userId.charAt(0).toUpperCase()"></v-avatar> -->
          <v-btn color="#000000" plain raised :to="{ name: 'mypage' }"
            >{{ userInfo.userNickname }}({{ userInfo.userId }})님 환영합니다.</v-btn
          >
          <!-- {{ userInfo.userNickname }}({{ userInfo.userId }})님 환영합니다. -->
        </v-toolbar-items>
        <!-- <v-toolbar-items class="hidden-xs-only"> -->
        <!-- <v-btn color="#000000" plain raised :to="{ name: 'mypage' }">내정보</v-btn> -->
        <!-- <router-link :to="{ name: 'mypage' }" class="link align-self-center">내정보보기</router-link> -->
        <!-- </v-toolbar-items> -->
        <v-toolbar-items class="hidden-xs-only">
          <v-btn color="#000000" plain raised @click.prevent="onClickLogout">로그아웃</v-btn>
        </v-toolbar-items>
      </template>
      <!--로그인 전-->
      <template v-else>
        <v-toolbar-items class="hidden-xs-only">
          <v-btn color="#000000" plain raised :to="{ name: 'join' }">회원가입</v-btn>
          <!-- <router-link :to="{ name: 'join' }" class="link align-self-center">회원가입</router-link> -->
        </v-toolbar-items>
        <v-toolbar-items class="hidden-xs-only">
          <v-btn color="#000000" plain raised :to="{ name: 'login' }">로그인</v-btn>
          <!-- <router-link :to="{ name: 'login' }" class="link align-self-center">로그인</router-link> -->
        </v-toolbar-items>
      </template>
    </v-app-bar>
  </div>
</template>

<script>
// import Constant from "@/common/Constant";
import { mapState, mapGetters, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "TheHeaderNavBar",
  data() {
    return {
      appTitle: "구해줘 홈즈",
      sidebar: false,
      menuItems: [
        { title: "실거래가 조회", path: "/house" },
        { title: "매물 게시판", path: "/board" },
        { title: "공지사항", path: "/notice" },
      ],
    };
  },

  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  methods: {
    ...mapActions(memberStore, ["userLogout"]),
    // ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    onClickLogout() {
      // this.SET_IS_LOGIN(false);
      // this.SET_USER_INFO(null);
      // sessionStorage.removeItem("access-token");
      // if (this.$route.path != "/") this.$router.push({ name: "main" });
      console.log(this.userInfo.userId);
      //vuex actions에서 userLogout 실행(Backend에 저장 된 리프레시 토큰 없애기
      //+ satate에 isLogin, userInfo 정보 변경)
      // this.$store.dispatch("userLogout", this.userInfo.userId);
      this.userLogout(this.userInfo.userId);
      sessionStorage.removeItem("access-token"); //저장된 토큰 없애기
      sessionStorage.removeItem("refresh-token"); //저장된 토큰 없애기
      if (this.$route.path != "/") this.$router.push({ name: "main" });
    },
  },
};
</script>
<style></style>
