<template>
  <div>
    <!-- <v-toolbar-title>
      <router-link to="/" tag="span" style="cursor: pointer">
        <v-img :src="require('@/assets/helpme.png')" class="my-3" contain height="200" width="200" />
      </router-link>
    </v-toolbar-title>
    <v-spacer></v-spacer> -->
    <!-- <router-link :to="{ name: `house` }">
      실거래가 조회 
    </router-link> -->
    <!-- <v-toolbar-items class="hidden-xs-only">
      <v-btn color="#000000" plain raised v-for="item in menuItems" :key="item.title" :to="item.path">
        {{ item.title }}
      </v-btn>
    </v-toolbar-items> -->

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
    </v-app-bar>
  </div>
</template>

<script>
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
        { title: "Sign Up", path: "/signup" },
        { title: "Sign In", path: "/signin" },
      ],
    };
  },
};
</script>
<style></style>
