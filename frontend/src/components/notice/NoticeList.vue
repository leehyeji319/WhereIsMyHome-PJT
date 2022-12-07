<template>
  <div>
    <h1>공지사항</h1>
    <div>
      <v-row>
        <v-col cols="12" md="3"></v-col>
        <v-col cols="12" md="3"></v-col>
        <v-col cols="12" md="3"></v-col>
        <v-col cols="12" md="3">
          <template v-if="userInfo.userRole == 'ADMIN'">
            <div class="text-center pa-3">
              <v-btn rounded color="yellow" @click="write"> 공지 등록하기 </v-btn>
            </div>
          </template>
          <!-- <template v-else>
            <div></div>
          </template> -->
        </v-col>
      </v-row>
    </div>
    <v-card outlined>
      <v-list two-line>
        <v-list-item-group>
          <template v-for="(notice, index) in notices">
            <v-list-item :key="notice.noticeId" @click="pickNotice(notice.noticeId)">
              <!-- <v-list-item :key="notice.title" @click="pickNotice"> -->
              <template>
                <v-row>
                  <!-- <router-link :to="{ name: 'noticeview', params: { noticeId: notice.noticeId } }"> </router-link> -->
                  <v-col cols="12" md="2"> {{ index + 1 }} </v-col>
                  <v-col cols="12" md="8"> {{ notice.title }} </v-col>
                  <v-col cols="12" md="2"> 관리자 </v-col>
                </v-row>
              </template>
            </v-list-item>

            <v-divider v-if="index < notices.length - 1" :key="index"></v-divider>
          </template>
        </v-list-item-group>
      </v-list>
    </v-card>
  </div>
</template>
<script>
import Constant from "@/common/Constant.js";
import { mapGetters, mapActions, mapState } from "vuex";

export default {
  name: "NoticeList",
  data() {
    return {};
  },
  computed: {
    ...mapGetters("noticeStore", ["notices"]),
    ...mapState("memberStore", ["userInfo"]),
  },
  methods: {
    ...mapActions("noticeStore", [Constant.GET_NOTICES]),
    pickNotice(payload) {
      this.$router.push({
        name: "noticeview",
        params: { noticeId: payload },
      });
    },
    write() {
      this.$router.push({ name: "noticewrite" });
    },
  },
  created() {
    this[Constant.GET_NOTICES]();
  },
};
</script>

<style></style>
