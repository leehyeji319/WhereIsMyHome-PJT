<template>
  <div>
    <v-form v-model="valid" ref="form" lazy-validation>
      <v-row no-gutters>
        <v-col lg="10">
          <v-row no-gutters>
            <v-col class="d-flex mr-1">
              <v-select v-model="sidoSelected" required :items="sidos" label="시/도" outlined dense></v-select>
            </v-col>

            <v-col class="d-flex mr-1">
              <v-select v-model="gugunSelected" required :items="guguns" label="구/군" outlined dense></v-select>
            </v-col>

            <v-col class="d-flex mr-1">
              <v-select v-model="dongSelected" required :items="dongs" label="동" outlined dense></v-select>
            </v-col>

            <v-col class="d-flex" lg="2">
              <v-tooltip top>
                <template v-slot:activator="{ on, attrs }">
                  <v-btn :disabled="!valid" color="primary" @click="validate" small v-bind="attrs" v-on="on" fab>
                    <v-icon dark class="mx-2"> mdi-plus </v-icon>
                  </v-btn>
                </template>
                <span>관심 지역 추가</span>
              </v-tooltip>
            </v-col>
          </v-row>

          <v-row no-gutters>
            <v-col class="mr-2">
              <v-text-field
                dense
                v-model="houseName"
                outlined
                clearable
                label="동 선택 후 건물명으로 검색"
                type="text"
                :disabled="houseNameDisabled"
              >
              </v-text-field>
            </v-col>
          </v-row>
        </v-col>

        <v-col lg="2">
          <v-btn min-width="0" color="success" style="width: 100%; height: 80%" @click="houseSearch">
            <v-icon dark class=""> mdi-magnify </v-icon>
          </v-btn>
        </v-col>
      </v-row>
    </v-form>
  </div>
</template>

<script>
  import Constant from "@/common/Constant";
  import { mapGetters, mapActions } from "vuex";

  export default {
    name: "HomeSearchBox",

    data() {
      return {
        valid: true,
        sidoSelected: null,
        gugunSelected: null,
        dongSelected: null,

        sidos: [{ text: "", value: "" }],
        guguns: [{ text: "", value: "" }],
        dongs: [{ text: "", value: "" }],

        houseName: null,
        houseNameDisabled: true,

        // houseInfos: null,
      };
    },

    mounted() {},

    methods: {
      validate() {
        this.$refs.form[0].validate();
      },

      sendRequest(selid, regcode) {
        const url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
        let params = "regcode_pattern=" + regcode + "&is_ignore_zero=true";
        fetch(`${url}?${params}`)
          .then((response) => response.json())
          .then((data) => {
            this.addOption(selid, data);
          });
      },

      addOption(selid, data) {
        this.initOption(selid);
        console.log(data);

        switch (selid) {
          case "sido":
            data.regcodes.forEach((regcode) => {
              this.sidos.push({
                text: regcode.name,
                value: regcode.code,
              });
            });
            break;

          case "gugun":
            this.initOption("dong");

            for (let i = 0; i < data.regcodes.length; i++) {
              if (i != data.regcodes.length - 1) {
                if (
                  data.regcodes[i].name.split(" ")[1] == data.regcodes[i + 1].name.split(" ")[1] &&
                  data.regcodes[i].name.split(" ").length != data.regcodes[i + 1].name.split(" ").length
                ) {
                  data.regcodes.splice(i, 1);
                  i--;
                }
              }
            }

            let name = "";

            data.regcodes.forEach((regcode) => {
              if (regcode.name.split(" ").length == 2) {
                name = regcode.name.split(" ")[1];
              } else {
                name = regcode.name.split(" ")[1] + " " + regcode.name.split(" ")[2];
              }

              this.guguns.push({
                text: name,
                value: regcode.code,
              });
            });
            break;

          case "dong":
            let idx = 2;

            data.regcodes.forEach((regcode) => {
              if (regcode.name.split(" ").length != 3) {
                idx = 3;
              } else {
                idx = 2;
              }

              this.dongs.push({
                text: regcode.name.split(" ")[idx],
                value: regcode.code,
              });
            });
        }
      },

      initOption(selid) {
        this[`${selid}s`] = [];
        this[`${selid}Selected`] = null;
      },

      houseSearch() {
        let params = {
          sidoCode: this.sidoSelected,
          gugunCode: this.gugunSelected,
          dongCode: this.dongSelected,
        };

        // addList(data);
        // makeMarkers(data);
        this[Constant.GET_HOUSEINFOS](params);
      },

      ...mapActions("houseStore", [Constant.GET_HOUSEINFOS, Constant.CLEAR_HOUSEINFOS]),

      // [Constant.GET_HOUSEINFOS]({ sidoSelected, gugunSelected, dongSelected }) {},
    },

    created() {
      this[Constant.CLEAR_HOUSEINFOS]();
      this.sendRequest("sido", "*00000000");
    },

    watch: {
      sidoSelected() {
        if (this.sidoSelected) {
          let regcode = this.sidoSelected.substring(0, 2) + "*00000";
          this.sendRequest("gugun", regcode);
        } else {
          this.initOption("gugun");
          this.initOption("dong");
        }
      },

      gugunSelected() {
        if (this.gugunSelected) {
          let regcode = this.gugunSelected.substring(0, 5) + "*";
          this.sendRequest("dong", regcode);
        } else {
          this.initOption("dong");
        }
      },

      dongSelected() {
        if (this.dongSelected) {
          this.houseNameDisabled = false;
        } else {
          this.houseNameDisabled = true;
        }
      },
    },

    computed: {
      ...mapGetters("houseStore", ["houseInfos"]),
    },
  };
</script>

<style lang="scss" scoped></style>
