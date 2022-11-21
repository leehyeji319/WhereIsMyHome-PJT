<template>
  <div>
  <b-nav tabs>
    <b-nav-item active>실거래가 조회</b-nav-item>
    <b-nav-item>관심 지역</b-nav-item>
    <b-nav-item>관심 건물</b-nav-item>
  </b-nav>
  <HouseSelectBox
  v-model="preselect_value"
  :items="somethings"
  :input_id="'my_selectbox'"
  @input="value => { preselect_value = value }">
  </HouseSelectBox>
  <house-list></house-list>
  </div>


</template>

<script>
import HouseSelectBox from "@/components/house/HouseSelectBox";
import HouseList from "@/components/house/HouseList"

export default {
  name: "HouseTab",
  data() {
    return {};
  },
  components: {
    HouseSelectBox,
    HouseList,
  }
}
</script>

<style>

</style>