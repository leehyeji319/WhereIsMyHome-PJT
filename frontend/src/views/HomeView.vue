<template>
  <v-layout row wrap>
    <v-flex xs12 class="text-xs-center" mt-5>
      <h1>Welcome to Awesome App</h1>
    </v-flex>
    <v-flex xs12 sm6 offset-sm3 mt-3>
      <blockquote class="blockquote text-xs-center">
        It's a basic Single Page application <br />
        with Google Firebase authentication
      </blockquote>
    </v-flex>
    <v-flex xs12 sm6 offset-sm3 class="text-xs-center" mt-5>
      <v-btn color="primary" to="{name: 'join'}">Sign Up</v-btn>
      <v-btn to="{name: 'login'}">Sign In</v-btn>
    </v-flex>
  </v-layout>
</template>
<script>
export default {
  name: "HomeView",
};
</script>
