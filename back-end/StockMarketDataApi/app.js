const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const port = 3000

const StockMarketRouter = require('./src/StockMarket/StockMarket.router')

app.use('/api', StockMarketRouter )

app.all('*', (req,res)=>{
  res.json({
    error: '404'
  })
})
app.get('/', (req,res)=>{
  res.send('dklfaslasdf')
})
app.listen(port,()=>{
  console.log('Stock Market Data is listening on : http://localhost:' + port)
})