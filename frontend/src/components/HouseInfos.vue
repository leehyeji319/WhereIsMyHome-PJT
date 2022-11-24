<template>
  <div>
    <v-card class="pa-2" outlined tile flat style="background-color: transparent">
      <v-list style="background-color: transparent">
        <v-list-item-group v-model="selectedItem">
          <v-list-item v-for="n in 5" :key="n" link selectable>
            <v-list-item-title v-text="'Item ' + n"> </v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-card>
  </div>
</template>

<script>
  export default {
    name: "HouseInfos",

    data() {
      return {
        clicked: false,
        selectedItem: undefined,
      };
    },

    mounted() {},

    methods: {},

    watch: {
      selectedItem() {
        this.$emit("onShowDetail", this.selectedItem);
      },
    },
  };
</script>

<style lang="scss" scoped></style>
