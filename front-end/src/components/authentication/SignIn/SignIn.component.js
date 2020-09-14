import { required, email } from 'vuelidate/lib/validators'
import axios from 'axios'
import { mapState } from 'vuex'

const passwordRegex = /^[A-Za-z0-9!@#$&*]\w{7,14}$/

export default {
  name: 'SignUp',
  data () {
    return {
      email: '',
      password: '',
      confirmPassword: '',
      message: ''
    }
  },
  computed: {
    ...mapState(['User'])
  },
  mounted: function () {
    if (this.$store.state.User.user.token !== '') {
      this.$router.push('/user/home')
    }
  },
  validations: {
    email: {
      required,
      email
    },
    password: {
      required,
      strongPassword () {
        const passwordMatcher = new RegExp(passwordRegex)
        return passwordMatcher.test(this.password)
      }
    }
  },
  methods: {
    submit () {
      if (this.$v.$invalid) {
        this.message = {
          title: 'Enter Valid Details',
          body: 'Please Make sure email is correct and both the passwords are same'
        }
      } else {
        const data = {
          emailId: this.email,
          password: this.password
        }

        axios.post(process.env.VUE_APP_BACK_END + '/user/sign-in', data)
          .then(response => {
            // Check For Message Sent By server
            if (response.data.message) {
              this.$emit('message', {
                title: response.data.statusCode,
                body: response.data.message
              })
            } else {
              this.getBalance()
              this.$store.commit('signIn', response.data)
              this.$store.commit('saveEmail', this.email)
              // Successfully Logged in
              this.$router.push('/user/home')
            }
          })
          .catch(err => {
            console.log('Error Occurred')
            console.log(err)
          })
      }
    },
    getBalance () {
      axios.post(process.env.VUE_APP_BACK_END + '/user/account-balance', { emailId: this.email }).then(
        response => {
          console.log(response.data)
          this.$store.commit('setBalance', response.data.amount)
        }
      )
    }
  }
}
