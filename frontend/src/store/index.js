import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate';

import boardStore from "@/store/module/boardStore";

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    boardStore,
  },

  plugins: [
    createPersistedState({
      storage: sessionStorage,
    })
  ]
})

