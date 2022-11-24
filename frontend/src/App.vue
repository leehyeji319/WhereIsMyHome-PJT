<template>
  <v-app>
    <the-header-nav-bar></the-header-nav-bar>

    <v-main>
      <v-container class="px-16">
        <router-view></router-view>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import TheHeaderNavBar from "@/components/TheHeaderNavBar";
export default {
  name: "App",

  data: () => ({
    //
  }),
  components: {
    TheHeaderNavBar,
  },
};
</script>

<style>
@import url("https://webfontworld.github.io/NanumSquareNeo/NanumSquareNeo.css");
#app {
  font-family: "NanumSquareNeo";
  font-style: normal;
  font-display: swap;
  text-align: center;
}
</style>
