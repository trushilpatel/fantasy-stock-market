import { required, email } from 'vuelidate/lib/validators'
import axios from 'axios'
import { mapState } from 'vuex'
const passwordRegex = /^[A-Za-z0-9]\w{7,14}$/

export default {
  name: 'SignUp',
  data () {
    return {
      email: '',
      oldPassword: '',
      newPassword: ''
    }
  },
  mounted () {
    this.email = this.$store.state.User.email
  },
  computed: {
    ...mapState(['User'])
  },
  validations: {
    email: {
      required,
      email
    },
    oldPassword: {
      required,
      strongPassword () {
        const passwordMatcher = new RegExp(passwordRegex)
        return passwordMatcher.test(this.password)
      }
    },
    newPassword: {
      required,
      strongPassword () {
        const passwordMatcher = new RegExp(passwordRegex)
        return passwordMatcher.test(this.password)
      },
      samePassword () {
        return !(this.oldPassword === this.newPassword)
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
          email: this.email,
          password: this.oldPassword,
          newPassword: this.newPassword
        }
        console.log(data)
        axios.patch(process.env.VUE_APP_BACK_END + '/user', data)
          .then(response => {
            // Check For Message Sent By server
            if (response.data.message) {
              this.$emit('message', {
                title: response.data.statusCode,
                body: response.data.message
              })
            } else {
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
    }
  }
}
