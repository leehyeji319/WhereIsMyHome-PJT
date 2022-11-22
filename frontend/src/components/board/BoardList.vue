<template>
  <div id="app">
    <v-app>
      <v-container fluid grid-list-xl>
        <v-layout wrap justify-space-around>
          <v-flex v-for="board in boards" :key="board.board_id" @click="pickBoard(board.board_id)">
            <v-card :loading="loading" class="mx-auto my-12" max-width="374">
              <template slot="progress">
                <v-progress-linear color="deep-purple" height="10" indeterminate></v-progress-linear>
              </template>
              <!-- carousel -->
              <v-hover>
                <template v-slot:default="{}">
                  <v-carousel interval="3000" cycle height="200" hide-delimiter-background show-arrows-on-hover>
                    <v-carousel-item v-for="(slide, i) in slides" :key="i">
                      <v-sheet :color="colors[i]" height="100%">
                        <v-row class="fill-height" align="center" justify="center">
                          <div class="text-h2">{{ slide }} Slide</div>
                        </v-row>
                      </v-sheet>
                    </v-carousel-item>
                    <v-fade-transition>
                      <v-overlay opacity="0" absolute color="#036358">
                        <v-row>
                          <v-col cols="11"> </v-col>
                          <v-col cols="1">
                            <v-btn :class="fav ? 'red--text' : 'black--text'" icon @click="fav = !fav">
                              <v-icon class="align-top justify-end">mdi-heart</v-icon>
                            </v-btn>
                          </v-col>
                        </v-row>
                      </v-overlay>
                    </v-fade-transition>
                  </v-carousel>
                </template>
              </v-hover>
              <v-card-title>{{ board.title }}</v-card-title>
              <v-card-text>
                <v-row align="center" class="mx-0"> </v-row>
                <div class="my-4 text-subtitle-1">{{ board.userInfo.userNickname }}</div>
                <div class="my-4 text-subtitle-1">{{ board.salePrice }}</div>
                <div class="my-4 text-subtitle-1">{{ board.buildingAddress }}</div>

                <div>
                  {{ board.content }}
                </div>
              </v-card-text>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-app>
  </div>
</template>

<script>
import Constant from "@/common/Constant.js";
import { mapGetters, mapActions } from "vuex";
export default {
  name: "BoardList",
  data() {
    return {
      colors: ["indigo", "warning", "pink darken-2", "red lighten-1", "deep-purple accent-4"],
      slides: ["F", "S", "T", "F", "F"],
      loading: true,
      overlay: false,
      fav: true,
      active: true,
    };
  },
  computed: {
    ...mapGetters("boardStore", ["boards"]),
  },
  methods: {
    ...mapActions("boardStore", [Constant.GET_BOARDS]),
    pickBoard(boardId) {
      this.$emit("select-board", boardId);
      this.$router.push(`/board/detail/${boardId}`);
    },
  },
  async created() {
    await this[Constant.GET_BOARDS]();
    this.loading = false;
  },
  // methods: {
  //   getBoards() {
  //     axios.get("http://localhost:10055/api/boards").then(({ data }) => {
  //       // console.log(data);
  //       this.boards = data;
  //     });
  //   },
  //   pickBoard() {
  //     this.$emit("select-board", board_id);
  //   },
  // },
  // created() {
  //   this.getBoards();
  // },
};
</script>

<style></style>
