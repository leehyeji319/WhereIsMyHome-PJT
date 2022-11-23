import Constant from '@/common/Constant.js';
import restApi from "@/util/restApi.js";

const boardStore = {
  namespaced: true,
  state: {
    boards: [],
    board: {},
    likeBoardId: '',
    loginedUser: '',
  },
  getters: {
    boards(state) {
      return state.boards
    },
    board(state){
      return state.board;
    }
  },
  mutations: { //dao 느낌 
    [Constant.SET_BOARDS](state, payload) {
      state.boards = payload;
    },
    [Constant.SET_BOARD](state, payload) {
      state.board = payload;
      // console.log(state.board);
    },
  },
  actions: { //service 느낌
    [Constant.GET_BOARDS](context) {
      return restApi.get(`/api/boards`).then(({data}) => {
        context.commit(Constant.SET_BOARDS, data);
      });
    },

    [Constant.GET_BOARD](context, payload) {
      return restApi.get(`/api/boards/${payload}`).then(({ data }) => {
        context.commit(Constant.SET_BOARD, data);
        // console.log(data);
      })
    },

    [Constant.REGISTER_BOARD](context, payload) {
      return restApi.post(`/api/boards`, payload)
      .then(() => console.log(`store action ${Constant.REGISTER_BOARD}`));
    },
    [Constant.UPDATE_BOARD](context, board) {
      return restApi.post(`/api/boards/${board.boardId}`, board)
      .then(() => console.log(`store action ${Constant.UPDATE_BOARD}`));
    },
    [Constant.DELETE_BOARD](context, board) {
      return restApi.delete(`/api/boards/${board.boardId}`, board)
      .then(() => console.log(`store action ${Constant.DELETE_BOARD}`));
    }
  }
}

export default boardStore;
