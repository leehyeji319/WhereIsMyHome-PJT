<template>
  <v-card class="mx-auto" outlined>
    <v-container class="my-5">
      <form>
        <v-text-field
          v-model="board.title"
          :error-messages="titleErrors"
          :counter="10"
          label="Title"
          required
          @input="$v.title.$touch()"
          @blur="$v.title.$touch()"
        ></v-text-field>

        <v-text-field
          v-model="board.buildingName"
          :error-messages="buildingNameErrors"
          :counter="10"
          label="건물명"
          required
          @input="$v.buildingName.$touch()"
          @blur="$v.buildingName.$touch()"
        ></v-text-field>

        <v-text-field
          v-model="board.buildingAddress"
          :error-messages="buildingAddressErrors"
          :counter="10"
          label="건물 주소"
          required
          @input="$v.buildingAddress.$touch()"
          @blur="$v.buildingAddress.$touch()"
        ></v-text-field>

        <v-row>
          <v-col cols="12" md="4">
            <v-select
              v-model="board.saleType"
              :items="saleTypes"
              :error-messages="selectSaleTypeErrors"
              label="거래 유형"
              required
              @change="$v.saleType.$touch()"
              @blur="$v.saleType.$touch()"
            ></v-select>
          </v-col>

          <v-col cols="12" md="4">
            <v-text-field
              v-model.number="board.salePrice"
              :error-messages="salePriceErrors"
              :counter="10"
              label="가격(만원)"
              required
              @input="$v.salePrice.$touch()"
              @blur="$v.salePrice.$touch()"
            ></v-text-field>
          </v-col>

          <v-col cols="12" md="4">
            <v-select
              v-model="board.buildingType"
              :items="buildingTypes"
              :error-messages="selectBuildingTypeErrors"
              label="건물 유형"
              required
              @change="$v.buildingType.$touch()"
              @blur="$v.buildingType.$touch()"
            ></v-select>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="12" md="3">
            <v-text-field
              v-model.number="board.buildingSpace"
              :error-messages="buildingSpaceErrors"
              :counter="10"
              label="면적"
              required
              @input="$v.buildingSpace.$touch()"
              @blur="$v.buildingSpace.$touch()"
            ></v-text-field>
          </v-col>

          <v-col cols="12" md="3" class="align-center">
            <v-radio-group v-model="board.buildingFloorType" row>
              <v-radio label="지상" value="1"></v-radio>
              <v-radio label="지하" value="2"></v-radio>
            </v-radio-group>
          </v-col>

          <v-col cols="12" md="3">
            <v-text-field
              v-model.number="board.buildingFloor"
              :error-messages="buildingFloorErrors"
              :counter="10"
              label="층수"
              required
              @input="$v.buildingFloor.$touch()"
              @blur="$v.buildingFloor.$touch()"
            ></v-text-field>
          </v-col>
          <v-divider></v-divider>
          <v-col cols="12" md="3">
            <v-text-field
              v-model.number="board.buldingRoomNum"
              :error-messages="buldingRoomNumErrors"
              :counter="10"
              label="방 개수"
              required
              @input="$v.buldingRoomNum.$touch()"
              @blur="$v.buldingRoomNum.$touch()"
            ></v-text-field>
          </v-col>
        </v-row>

        <!--텍스트에이리어-->
        <v-textarea solo name="input-7-4" label="부가 설명란"></v-textarea>
        <!--파일 입력-->
        <v-file-input
          v-model="board.fileInfos"
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

        <v-btn class="mr-4" @click="submit"> submit </v-btn>
        <v-btn @click="clear"> clear </v-btn>
      </form>
    </v-container>
  </v-card>
</template>

<script>
import { validationMixin } from "vuelidate";
import { required, maxLength } from "vuelidate/lib/validators";
import { mapActions } from "vuex";
import Constnat from "@?Common/Constant.js";

