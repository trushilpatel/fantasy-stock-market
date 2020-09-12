const express = require('express')
const bodyParser = require('body-parser')
const cors = require('cors')

const app = express()
const port = 3000

const StockMarketRouter = require('./src/StockMarket/StockMarket.router')

app.use('/api',cors(), StockMarketRouter )

app.get('/', (req,res)=>{
  console.log(req.data)
  res.json(req)
//  res.send('dklfaslasdf')
})
app.all('*', (req,res)=>{
  res.json({
    error: '404'
  })
})
app.listen(port,()=>{
  console.log('Stock Market Data is listening on : http://localhost:' + port)
})