<template>
  <!-- <v-app> -->
  <v-row>
    <v-col cols="12" md="12">
      <v-card>
        <br />
        <div align="center" :style="{ fontSize: 'xx-large' }">{{ board.title }}</div>
        <br />
        <v-row>
          <v-col cols="12" sm="3"> </v-col>
          <v-col cols="12" sm="3">
            <div class="justify-right" style="width: 300px; margin-left: 100px; padding-top: 10px">
              작성일 : {{ board.createdAt }}
            </div>
          </v-col>
          <v-col cols="12" sm="3">
            <div class="justify-right" style="width: 300px; margin-left: 100px; padding-top: 10px">
              조회수 : {{ board.hit }}
            </div>
          </v-col>
          <v-col cols="12" sm="1"> </v-col>
        </v-row>

        <!-- 사진 정보 -->

        <v-card>
          <v-carousel v-model="model" height="500">
            <v-carousel-item v-for="(apt, i) in apts" :key="i" :src="apt.src" contain transition="fade-transition">
              <!-- <v-sheet :apt="apt" height="100%" tile>
                    <v-row class="fill-height" align="center" justify="center">
                      <div class="text-h2">Slide {{ i + 1 }}</div>
                    </v-row>
                  </v-sheet> -->
            </v-carousel-item>
            <!--하트 표시-->
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
        </v-card>

        <!-- 글쓴이 정보 -->
        <v-card class="mx-auto">
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>
                <div>
                  <v-row>
                    <v-col cols="12" md="2" class="justify-right"> 글쓴이 </v-col>
                    <v-col cols="12" md="10" class="justify-right">
                      <v-avatar size="30">
                        <img src="https://cdn.vuetifyjs.com/images/john.jpg" alt="John" />
                      </v-avatar>
                      {{ board.userInfo.userNickname }}
                    </v-col>
                  </v-row>
                </div>
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>

          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>
                <v-row>
                  <v-col cols="12" md="2" class="justify-right"> 주소 </v-col>
                  <v-col cols="12" md="2" class="justify-right">
                    {{ board.userInfo.companyInfo.address }}
                  </v-col>
                </v-row>
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>
                <v-row>
                  <v-col cols="12" md="2" class="justify-right"> 연락처 </v-col>
                  <v-col cols="12" md="10" class="justify-center"> {{ board.userInfo.userPhone }} </v-col>
                </v-row>
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-card>

        <!-- 건물 정보 시작 -->
        <v-row no-gutters>
          <v-col cols="12" sm="2">
            <v-card class="pa-2" color="#F5F5F5" outlined tile> 건물명 </v-card>
          </v-col>
          <v-col cols="12" sm="10">
            <v-card class="pa-2" outlined tile> {{ board.buildingName }} </v-card>
          </v-col>
        </v-row>
        <v-row no-gutters>
          <v-col cols="12" sm="2">
            <v-card class="pa-2" color="#F5F5F5" outlined tile> 주소 </v-card>
          </v-col>
          <v-col cols="12" sm="10">
            <v-card class="pa-2" outlined tile> {{ board.buildingAddress }} </v-card>
          </v-col>
        </v-row>
        <v-row no-gutters>
          <v-row no-gutters>
            <v-col cols="12" sm="2">
              <v-card class="pa-2" color="#F5F5F5" outlined="true" tile> 매매 종류 </v-card>
            </v-col>
            <v-col cols="12" sm="4">
              <v-card class="pa-2" outlined tile> {{ board.saleType }} </v-card>
            </v-col>
            <v-col cols="12" sm="2">
              <v-card class="pa-2" color="#F5F5F5" outlined tile> 가격 </v-card>
            </v-col>
            <v-col cols="12" sm="4">
              <v-card class="pa-2" outlined tile> {{ board.salePrice }} 만원</v-card>
            </v-col>
          </v-row>
        </v-row>
        <v-row no-gutters>
          <v-col cols="12" sm="2">
            <v-card class="pa-2" color="#F5F5F5" outlined tile> 건물 종류 </v-card>
          </v-col>
          <v-col cols="12" sm="4">
            <v-card class="pa-2" outlined tile> {{ board.buildingType }} </v-card>
          </v-col>
          <template v-if="buildingFloorType == 1">
            <v-col cols="12" sm="2">
              <v-card class="pa-2" color="#F5F5F5" outlined tile> 층수 </v-card>
            </v-col>
            <v-col cols="12" sm="4">
              <v-card class="pa-2" outlined tile> 지상 {{ board.buildingFloor }}층 </v-card>
            </v-col>
          </template>
          <template v-else>
            <v-col cols="12" sm="2">
              <v-card class="pa-2" color="#F5F5F5" outlined tile> 층수 </v-card>
            </v-col>
            <v-col cols="12" sm="4">
              <v-card class="pa-2" outlined tile> 지하 {{ board.buildingFloor }}층 </v-card>
            </v-col>
          </template>
        </v-row>
        <v-row no-gutters>
          <v-col cols="12" sm="2">
            <v-card class="pa-2" outlined tile color="#F5F5F5"> 면적 </v-card>
          </v-col>
          <v-col cols="12" sm="4">
            <v-card class="pa-2" outlined tile> {{ board.buildingSpace }} ㎡ </v-card>
          </v-col>
          <v-col cols="12" sm="2">
            <v-card class="pa-2" outlined tile color="#F5F5F5"> 방개수 </v-card>
          </v-col>
          <v-col cols="12" sm="4">
            <v-card class="pa-2" outlined tile> {{ board.buildingRoomNum }} 개</v-card>
          </v-col>
        </v-row>
        <v-divider></v-divider>
        <v-card-text>
          {{ board.content }}
        </v-card-text>
        <v-divider></v-divider>

        <v-btn width="100px" style="margin-left: 30px; margin-bottom: 20px" @click="moveBack">뒤로가기</v-btn>
        <v-btn width="100px" style="margin-left: 30px; margin-bottom: 20px" @click="updateContent">수정</v-btn>
        <v-btn width="100px" style="margin-left: 30px; margin-bottom: 20px" @click="deleteContent">삭제</v-btn>
      </v-card>
    </v-col>
    <v-col cols="12" md="1" />
  </v-row>
  <!-- </v-app> -->
