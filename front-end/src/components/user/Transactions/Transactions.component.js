import axios from 'axios'
import { mapGetters } from 'vuex'

export default {
  data: function () {
    return {
      transactions: null,
      transactionsFields: ['transactionsType', 'symbol', 'sharePrice', 'sharesQuantity', 'timeStamp']
    }
  },
  computed: {
    ...mapGetters(['email'])
  },
  mounted () {
    this.getTransactions()
    console.log('hello')
  },
  methods: {
    getTransactions () {
      axios.post(process.env.VUE_APP_BACK_END + '/user/get-transactions', { emailId: this.email })
        .then(response => {
          const tempData = response.data

          for (const transaction of tempData) {
            for (const data in transaction) {
              if (data === 'timeStamp') {
                transaction[data] = transaction[data].substring(0, 16).replace('T', ' ')
              }
            }
          }

          console.log(tempData)
          this.transactions = tempData
        })
    }
  }
}
