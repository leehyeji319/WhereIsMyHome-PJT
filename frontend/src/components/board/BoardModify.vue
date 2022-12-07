<template>
  <v-card class="mx-auto" outlined>
    <form>
      <v-text-field
        v-model="board.title"
        :error-messages="titleErrors"
        :counter="10"
        label="Title"
        required
        @input="$v.title.$touch()"
        @blur="$v.title.$touch()"
      >
      </v-text-field>

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
            :error-messages="saleTypeErrors"
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
            :error-messages="buildingTypeErrors"
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
          <v-radio-group v-model="buildingFloorType" row>
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
      <v-textarea v-model="board.content" solo name="input-7-4" label="부가 설명란"></v-textarea>
      <!--파일 입력-->
      <v-file-input
        v-model="files"
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

      <v-btn class="mr-3" @click="update"> update </v-btn>
      <v-btn class="mr-3" @click="cancel"> cancel </v-btn>
      <v-btn @click="clear"> clear </v-btn>
    </form>
  </v-card>
</template>

<script>
import Constant from "@/common/Constant.js";
import { validationMixin } from "vuelidate";
import { required, maxLength } from "vuelidate/lib/validators";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "BoardModify",

  mixins: [validationMixin],

  validations: {
    board: {
      title: { required, maxLength: maxLength(20) },
      buildingName: { required, maxLength: maxLength(20) },
      salePrice: { required, maxLength: maxLength(10) },
      buildingAddress: { required, maxLength: maxLength(30) },
      saleType: { required },
      buildingType: { required },
      buildingSpace: { required, maxLength: maxLength(4) },
      buildingFloor: { required, maxLength: maxLength(3) },
      buldingRoomNum: { required, maxLength: maxLength(3) },
    },
  },

  data: () => ({
    saleTypes: ["매매", "전세", "월세", "단기"],
    buildingTypes: ["주택", "아파트", "빌라", "다세대주택", "원룸", "기타"],
  }),

  computed: {
    ...mapGetters("boardStore", ["board"]),

    saleTypeErrors() {
      const errors = [];
      if (!this.$v.board.saleType.$dirty) return errors;
      !this.$v.board.saleType.required && errors.push("거래 유형을 선택해주세요!");
      return errors;
    },
    titleErrors() {
      const errors = [];
      if (!this.$v.board.title.$dirty) return errors;
      !this.$v.board.title.maxLength && errors.push("글 제목은 20자를 넘을 수 없습니다!");
      !this.$v.board.title.required && errors.push("글 제목을 입력해주세요!");
      return errors;
    },
    buildingNameErrors() {
      const errors = [];
      if (!this.$v.buildingName.$dirty) return errors;
      !this.$v.board.buildingName.maxLength && errors.push("건물명은 20자를 넘을 수 없습니다!");
      !this.$v.board.buildingName.required && errors.push("건물 이름을 입력해주세요!");
      return errors;
    },

    salePriceErrors() {
      const errors = [];
      if (!this.$v.board.salePrice.$dirty) return errors;
      !this.$v.board.salePrice.maxLength && errors.push("가격은 10자를 넘을 수 없습니다!");
      !this.$v.board.salePrice.required && errors.push("가격을 입력해주세요!");
      return errors;
    },
    buildingTypeErrors() {
      const errors = [];
      if (!this.$v.board.buildingType.$dirty) return errors;
      !this.$v.board.buildingType.required && errors.push("건물 유형을 선택해주세요!");
      return errors;
    },
    buildingAddressErrors() {
      const errors = [];
      if (!this.$v.board.buildingAddress.$dirty) return errors;
      !this.$v.board.buildingAddress.maxLength && errors.push("주소은 30자를 넘을 수 없습니다!");
      !this.$v.board.buildingAddress.required && errors.push("주소를 입력해주세요!");
      return errors;
    },
    buildingSpaceErrors() {
      const errors = [];
      if (!this.$v.board.buildingSpace.$dirty) return errors;
      !this.$v.board.buildingSpace.maxLength && errors.push("면적은 4자리를 넘을 수 없습니다!");
      !this.$v.board.buildingSpace.required && errors.push("면적을 입력해주세요!");
      return errors;
    },
    buildingFloorErrors() {
      const errors = [];
      if (!this.$v.board.buildingFloor.$dirty) return errors;
      !this.$v.board.buildingFloor.maxLength && errors.push("층수는 3자리를 넘을 수 없습니다!");
      !this.$v.board.buildingFloor.required && errors.push("층수를 입력해주세요!");
      return errors;
    },
    buldingRoomNumErrors() {
      const errors = [];
      if (!this.$v.board.buldingRoomNum.$dirty) return errors;
      !this.$v.board.buldingRoomNum.maxLength && errors.push("방 개수는 3자리를 넘을 수 없습니다!");
      !this.$v.board.buldingRoomNum.required && errors.push("방 개수를 입력해주세요!");
      return errors;
    },
  },

  methods: {
    ...mapActions("boardStore", [Constant.UPDATE_BOARD, Constant.GET_BOARD]),

    update() {
      // this.$v.$touch();
      // const boardItem = this.board;
      // if (boardItem) this.updateBoard(boardItem);
      if (this.board) this[Constant.UPDATE_BOARD](this.board);
      this.moveBoardView();
    },
    cancel() {
      this.moveBoardView();
    },
    moveBoardView() {
      this.$router.push({
        name: "boardview",
        params: { boardId: this.board.boardId },
      });
    },

    clear() {
      // this.$v.$reset();
      // this.board.title = "";
      // this.board.buildingName = "";
      // this.board.saleType = null;
      // this.board.buildingType = null;
      // this.board.salePrice = "";
      // this.board.buildingAddress = "";
      // this.board.buildingSpace = "";
      // this.board.buildingFloor = null;
      // this.board.buldingRoomNum = null;
      // this.board.content = null;
    },
  },
  created() {
    // this.getBoard(this.$route.params.boardId);
    this[Constant.GET_BOARD](this.$route.params.boardId);
  },
};
</script>

<style></style>
