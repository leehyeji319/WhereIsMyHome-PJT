<template>
  <v-container fluid>
    <div style="height: 100%">
      <v-row no-gutters>
        <v-col cols="3">
          <v-card color="basil">
            <v-card-title class="text-center justify-center py-6">
              <h3 class="font-weight-bold text-h3 basil--text">실거래가 조회</h3>
            </v-card-title>

            <v-tabs v-model="tab" background-color="transparent" color="basil" grow>
              <v-tab v-for="selectedTab in tabNames" :key="selectedTab">
                {{ selectedTab }}
              </v-tab>
            </v-tabs>

            <v-tabs-items v-model="tab">
              <v-tab-item v-for="(selectedTab, index) in tabNames" :key="selectedTab">
                <v-card color="basil" flat>
                  <!-- 탭1 -->
                  <v-card-text v-if="index === 0">
                    <house-search-box></house-search-box>
                    <house-infos-vue @onShowDetail="showDetail"></house-infos-vue>
                  </v-card-text>

                  <!-- 탭2 -->
                  <v-card-text v-else-if="index === 1"> </v-card-text>

                  <!-- 탭3 -->
                  <v-card-text v-else-if="index === 2"> </v-card-text>
                </v-card>
              </v-tab-item>
            </v-tabs-items>
          </v-card>
        </v-col>

        <v-col cols="3" v-show="clicked">
          <v-card class="pa-2" outlined tile>
            <v-list>
              <v-list-item v-for="n in 5" :key="n" link>
                <v-list-item-title v-text="'Item ' + n"></v-list-item-title>
              </v-list-item>
            </v-list>
          </v-card>
        </v-col>

        <v-col>
          <kakao-map />
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>

<script>
import KakaoMap from "./KakaoMap.vue";
import HouseSearchBox from "./HouseSearchBox.vue";
import HouseInfosVue from "./HouseInfosVue.vue";
// import { validationMixin } from "vuelidate";
// import { required, maxLength, email } from "vuelidate/lib/validators";
export default {
  name: "HouseView",
  components: {
    KakaoMap,
    HouseSearchBox,
    HouseInfosVue,
  },
  // mixins: [validationMixin],
  // validations: {
  //   select: { required },
  // },
  data() {
    return {
      panel: [],
      clicked: false,
      selectedItem: undefined,
      tab: null,
      tabNames: ["실거래가 조회", "스크랩한 지역", "스크랩한 건물"],
      sidos: ["서울시", "경기도", "인천시", "강원도"],
      guguns: ["강남구", "강서구", "강북구", "강동구"],
      dongs: ["개포동", "일원동", "대치동", "포이동"],
      valid: true,
      selectedSido: null,
      selectedGugun: null,
      selectedDong: null,
      message: null,
      loading: false,
    };
  },
  methods: {
    validate() {
      this.$refs.form[0].validate();
    },
    // submit() {
    //   this.$v.$touch();
    // },
    clickMe() {
      this.loading = true;
      this.message = "Wait for it...";
      setTimeout(() => {
        this.loading = false;
        this.message = `You've clicked me!`;
      }, 2000);
    },
    showDetail(selected) {
      this.selectedItem = selected;
      this.clicked = true;
    },
  },
  watch: {
    selectedItem() {
      if (this.selectedItem == undefined) {
        this.clicked = false;
      } else {
        //인덱스 넘겨주고 axios 호출
      }
    },
  },
};
</script>

<style scoped>
.basil {
  background-color: #fffbe6 !important;
}
.basil--text {
  color: #356859 !important;
}
</style>
