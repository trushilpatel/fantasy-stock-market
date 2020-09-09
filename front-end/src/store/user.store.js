export default {
  state: () => {
    return {
      user: {
        token: ''
      },
      email: ''
    }
  },
  getters: {
    user (state) {
      return state.user
    },
    email (state) {
      return state.email
    }
  },
  mutations: {
    signIn (state, payload) {
      state.user = payload
    },
    signOut (state) {
      state.user = { token: '' }
    },
    saveEmail (state, payload) {
      state.email = payload
    }
  },
  actions: {}
}
