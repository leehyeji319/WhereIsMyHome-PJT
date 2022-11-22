<template>
  <v-app> </v-app>
</template>

<script>
import Constant from "@/common/Constant.js";
import { mapGetters, mapActions } from "vuex";
export default {
  name: "BoardDetail",
  data() {
    return {};
  },
  computed: {
    ...mapGetters("boardStore", ["board"]),
  },
  methods: {
    ...mapActions("boardStore", [Constant.GET_BOARD]),
  },
};
</script>
