export default {
  state: () => {
    return {
      user: {
        token: ''
      },
      email: '',
      amount: 0
    }
  },
  getters: {
    user (state) {
      return state.user
    },
    email (state) {
      return state.email
    },
    balance (state) {
      return state.amount
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
    },
    setBalance (state, amount) {
      state.amount = amount
    }
  },
  actions: {}
}
