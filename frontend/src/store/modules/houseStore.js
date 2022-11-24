import Constant from '@/common/Constant.js';
import restApi from "@/util/restApi.js";

const houseStore = {
  namespaced: true,
  state: {
    houseInfos: [],
    houseInfo: {},
  },

  getters: {
    houseInfos(state) {
      return state.houseInfos;
    },
    houseInfo(state){
      return state.houseInfo;
    }
  },

  mutations: { //dao 느낌 
    [Constant.SET_HOUSEINFOS](state, payload) {
      state.houseInfos = payload;
    },
    [Constant.SET_HOUSEINFO](state, payload) {
      state.houseInfo = payload;
    },
  },

  actions: { //service 느낌
    [Constant.GET_HOUSEINFOS](context, {sidoCode, gugunCode, dongCode}) {
      return restApi.get(`/api/houses`, {
        params: {
          sidoCode,
          gugunCode,
          dongCode
        }
      }).then(({ data }) => {
        context.commit(Constant.SET_HOUSEINFOS, data);
      });
    },

    [Constant.GET_HOUSEINFO](context, payload) {
      
    },

    [Constant.SET_HOUSEINFO](context, payload) {
      return restApi.get(`/api/houses/${payload}`).then(({ data }) => {
        context.commit(Constant.SET_HOUSEINFO, data);
        // console.log(data);
      })
    },

    [Constant.CLEAR_HOUSEINFOS](context) {
      context.commit(Constant.SET_HOUSEINFOS, null);
    }

    // [Constant.REGISTER_BOARD](context, payload) {
    //   return restApi.post(`/api/boards`, payload)
    //   .then(() => console.log(`store action ${Constant.REGISTER_BOARD}`));
    // },
    // [Constant.UPDATE_BOARD](context, board) {
    //   return restApi.post(`/api/boards/${board.boardId}`, board)
    //   .then(() => console.log(`store action ${Constant.UPDATE_BOARD}`));
    // },
    // [Constant.DELETE_BOARD](context, board) {
    //   return restApi.delete(`/api/boards/${board.boardId}`, board)
    //   .then(() => console.log(`store action ${Constant.DELETE_BOARD}`));
    // }
  }
}

export default houseStore;