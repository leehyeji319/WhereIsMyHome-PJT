<template>
  <v-app>
    <home-view> </home-view>
  </v-app>
</template>

<script>
import HomeView from "@/views/HomeView";
export default {
  name: "App",

  data: () => ({
    //
  }),
  components: {
    HomeView,
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
