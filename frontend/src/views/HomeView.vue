<template>
  <v-app>
    <!-- <board-list></board-list>
    <board-detail></board-detail> -->
    <board-register></board-register>
  </v-app>
</template>

<script>
// import BoardList from "@/components/board/BoardList.vue";
// import BoardDetail from "@/components/board/BoardDetail.vue";
import BoardRegister from "@/components/board/BoardRegister";

export default {
  name: "HomeView",

  components: {
    // BoardList,
    // BoardDetail,
    BoardRegister,
  },
};
</script>
