import Constant from "@/common/Constant";
import restApi from "@/util/restApi.js";
import router from "@/router/index.js";

const boardStore = {
  namespaced: true,
  state: {
    boards: [],
    board: {},

    //detail, update, delete
    boardId: 0,


  },
  getters: {
    boards(state) {
      return state.boards
    },
  },
  mutations: {
    [Constant.SET_BOARDS](state, payload) {
      state.boards = payload; //state의 boards에 payload 저장
    },
    [Constant.SET_BOARD](state, payload) {
      state.board = payload;
    },
  },
  actions: {
    [Constant.GET_BOARDS](context) {
      return restApi.get(`/api/boards`).then(({ data }) => {
        context.commit(Constant.SET_BOARDS, data);
      });
    },
    [Constant.GET_BOARD](context, payload) {
      return restApi.get(`/api/board/${payload}`)
        .then(({ data }) => context.commit(Constant.SET_BOARD, data),
        router.push("/board/detail"));  
    },
    
  },
};

export default boardStore;
