import axios from 'axios'

export default {
  name: 'UserHome',
  data () {
    return {
      sectorsRawData: {
      },
      sectors: ''
    }
  },
  mounted () {
    this.getData()
  },

  methods: {
    getData () {
      axios.get(process.env.VUE_APP_STOCK_MARKET_DATA + '/api/sectors').then(response => {
        this.sectorsRawData = response.data
        delete this.sectorsRawData['Meta Data']
        let tempSector = []
        this.sectors = {}

        for (const data in this.sectorsRawData) {
          tempSector = []
          for (const key in this.sectorsRawData[data]) {
            tempSector.push([key, this.sectorsRawData[data][key]])
          }
          this.sectors[data] = tempSector
        }
      })
    }
  }
}
