<template>
  <v-app>
    <board-list></board-list>
  </v-app>
</template>

<script>
import BoardList from "@/components/board/BoardList.vue";

export default {
  name: "HomeView",

  components: {
    BoardList,
  },
};
</script>
