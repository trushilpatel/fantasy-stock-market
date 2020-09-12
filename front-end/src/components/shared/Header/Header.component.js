import axios from 'axios'
import { mapGetters } from 'vuex'

export default {
  name: 'Header',
  data () {
    return {
    }
  },
  computed: {
    ...mapGetters(['user', 'email']),
    isAuthenticated: function () {
      return this.user.token.trim() !== ''
    }
  },
  methods: {
    signOut () {
      axios.post(process.env.VUE_APP_BACK_END + '/user/sign-out', this.user)
      this.$store.commit('signOut')
      console.log(this.user)
      this.$router.push('/')
    }

  }
}
