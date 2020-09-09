import { required, email } from 'vuelidate/lib/validators'
import axios from 'axios'

const passwordRegex = /^[A-Za-z0-9]\w{7,14}$/

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
  validations: {
    email: {
      required,
      email
    },
    password: {
      required,
      strongPassword () {
        const passwordMatcher = new RegExp(passwordRegex)
        console.log(passwordMatcher.test(this.password))
        return passwordMatcher.test(this.password)
      }
    },
    confirmPassword: {
      required,
      matchPassword () {
        return this.password === this.confirmPassword
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

        axios.post(process.env.VUE_APP_BACK_END + '/user/sign-up', data)
          .then(response => {
            // Check For Message Sent By server
            if (response.data.message) {
              this.$emit('message', {
                title: response.data.statusCode,
                body: response.data.message
              })
            } else {
              this.$store.commit('signIn', response.data)
              // Successfully Signed Up
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
