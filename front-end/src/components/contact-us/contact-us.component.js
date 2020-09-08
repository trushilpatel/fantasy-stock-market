import { required, email, alpha, minLength } from 'vuelidate/lib/validators'
import axios from 'axios'
import Message from '../shared/Message/Message.component.vue'

export default {
  name: 'ContactUs',
  components: {
    Message
  },
  data () {
    return {
      name: '',
      email: '',
      subject: '',
      message: ''
    }
  },

  validations: {
    name: {
      required,
      alpha
    },
    email: {
      required,
      email
    },
    subject: {
      required,
      minLength: minLength(20)
    }
  },

  methods: {
    submit () {
      const data = {
        name: this.name,
        emailId: this.email,
        subject: this.subject
      }

      if (this.$v.$invalid) {
        this.message = {
          title: 'Please Enter Valid details',
          body: 'Make sure email is correct'
        }
      } else {
        // Reset Vuelidate
        this.$v.$reset()

        axios.post(process.env.VUE_APP_BACK_END + '/contact-us', data)
          .then(response => {
            console.log('Contact-us')
            console.log(response)
          })
      }
    }
  }

}
