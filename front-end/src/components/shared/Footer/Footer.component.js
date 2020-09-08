import { required, email } from 'vuelidate/lib/validators'
import axios from 'axios'
import Message from '../Message/Message.component.vue'

export default {
  name: 'Footer',
  components: { Message },
  data () {
    return {
      subscriber_email: ''
    }
  },
  validations: {
    subscriber_email: {
      required,
      email
    }
  },
  methods: {
    submit: function () {
      if (this.$v.subscriber_email.$invalid) {
        const message = {
          title: 'Enter Valid Email id',
          body: 'Please check entered email id'
        }
        // Show message to User
        this.$emit('message', message)
      } else {
        const data = {
          emailId: this.subscriber_email
        }
        // Reset Vuelidate
        this.$v.$reset()
        this.subscriber_email = ''

        axios.post(process.env.VUE_APP_BACK_END + '/newsletter_subscriber', data,
          {
            headers: {
              'Access-Control-Allow-Origin': process.env.VUE_APP_BACK_END
            }
          }
        ).then(response => {
          const message = {
            title: 'Thank You For Subscribing to our Newsletters',
            body: this.subscriber_email + ' is successfully subscribed'
          }
          // Show message to User
          this.$emit('message', message)
        })
      }
    }
  }
}
