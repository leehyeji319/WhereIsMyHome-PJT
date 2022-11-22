import Constant from '@/common/Constant.js';
import restApi from "@/util/restApi.js";

const boardStore = {
  namespaced: true,
  state: {
    boards: [],
    board: {},

    
  },
  getters: {
    boards(state) {
      return state.boards
    }
  },
  mutations: { //dao 느낌 
    [Constant.SET_BOARDS](state, payload) {
      state.boards = payload;
    },
    [Constant.SET_BOARD](state, payload) {
      state.board = payload;
    }
  },
  actions: { //service 느낌
    [Constant.GET_BOARDS](context) {
      return restApi.get(`/api/boards`).then(({data}) => {
        context.commit(Constant.SET_BOARDS, data);
      });
    },
    [Constant.GET_BOARD](context, payload) {
      return restApi.get(`/api/boards/${payload}`)
      .then(({data}) => context.commit(Constant.SET_BOARD));
    }
  }
}

export default boardStore;