</template>

<script>
import Constant from "@/common/Constant.js";
import { mapGetters, mapActions } from "vuex";
export default {
  name: "BoardView",
  data() {
    return {
      //캐러셀
      model: 0,
      //캐러셀 사진 배열
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
      fav: false,
      //하트버튼
      fab: false,
    };
  },
  computed: {
    ...mapGetters("boardStore", ["board"]),

    activeFab() {
      switch (this.tabs) {
        case "one":
          return { color: "success", icon: "mdi-share-variant" };
        case "two":
          return { color: "red", icon: "mdi-pencil" };
        case "three":
          return { color: "green", icon: "mdi-chevron-up" };
        default:
          return {};
      }
    },
  },
  methods: {
    ...mapActions("boardStore", [Constant.GET_BOARD, Constant.DELETE_BOARD]),
    moveBack() {
      this.$router.push(`/board`);
    },
    updateContent() {
      // this.$emit("update-board", boardId);
      // this.$router.push(`/board/update/${boardId}`);
      this.$router.replace({
        name: "boardmodify",
        params: { boardId: this.board.boardId },
      });
    },
    deleteContent() {
      // this.$emit("delete-board", boardId);
      // this.$router.push(`/board/delete/${boardId}`);
      // console.log(this.board.boardId);
      this[Constant.DELETE_BOARD](this.board);
      this.moveList();
    },
    moveList() {
      this.$router.push({ name: "boardlist" });
    },
    changeLikeBtnColor() {
      fav = !fav;
    },
    clickLikeBtn() {},
  },
  created() {
    // console.log(this.$route.params)
    // this.getBoard(this.$route.params);
    this[Constant.GET_BOARD](this.$route.params.boardId);
    // console.log(this.getBoard(1));
    console.log("board created...");
  },
};
</script>

<style scoped>
#lateral .v-btn--example {
  /* bottom: 0; */
  position: absolute;
  top: 0;
  margin-top: 32px;
  margin-right: 16px;
}
</style>
