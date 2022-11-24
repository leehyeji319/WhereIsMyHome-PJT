<template>
  <!-- <v-app> -->
  <v-row>
    <v-col cols="12" md="12">
      <div class="pa-3"></div>
      <v-card class="pa-3 height='500'">
        <br />
        <div align="center" :style="{ fontSize: 'xx-large' }">{{ notice.title }}</div>
        <br />
        <v-row>
          <v-col cols="12" sm="3">
            <div class="justify-right" style="width: 300px; margin-left: 100px; padding-top: 10px">
              작성일 : {{ notice.createdAt }}
            </div>
          </v-col>
          <v-col cols="12" sm="3">
            <div class="justify-right" style="width: 300px; margin-left: 100px; padding-top: 10px">
              조회수 : {{ notice.hit }}
            </div>
          </v-col>
          <v-col cols="12" sm="1">
            <div class="justify-right" style="width: 300px; margin-left: 100px; padding-top: 10px">작성자 : 관리자</div>
          </v-col>
        </v-row>

        <!-- 사진 정보 -->

        <v-divider></v-divider>
        <v-card height="400">
          <v-card-text style="text-align: start">
            {{ notice.content }}
          </v-card-text>
        </v-card>

        <v-divider></v-divider>

        <div class="pa-3">
          <v-btn width="100px" style="margin-left: 30px; margin-bottom: 20px" @click="moveBack">뒤로가기</v-btn>
          <v-btn width="100px" style="margin-left: 30px; margin-bottom: 20px" @click="updateContent">수정</v-btn>
          <v-btn width="100px" style="margin-left: 30px; margin-bottom: 20px" @click="deleteContent">삭제</v-btn>
        </div>
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
  name: "NoticeView",
  data() {
    return {};
  },
  computed: {
    ...mapGetters("noticeStore", ["notice"]),
  },
  methods: {
    ...mapActions("noticeStore", [Constant.GET_NOTICE, Constant.DELETE_NOTICE]),
    moveBack() {
      this.$router.push(`/notice`);
    },
    updateContent() {
      // this.$emit("update-board", boardId);
      // this.$router.push(`/board/update/${boardId}`);
      this.$router.replace({
        name: "noticemodify",
        params: { noticeId: this.notice.noticeId },
      });
    },
    deleteContent() {
      // this.$emit("delete-board", boardId);
      // this.$router.push(`/board/delete/${boardId}`);
      // console.log(this.board.boardId);
      this[Constant.DELETE_NOTICE](this.notice);
      this.moveList();
    },
    moveList() {
      this.$router.push({ name: "noticelist" });
    },
  },
  created() {
    this[Constant.GET_NOTICE](this.$route.params.noticeId);
    console.log("notice created...");
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
