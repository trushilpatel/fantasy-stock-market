import { required, email } from 'vuelidate/lib/validators'
import axios from 'axios'
import Message from '../Message/Message.component.vue'

export default {
  name: 'Footer',
  components: { Message },
  data () {
    return {
      subscriber_email: '',
      message: ''
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
      const data = {
        emailId: this.subscriber_email
      }
      console.log(this.$v.subscriber_email)
      if (this.$v.subscriber_email.$invalid) {
        this.message = {
          title: 'Enter Valid Email id',
          body: 'Please check entered email id'
        }
      } else {
        axios.post(process.env.VUE_APP_BACK_END + '/newsletter_subscriber', data,
          {
            headers: {
              'Access-Control-Allow-Origin': process.env.VUE_APP_BACK_END
            }
          }
        )
          .then(response => {
            this.message = {
              title: 'Thank You For Subscribing to our Newsletters',
              body: this.subscriber_email + ' is successfully subscribed'
            }
            console.log(this.message)
          })
      }
    }
  }
}
