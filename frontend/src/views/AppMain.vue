<template>
  <div>
    <v-img id="main" src="@/assets/main.jpg" fluid></v-img>
    <div class="pa-2"></div>
    <dir pa-2>
      <v-btn color="yellow" elevation="2" rounded x-large justify-center mg-1 @click="moveGo">이용해보기</v-btn>
    </dir>
  </div>
</template>

<script>
export default {
  name: "AppMain",
  props: {
    msg: String,
  },
  methods: {
    moveGo() {
      this.$router.push({ name: "house" });
    },
  },
};
</script>

<style scoped>
#main {
  width: 200vh;
}
.underline-steelblue {
  display: inline-block;
  background: linear-gradient(180deg, rgba(255, 255, 255, 0) 70%, rgba(72, 190, 233, 0.3) 30%);
}
</style>
