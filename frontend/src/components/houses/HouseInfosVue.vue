<template>
  <div>
    <v-card
      class="pa-2 overflow-auto mostly-customized-scrollbar"
      outlined
      tile
      flat
      style="background-color: transparent; max-height: 60vh"
    >
      <v-list class="overflow-auto" style="background-color: transparent">
        <v-list-item-group v-model="selectedItem">
          <v-list-item v-for="houseInfo in houseInfos" :key="houseInfo.houseInfoId" link selectable>
            <v-card style="background-color: transparent">
              <div class="d-flex flex-no-wrap justify-space-between">
                <div>
                  <v-card-title class="text-h6" v-text="houseInfo.aptName"></v-card-title>

                  <v-card-subtitle>{{
                    `${houseInfo.sidoName} ${houseInfo.gugunName} ${houseInfo.dongName} ${houseInfo.jibun}`
                  }}</v-card-subtitle>

                  <!-- <v-card-actions>
                    <v-btn
                      v-if="item.artist === 'Ellie Goulding'"
                      class="ml-2 mt-3"
                      fab
                      icon
                      height="40px"
                      right
                      width="40px"
                    >
                      <v-icon>mdi-play</v-icon>
                    </v-btn>
                    <v-btn v-else class="ml-2 mt-5" outlined rounded small> START RADIO </v-btn>
                  </v-card-actions> -->
                </div>

                <v-avatar class="ma-3" size="100" tile>
                  <v-img :src="item.src"></v-img>
                </v-avatar>
              </div>
            </v-card>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-card>
  </div>
</template>

<script>
import Constant from "@/common/Constant";
import { mapGetters, mapActions } from "vuex";
export default {
  name: "HouseInfosVue",
  data() {
    return {
      clicked: false,
      selectedItem: undefined,
      item: {
        color: "#952175",
        src: "https://tgzzmmgvheix1905536.cdn.ntruss.com/2020/11/c177c87a3c62424dabaea71598b4f24f",
        title: "Halcyon Days",
        artist: "Ellie Goulding",
      },
    };
  },
  mounted() {},
  methods: {},
  watch: {
    selectedItem() {
      this.$emit("onShowDetail", this.selectedItem);
    },
  },
  computed: {
    ...mapGetters("houseStore", ["houseInfos"]),
  },
};
</script>

<style lang="css" scoped>
.visible-scrollbar,
.invisible-scrollbar,
.mostly-customized-scrollbar {
  display: block;
  overflow: auto;
}
.invisible-scrollbar::-webkit-scrollbar {
  display: none;
}
/* "대부분 커스터마이징된" 스크롤바
 * (width/height가 지정되지 않으면 보이지 않음 */
.mostly-customized-scrollbar::-webkit-scrollbar {
  width: 5px;
  height: 8px;
  background-color: rgba(198, 198, 198, 0.582); /* 또는 트랙에 추가한다 */
}
/* 썸(thumb) 추가 */
.mostly-customized-scrollbar::-webkit-scrollbar-thumb {
  background: rgb(127, 127, 127);
}
</style>
