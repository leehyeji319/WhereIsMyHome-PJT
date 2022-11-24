import Constant from "@/common/Constant";
import restApi from "@/util/restApi";

const noticeStore = {
  namespaced: true,
  state: {
    notices: [],
    notice: {},
  },

  getters: {
    notices(state) {
      return state.notices
    },
    notice(state) {
      return state.notice
    }
  },

  mutations: {
    [Constant.SET_NOTICES](state, payload) {
      state.notices = payload;
    },
    [Constant.SET_NOTICE](state, payload) {
      state.notice = payload;
    },

  },

  actions: {
    [Constant.GET_NOTICES](context) {
      return restApi.get(`/api/notices`).then(({ data }) => {
        context.commit(Constant.SET_NOTICES, data);
      });
    },
    [Constant.GET_NOTICE](context, payload) {
      return restApi.get(`/api/notices/${payload}`).then(({ data }) => {
        context.commit(Constant.SET_NOTICE, data);
      })
    },
    [Constant.REGISTER_NOTICE](context, payload) {
      return restApi.post(`/api/notices`, payload)
        .then(() => console.log(`store action ${Constant.REGISTER_NOTICE}`));
    },
    [Constant.UPDATE_NOTICE](context, notice) {
      return restApi.put(`/api/notices/${notice.noticeId}`, notice)
        .then(() => console.log(`store action ${Constant.UPDATE_NOTICE}`));
    },
    [Constant.DELETE_NOTICE](context, notice) {
      return restApi.delete(`/api/notices/${notice.noticeId}`, notice)
        .then(() => console.log(`store action ${Constant.DELETE_NOTICE}`));
    }
  }
}

export default noticeStore;