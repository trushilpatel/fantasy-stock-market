import { required, email } from 'vuelidate/lib/validators'
import axios from 'axios'

export default {
  name: 'Footer',
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
      const data = {
        email_id: this.subscriber_email
      }

      axios.post(process.env.VUE_APP_BACK_END + '/newsletter_subscriber', data,
        {
          headers: {
            'Access-Control-Allow-Origin': process.env.VUE_APP_BACK_END
          }
        }
      )
        .then(response => {
          console.log('Successfully subscribed : ' + this.subscriber_email)
          console.log('Response From Back End')
          console.log(response)
        })
    }
  }
}
