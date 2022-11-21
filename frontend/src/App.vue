<template>
  <div id="app">
    <the-header-navbar></the-header-navbar>
    <router-view/>
  </div>
</template>

<script>
import TheHeaderNavbar from "@/components/layout/TheHeaderNavbar";

export default {
  name: "App",
  components: {
    TheHeaderNavbar,
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


nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
