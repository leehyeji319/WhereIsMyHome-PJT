<template>
  <div>
    <h1>공지사항</h1>
    <div>
      <v-row>
        <v-col cols="12" md="3"></v-col>
        <v-col cols="12" md="3"></v-col>
        <v-col cols="12" md="3"></v-col>
        <v-col cols="12" md="3">
          <div class="text-center pa-3">
            <v-btn rounded color="primary" dark @click="write"> 공지 등록하기 </v-btn>
          </div>
        </v-col>
      </v-row>
    </div>
    <v-card outlined>
      <v-list two-line>
        <v-list-item-group v-model="selected" active-class="pink--text">
          <template v-for="(notice, index) in notices">
            <v-list-item :key="notice.title">
              <template v-slot:default="{ active }">
                <v-list-item-content>
                  <v-list-item-title v-text="notice.title"></v-list-item-title>

                  <v-list-item-subtitle class="text--primary" v-text="notice.headline"></v-list-item-subtitle>

                  <v-list-item-subtitle v-text="notice.subtitle"></v-list-item-subtitle>
                </v-list-item-content>

                <v-list-item-action>
                  <v-list-item-action-text v-text="notice.action"></v-list-item-action-text>

                  <v-icon v-if="!active" color="grey lighten-1"> mdi-star-outline </v-icon>

                  <v-icon v-else color="yellow darken-3"> mdi-star </v-icon>
                </v-list-item-action>
              </template>
            </v-list-item>

            <v-divider v-if="index < items.length - 1" :key="index"></v-divider>
          </template>
        </v-list-item-group>
      </v-list>
    </v-card>
  </div>
</template>
<script>
export default {
  data() {
    return {
      selected: [2],
      notices: [
        {
          action: "15 min",
          headline: "Brunch this weekend?",
          subtitle: `I'll be in your neighborhood doing errands this weekend. Do you want to hang out?`,
          title: "Ali Connors",
        },
        {
          action: "2 hr",
          headline: "Summer BBQ",
          subtitle: `Wish I could come, but I'm out of town this weekend.`,
          title: "me, Scrott, Jennifer",
        },
        {
          action: "6 hr",
          headline: "Oui oui",
          subtitle: "Do you have Paris recommendations? Have you ever been?",
          title: "Sandra Adams",
        },
        {
          action: "12 hr",
          headline: "Birthday gift",
          subtitle: "Have any ideas about what we should get Heidi for her birthday?",
          title: "Trevor Hansen",
        },
        {
          action: "18hr",
          headline: "Recipe to try",
          subtitle: "We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
          title: "Britta Holt",
        },
      ],
    };
  },
};
</script>

<style></style>
