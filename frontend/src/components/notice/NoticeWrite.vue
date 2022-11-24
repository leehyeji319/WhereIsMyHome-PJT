<template>
  <!-- <v-app> -->
  <v-row>
    <v-col cols="12" md="12">
      <div class="pa-3">
        <h2>공지 등록</h2>
      </div>
      <v-card class="pa-3 height='500'">
        <!-- 사진 정보 -->

        <v-divider></v-divider>
        <v-card>
          <v-text-field v-model="notice.title" label="제목" required></v-text-field>
        </v-card>
        <v-textarea height="330" v-model="notice.content" solo name="input-7-4" label="내용 입력"></v-textarea>

        <!--파일 입력-->
        <v-file-input
          v-model="notice.fileInfos"
          placeholder="Upload your documents"
          label="File input"
          multiple
          prepend-icon="mdi-paperclip"
        >
          <template v-slot:selection="{ text }">
            <v-chip small label color="primary">
              {{ text }}
            </v-chip>
          </template>
        </v-file-input>

        <v-divider></v-divider>

        <div class="pa-3">
          <v-btn width="100px" style="margin-left: 30px; margin-bottom: 20px" @click="moveList">뒤로가기</v-btn>
          <v-btn width="100px" style="margin-left: 30px; margin-bottom: 20px" @click="submit">등록</v-btn>
        </div>
      </v-card>
    </v-col>
    <v-col cols="12" md="1" />
  </v-row>
  <!-- </v-app> -->
</template>

<script>
import Constant from "@/common/Constant.js";
import { mapActions } from "vuex";
export default {
  name: "NoticeWrite",
  data() {
    return {
      notice: {
        title: "",
        content: "",
        // userInfo: {
        //   userId: "admin",
        // },
        fileInfos: [],
      },
    };
  },
  computed: {},
  methods: {
    ...mapActions("noticeStore", [Constant.REGISTER_NOTICE]),
    submit() {
      if (this.notice) this[Constant.REGISTER_NOTICE](this.notice);
      this.moveList();
    },

    moveList() {
      this.$router.push({ name: "noticelist" });
    },
  },
};
</script>

<style scoped></style>