export default {
  name: "BoardRegister",

  mixins: [validationMixin],

  validations: {
    title: { required, maxLength: maxLength(20) },
    buildingName: { required, maxLength: maxLength(20) },
    salePrice: { required, maxLength: maxLength(10) },
    buildingAddress: { required, maxLength: maxLength(30) },
    saleType: { required },
    buildingType: { required },
    buildingSpace: { required, maxLength: maxLength(4) },
    checkbox: {
      checked(val) {
        return val;
      },
    },
    buildingFloor: { required, maxLength: maxLength(3) },
    buldingRoomNum: { required, maxLength: maxLength(3) },
  },

  data: () => ({
    board: {
      title: "",
      buildingName: "",
      saleType: "",
      salePrice: null, //int형으로 바꿔줘야함
      buildingType: "",
      buildingAddress: "",
      buildingSpace: "",
      buildingFloorType: null,
      buildingFloor: null,
      fileInfos: [],
      userInfo: {
        userId: "khj",
      },
    },
    saleTypes: ["매매", "전세", "월세", "단기"],
    buildingTypes: ["주택", "아파트", "빌라", "다세대주택", "원룸", "기타"],
  }),

  computed: {
    checkboxErrors() {
      const errors = [];
      if (!this.$v.checkbox.$dirty) return errors;
      !this.$v.checkbox.checked && errors.push("You must agree to continue!");
      return errors;
    },
    saleTypeErrors() {
      const errors = [];
      if (!this.$v.saleType.$dirty) return errors;
      !this.$v.saleType.required && errors.push("거래 유형을 선택해주세요!");
      return errors;
    },
    titleErrors() {
      const errors = [];
      if (!this.$v.title.$dirty) return errors;
      !this.$v.title.maxLength && errors.push("글 제목은 20자를 넘을 수 없습니다!");
      !this.$v.title.required && errors.push("글 제목을 입력해주세요!");
      return errors;
    },
    buildingNameErrors() {
      const errors = [];
      if (!this.$v.buildingName.$dirty) return errors;
      !this.$v.buildingName.maxLength && errors.push("건물명은 20자를 넘을 수 없습니다!");
      !this.$v.buildingName.required && errors.push("건물 이름을 입력해주세요!");
      return errors;
    },

    salePriceErrors() {
      const errors = [];
      if (!this.$v.salePrice.$dirty) return errors;
      !this.$v.salePrice.maxLength && errors.push("가격은 10자를 넘을 수 없습니다!");
      !this.$v.salePrice.required && errors.push("가격을 입력해주세요!");
      return errors;
    },
    buildingTypeErrors() {
      const errors = [];
      if (!this.$v.buildingType.$dirty) return errors;
      !this.$v.buildingType.required && errors.push("건물 유형을 선택해주세요!");
      return errors;
    },
    buildingAddressErrors() {
      const errors = [];
      if (!this.$v.buildingAddress.$dirty) return errors;
      !this.$v.buildingAddress.maxLength && errors.push("주소은 30자를 넘을 수 없습니다!");
      !this.$v.buildingAddress.required && errors.push("주소를 입력해주세요!");
      return errors;
    },
    buildingSpaceErrors() {
      const errors = [];
      if (!this.$v.buildingSpace.$dirty) return errors;
      !this.$v.buildingSpace.maxLength && errors.push("면적은 4자리를 넘을 수 없습니다!");
      !this.$v.buildingSpace.required && errors.push("면적을 입력해주세요!");
      return errors;
    },
    buildingFloorErrors() {
      const errors = [];
      if (!this.$v.buildingFloor.$dirty) return errors;
      !this.$v.buildingFloor.maxLength && errors.push("층수는 3자리를 넘을 수 없습니다!");
      !this.$v.buildingFloor.required && errors.push("층수를 입력해주세요!");
      return errors;
    },
    buldingRoomNumErrors() {
      const errors = [];
      if (!this.$v.buldingRoomNum.$dirty) return errors;
      !this.$v.buldingRoomNum.maxLength && errors.push("방 개수는 3자리를 넘을 수 없습니다!");
      !this.$v.buldingRoomNum.required && errors.push("방 개수를 입력해주세요!");
      return errors;
    },
  },

  methods: {
    ...mapActions("boardStore", [Constant.RESIGER_BOARD]),
    submit() {
      this.$v.$touch();
      const boardItem = this.board;
    },
    clear() {
      this.$v.$reset();
      this.title = "";
      this.buildingName = "";
      this.email = "";
      this.saleType = "";
      this.buildingType = "";
      this.salePrice = "";
      this.buildingAddress = "";
      this.buildingSpace = "";
      this.buildingFloor = null;
      this.buldingRoomNum = null;
    },
  },
};
</script>

<style></style>
