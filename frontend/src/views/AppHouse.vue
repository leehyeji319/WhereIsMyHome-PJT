<template>
  <div>
    <b-row>
      <b-col>
        <house-tab></house-tab>
      </b-col>
      <b-col cols="8">
        <kakao-map></kakao-map>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import HouseTab from "@/components/house/HouseTab"
import KakaoMap from "@/components/house/HouseMap"

export default {
  name: "AppHouse",
  data() {
    return {
      houseList: [],
      housePagination: {},
      categoryList: [],
      category: 0
    };
  },
  components: {
    HouseTab,
    KakaoMap
  }
}
</script>

<style>
</style>