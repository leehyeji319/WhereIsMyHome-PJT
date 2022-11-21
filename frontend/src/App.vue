<template>
  <v-app>
    <home-view>
    </home-view>
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
    HomeView
  }
};
</script>
