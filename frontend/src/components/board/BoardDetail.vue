<template>
  <v-app>
    <v-main>
      <v-container>
        <v-row>
          <v-col cols="12" md="12">
            <v-card>
              <br />
              <div align="center" :style="{ fontSize: 'xx-large' }">{{ title }}</div>
              <br />
              <v-row>
                <v-col cols="12" sm="3"> </v-col>
                <v-col cols="12" sm="3">
                  <div class="justify-right" style="width: 300px; margin-left: 100px; padding-top: 10px">
                    작성일 : {{ createdAt }}
                  </div>
                </v-col>
                <v-col cols="12" sm="3">
                  <div class="justify-right" style="width: 300px; margin-left: 100px; padding-top: 10px">
                    조회수 : {{ hit }}
                  </div>
                </v-col>
                <v-col cols="12" sm="1"> </v-col>
              </v-row>

              <!-- 사진 정보 -->
              <v-hover>
                <template v-slot:default="{}">
                  <v-carousel v-model="model" height="500">
                    <v-carousel-item v-for="(color, i) in colors" :key="color">
                      <v-sheet :color="color" height="100%" tile>
                        <v-row class="fill-height" align="center" justify="center">
                          <div class="text-h2">Slide {{ i + 1 }}</div>
                        </v-row>
                      </v-sheet>
                    </v-carousel-item>

                    <!-- <v-overlay align-items="" justify-content="right" opacity="0" absolute color="#036358">
                      <div class="pa-2"></div>
                      <v-btn :class="fav ? 'red--text' : 'black--text'" icon @click="fav = !fav">
                        <v-icon class="pa-1 mr-2 align-top justify-end" size="30">mdi-heart</v-icon>
                      </v-btn>
                    </v-overlay> -->
                  </v-carousel>
                </template>
              </v-hover>
              <!-- 글쓴이 정보 -->
              <v-card class="mx-auto">
                <v-list-item>
                  <v-list-item-content>
                    <v-list-item-title>
                      <div>
                        <v-row>
                          <v-col cols="12" md="2" class="justify-right"> 글쓴이 </v-col>
                          <v-col cols="12" md="10" class="justify-center"> {{ userInfo.userNickname }} </v-col>
                        </v-row>
                      </div>
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-list-item>
                  <v-list-item-content>
                    <v-list-item-title>
                      <div>
                        <v-row>
                          <v-col cols="12" md="2" class="justify-right"> 주소 </v-col>
                          <v-col cols="12" md="10" class="justify-center">
                            {{ userInfo.companyInfo.address }}
                          </v-col>
                        </v-row>
                      </div>
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
                <v-list-item>
                  <v-list-item-content>
                    <v-list-item-title>
                      <div>
                        <v-row>
                          <v-col cols="12" md="2" class="justify-right"> 연락처 </v-col>
                          <v-col cols="12" md="10" class="justify-center"> {{ userInfo.userPhone }} </v-col>
                        </v-row>
                      </div>
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-card>

              <v-container class="grey lighten-5">
                <!-- 건물 정보 시작 -->
                <v-row no-gutters>
                  <v-col cols="12" sm="2">
                    <v-card class="pa-2" color="#F5F5F5" outlined tile> 건물명 </v-card>
                  </v-col>
                  <v-col cols="12" sm="10">
                    <v-card class="pa-2" outlined tile> {{ buildingName }} </v-card>
                  </v-col>
                </v-row>
                <v-row no-gutters>
                  <v-col cols="12" sm="2">
                    <v-card class="pa-2" color="#F5F5F5" outlined tile> 주소 </v-card>
                  </v-col>
                  <v-col cols="12" sm="10">
                    <v-card class="pa-2" outlined tile> {{ buildingAddress }} </v-card>
                  </v-col>
                </v-row>
                <v-row no-gutters>
                  <v-row no-gutters>
                    <v-col cols="12" sm="2">
                      <v-card class="pa-2" color="#F5F5F5" outlined="true" tile> 매매 종류 </v-card>
                    </v-col>
                    <v-col cols="12" sm="4">
                      <v-card class="pa-2" outlined tile> {{ saleType }} </v-card>
                    </v-col>
                    <v-col cols="12" sm="2">
                      <v-card class="pa-2" color="#F5F5F5" outlined tile> 가격 </v-card>
                    </v-col>
                    <v-col cols="12" sm="4">
                      <v-card class="pa-2" outlined tile> {{ salePrice }} 만원</v-card>
                    </v-col>
                  </v-row>
                </v-row>
                <v-row no-gutters>
                  <v-col cols="12" sm="2">
                    <v-card class="pa-2" color="#F5F5F5" outlined tile> 건물 종류 </v-card>
                  </v-col>
                  <v-col cols="12" sm="4">
                    <v-card class="pa-2" outlined tile> {{ buildingType }} </v-card>
                  </v-col>
                  <template v-if="buildingFloorType == 1">
                    <v-col cols="12" sm="2">
                      <v-card class="pa-2" color="#F5F5F5" outlined tile> 층수 </v-card>
                    </v-col>
                    <v-col cols="12" sm="4">
                      <v-card class="pa-2" outlined tile> 지상 {{ buildingFloor }}층 </v-card>
                    </v-col>
                  </template>
                  <template v-else>
                    <v-col cols="12" sm="2">
                      <v-card class="pa-2" color="#F5F5F5" outlined tile> 층수 </v-card>
                    </v-col>
                    <v-col cols="12" sm="4">
                      <v-card class="pa-2" outlined tile> 지하 {{ buildingFloor }}층 </v-card>
                    </v-col>
                  </template>
                </v-row>
                <v-row no-gutters>
                  <v-col cols="12" sm="2">
                    <v-card class="pa-2" outlined tile color="#F5F5F5"> 면적 </v-card>
                  </v-col>
                  <v-col cols="12" sm="4">
                    <v-card class="pa-2" outlined tile> {{ buildingSpace }} ㎡ </v-card>
                  </v-col>
                  <v-col cols="12" sm="2">
                    <v-card class="pa-2" outlined tile color="#F5F5F5"> 방개수 </v-card>
                  </v-col>
                  <v-col cols="12" sm="4">
                    <v-card class="pa-2" outlined tile> {{ buildingRoomNum }} 개</v-card>
                  </v-col>
                </v-row>
              </v-container>

              <v-textarea
                filled
                value="박퀴벌레나오고요,, 벽지에 곰팡이에 매일 가위눌리고 햇빛하나 안들어오지만 좋아요~ "
                disabled
              >
              </v-textarea>

              <v-btn width="100px" style="margin-left: 470px; margin-bottom: 20px" @click="moveBack">뒤로가기</v-btn>
              <v-btn width="100px" style="margin-left: 30px; margin-bottom: 20px" @click="updateContent">수정</v-btn>
              <v-btn width="100px" style="margin-left: 30px; margin-bottom: 20px" @click="deleteContent">삭제</v-btn>
            </v-card>
          </v-col>
          <v-col cols="12" md="1" />
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import Constant from "@/common/Constant.js";
import { mapGetters, mapActions } from "vuex";
export default {
  name: "BoardDetail",
  data() {
    return {
      model: 0,
      colors: ["primary", "secondary", "yellow darken-2", "red", "orange"],
      fav: false,
    };
  },
  computed: {
    ...mapGetters("boardStore", ["board"]),
  },
  methods: {
    ...mapActions("boardStore", [Constant.GET_BOARD]),
    moveBack() {
      this.$router.push(`/boards`);
    },
    updateContent(boardId) {
      this.$emit("update-board", boardId);
      this.$router.push(`/board/update/${boardId}`);
    },
    deleteContent(boardId) {
      this.$emit("delete-board", boardId);
      this.$router.push(`/board/delete/${boardId}`);
    },
  },
  created() {
    // console.log(this.$route.params)
    // this.getBoard(this.$route.params);
    this[Constant.GET_BOARD](1);
    // console.log(this.getBoard(1));
    console.log("board created...");
  },
};
</script>
