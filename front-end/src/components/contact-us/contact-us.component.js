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
      if (this.$v.$invalid) {
        // Show message to User
        this.$emit('message', {
          title: 'Please Enter Valid details',
          body: 'Make sure email is correct'
        })
      } else {
        const data = {
          name: this.name,
          emailId: this.email,
          subject: this.subject
        }

        // Reset Vuelidate
        this.$v.$reset()
        this.name = ''
        this.email = ''
        this.subject = ''

        axios.post(process.env.VUE_APP_BACK_END + '/contact-us', data)
          .then(response => {
            // Show message to User
            this.$emit('message', {
              title: 'Successfully submitted the details',
              body: 'We will contact you shortly...'
            })
          })
      }
    }
  }

}
