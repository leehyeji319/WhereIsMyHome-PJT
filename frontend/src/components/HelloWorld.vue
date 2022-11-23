<template>
  <v-container fluid>
    <div>
      <v-row no-gutters>
        <v-col cols="3">
          <v-card color="basil">
            <v-card-title class="text-center justify-center py-6">
              <h1 class="font-weight-bold text-h2 basil--text">MY PAGE</h1>
            </v-card-title>

            <v-tabs v-model="tab" background-color="transparent" color="basil" grow>
              <v-tab v-for="selectedTab in tabNames" :key="selectedTab">
                {{ selectedTab }}
              </v-tab>
            </v-tabs>

            <v-tabs-items v-model="tab">
              <v-tab-item v-for="selectedTab in tabNames" :key="selectedTab">
                <v-card color="basil" flat>
                  <v-card-text>
                    <v-form v-model="valid" ref="form" lazy-validation>
                      <v-row justify="align-center" no-gutters>
                        <v-col class="d-flex mr-1">
                          <v-select
                            v-model="selectedSido"
                            :rules="[(v) => !!v || '필수']"
                            required
                            :items="sidos"
                            label="시/도"
                            outlined
                            dense
                          ></v-select>
                        </v-col>

                        <v-col class="d-flex mr-1">
                          <v-select
                            v-model="selectedGugun"
                            :rules="[(v) => !!v || '필수']"
                            required
                            :items="guguns"
                            label="구/군"
                            outlined
                            dense
                          ></v-select>
                        </v-col>

                        <v-col class="d-flex mr-1">
                          <v-select
                            v-model="selectedDong"
                            :rules="[(v) => !!v || '필수']"
                            required
                            :items="dongs"
                            label="동"
                            outlined
                            dense
                          ></v-select>
                        </v-col>

                        <v-col class="d-flex" lg="1">
                          <v-tooltip top>
                            <template v-slot:activator="{ on, attrs }">
                              <v-btn
                                :disabled="!valid"
                                color="success"
                                @click="validate"
                                fab
                                small
                                v-bind="attrs"
                                v-on="on"
                              >
                                <v-icon dark class="mx-2"> mdi-plus </v-icon>
                              </v-btn>
                            </template>
                            <span>관심 지역 추가</span>
                          </v-tooltip>
                        </v-col>
                      </v-row>
                    </v-form>
                  </v-card-text>
                </v-card>
              </v-tab-item>
            </v-tabs-items>
          </v-card>

          <v-card class="pa-2" outlined tile>
            <v-list>
              <v-list-item-group v-model="selectedItem">
                <v-list-item v-for="n in 5" :key="n" link @click="showDetail">
                  <v-list-item-title v-text="'Item ' + n"> </v-list-item-title>
                </v-list-item>
              </v-list-item-group>
            </v-list>
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
          <v-card class="pa-2" outlined tile> 지도다 </v-card>
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>

<script>
  export default {
    name: "HelloWorld",

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
      };
    },

    methods: {
      all() {
        this.panel = [...Array(this.items).keys()].map((k, i) => i);
      },
      // Reset the panel
      none() {
        this.panel = [];
      },
      showDetail() {
        this.clicked = true;
      },
      validate() {
        this.$refs.form.validate();
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
