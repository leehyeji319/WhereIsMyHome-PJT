<template>
  <div>
    <h1>매물 게시판</h1>
    <div>
      <v-row>
        <v-col cols="12" md="3"></v-col>
        <v-col cols="12" md="3"></v-col>
        <v-col cols="12" md="3"></v-col>
        <v-col cols="12" md="3">
          <div class="text-center pa-3">
            <v-btn rounded color="yellow" @click="write"> 매물 등록하기 </v-btn>
          </div>
        </v-col>
      </v-row>
    </div>
    <v-card outlined>
      <v-row wrap justify-space-around>
        <v-flex v-for="board in boards" :key="board.board_id" @click="pickBoard(board.boardId)">
          <v-card :loading="loading" class="mx-auto my-12" max-width="374">
            <template slot="progress">
              <v-progress-linear color="deep-purple" height="10" indeterminate></v-progress-linear>
            </template>
            <!-- carousel -->
            <v-hover>
              <template v-slot:default="{}">
                <v-carousel interval="3000" cycle height="200" hide-delimiter-background show-arrows-on-hover>
                  <v-carousel-item v-for="(apt, i) in apts" :key="i" :src="apt.src" contain>
                    <!-- <v-sheet :color="colors[i]" height="100%">
                          <v-row class="fill-height" align="center" justify="center">
                            <div class="text-h2">{{ slide }} Slide</div>
                          </v-row>
                        </v-sheet> -->
                  </v-carousel-item>
                  <v-fab-transition>
                    <v-btn
                      :class="fav ? 'red--text' : 'black--text'"
                      icon
                      @click="clickLikeBtn"
                      fab
                      small
                      right
                      class="v-btn--example"
                      absolute
                    >
                      <v-icon>mdi-heart</v-icon>
                    </v-btn>
                  </v-fab-transition>
                </v-carousel>
              </template>
            </v-hover>
            <v-card-title>
              <router-link :to="{ name: 'boardview', params: { boardId: board.boardId } }">
                {{ board.title }}
              </router-link>
            </v-card-title>
            <v-card-text>
              <v-row align="center" class="mx-0"> </v-row>
              <div class="my-4 text-subtitle-1">
                <v-avatar size="30"> <img src="https://cdn.vuetifyjs.com/images/john.jpg" alt="John" /> </v-avatar
                >{{ board.userInfo.userNickname }}
              </div>
              <div class="my-4 text-subtitle-1">{{ board.salePrice }}</div>
              <div class="my-4 text-subtitle-1">{{ board.buildingAddress }}</div>

              <div>
                {{ board.content }}
              </div>
            </v-card-text>
          </v-card>
        </v-flex>
      </v-row>
    </v-card>
  </div>
</template>

<script>
import Constant from "@/common/Constant.js";
import { mapGetters, mapActions } from "vuex";
export default {
  name: "BoardList",
  data() {
    return {
      apts: [
        {
          src: "https://image.hogangnono.com/image/nowatermark/original/apt/dqe26/20220801095251_RsztURfctuorqjYFzz?s=720x180&t=outside&q=100",
        },
        {
          src: "https://wimg.mk.co.kr/meet/neds/2022/02/image_readtop_2022_139618_16448870024945626.jpg",
        },
        {
          src: "https://cfnimage.commutil.kr/phpwas/restmb_allidxmake.php?idx=999&simg=2020100711214006086237391cf86123562109.jpg&nmt=18",
        },
        {
          src: "http://www.goodmorningcc.com/news/photo/201503/26225_36650_4832.jpg",
        },
      ],
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
    pickBoard(payload) {
      // this.$emit("select-board", boardId);
      // this.$router.push(`/board/detail/${boardId}`);
      this.$router.push({
        name: "boardview",
        params: { boardId: payload },
      });
    },
    write() {
      this.$router.push({ name: "boardwrite" });
    },
  },
  async created() {
    await this[Constant.GET_BOARDS]();
    this.getBoards();
    // await console.log(this[Constant.GET_BOARDS]());
    this.loading = false;
    // console.log("boards created...");
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

<style>
#lateral .v-btn--example {
  /* bottom: 0; */
  position: absolute;
  top: 0;
  margin-top: 32px;
  margin-right: 16px;
}
</style>
