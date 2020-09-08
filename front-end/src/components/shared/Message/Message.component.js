export default {
  name: 'message',
  props: ['message'],
  data () {
    return {
      showModal: true
    }
  },
  created () {
    console.log('Message Component')
    console.log(this.message.body)
  }
}
