<template>
  <v-app>
    <!-- <board-list></board-list> -->
    <board-detail></board-detail>
  </v-app>
</template>

<script>
import BoardList from "@/components/board/BoardList.vue";
import BoardDetail from "@/components/board/BoardDetail.vue";

export default {
  name: "HomeView",

  components: {
    // BoardList,
    BoardDetail,
  },
};
</script>
