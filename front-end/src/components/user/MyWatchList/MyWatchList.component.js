import axios from 'axios'
import { mapGetters } from 'vuex'

export default {
  data () {
    return {
      symbols: [
        'msft',
        'googl',
        'aapl',
        'fb',
        'tsla'
      ],
      showSymbols: false,
      search: '',
      watchList: null,
      stockData: [],

      operation: '', // Buy/sell
      userStock: {}
      // UserStock Data Example
      // {
      // 'msft' :{
      //    maxBuyShares: Number.parseInt(this.balance / data.currentValue),
      //    userShares: 0,
      //    userSharesUpdate: 0,
      //    currentValue: ...
      // }}
    }
  },
  computed: {
    ...mapGetters(['balance', 'email']),
    searchedSymbols () {
      const tempSymbols = this.symbols
      return tempSymbols.filter(symbol => {
        return symbol.startsWith(this.search)
      })
    }
  },
  mounted: function () {
    this.getUserShares()
    this.getStockData()
    console.log('balance')
    console.log(this.balance)
  },
  methods: {
    getUserShares () {
      axios.post(process.env.VUE_APP_BACK_END + '/user/get-user-shares', { emailId: this.email })
        .then(response => {
          const resData = response.data
          resData.forEach(data => {
            this.userStock[data.symbol] = {
              ...this.userStock[data.symbol],
              userShares: data.sharesQuantity
            }
          })
          console.log(this.userStock)
        })
    },
    showSymbol () {
      this.showSymbols = true
    },
    closeSymbol () {
      this.showSymbols = false
    },
    getWatchList () {
      console.log(this.$store.state.User.email)
      axios.post(process.env.VUE_APP_BACK_END + '/user/get-watchlist', { emailId: this.$store.state.User.email })
        .then(response => {
          // Check For Message Sent By server
          if (response.data.message) {
            this.$emit('message', {
              title: response.data.statusCode,
              body: response.data.message
            })
          } else {
            this.watchList = response.data
            this.getStockData()
            // this.$store.commit('watchlist', response)
          }
        })
        .catch(err => {
          console.log('Error Occurred')
          console.log(err)
        })
    },
    getStockData () {
      const symbol = 'msft'

      axios.get(process.env.VUE_APP_STOCK_MARKET_DATA + '/api/intraday/' + symbol).then(response => {
        const data = {}
        data.name = symbol
        data.data = {}
        data.min = 1000000
        data.max = 0
        data.currentValue = 0
        delete response.data['Meta Data']

        console.log(data)

        for (const series in response.data) {
          for (const time in response.data[series]) {
            const tempOpen = Number.parseFloat(response.data[series][time]['1. open'])
            data.data[time.substring(11, 16)] = tempOpen
            if (tempOpen < data.min) {
              data.min = tempOpen
            } else {
              data.max = tempOpen
            }
            data.currentValue = tempOpen
          }
        }
        data.min = data.min - 0.0008 * (data.min)
        data.max = data.max + 0.0008 * (data.max)
        data.userShare = 0
        data.numberOfShareToPurchase = 10

        this.userStock[data.name] = {
          ...this.userStock[data.name],
          maxBuyShares: Number.parseInt(this.balance / data.currentValue),
          userSharesUpdate: 0,
          currentValue: data.currentValue
        }
        console.log(this.userStock)
        this.stockData.push(data)
      })
      // this.symbols.forEach(symbol => {
      //   const url = process.env.VUE_APP_STOCK_MARKET_DATA + 'api/intraday/' + symbol
      //   data.push(axios.get(url))
      // })
      // Promise.all(data).then(result => {
      //   result.forEach(response => {
      //     console.log(response)
      //   })
      // })
    },
    doOperation (opr) {
      this.operation = opr
    },
    buyShares (symbol) {
      if (this.userStock[symbol].userSharesUpdate <= 0) {
        this.$emit('message', {
          title: 'Please Enter valid Number'
        })
      } else if (this.userStock[symbol].userSharesUpdate > this.userStock[symbol].maxBuyShares) {
        this.$emit('message', {
          title: 'Please increase your balance',
          body: 'You have ' + this.balance + '$ and you can purchase maximum ' + this.userStock[symbol].maxBuyShares + ' shares '
        })
        console.log('failed the test')
      } else {
        const data = {
          emailId: this.email,
          userTransactions: [{
            symbol: symbol,
            transactionType: 'buy',
            sharePrice: this.userStock[symbol].currentValue,
            sharesQuantity: this.userStock[symbol].userSharesUpdate
          }]
        }
        this.saveShares(symbol, data)
      }
    },
    sellShares (symbol) {
      if (this.userStock[symbol].userShares <= 0) {
        this.$emit('message', {
          title: 'Please Enter valid Number',
          body: 'You have ' + this.userStock[symbol].userShares + ' shares '
        })
      } else if (this.userStock[symbol].userSharesUpdate > this.userStock[symbol].userShares) {
        this.$emit('message', {
          title: 'Please increase your balance',
          body: 'You have ' + this.userStock[symbol].userShares + ' and you can sell maximum ' + this.userStock[symbol].userShares + ' shares '
        })
        console.log('failed test')
      } else {
        console.log('passed the first test')
        const data = {
          emailId: this.email,
          userTransactions: [{
            symbol,
            transactionType: 'sell',
            sharePrice: this.userStock[symbol].currentValue,
            sharesQuantity: this.userStock[symbol].userSharesUpdate
          }]
        }
        console.log(data)
        this.saveShares(symbol, data)
      }
    },
    saveShares (symbol, data) {
      axios.post(process.env.VUE_APP_BACK_END + '/user/transactions', data)
        .then(response => {
          const resData = response.data
          console.log(resData)
          this.$store.commit('setBalance', resData.userAccount.amount)

          resData.userShares.forEach(userShare => {
            if (userShare.symbol === symbol) {
              this.userStock[symbol].userShares = userShare.sharesQuantity
              this.userStock[symbol].maxBuyShares = Number.parseInt(this.balance / this.userStock[symbol].currentValue)
            }
          })
          this.getUserShares()
        })
    }
  }
}
