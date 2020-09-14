const express = require('express')
const bodyParser = require('body-parser')
const cors = require('cors')

const app = express()
const PORT = process.env.PORT || 3000;

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
app.listen(PORT,()=>{
  console.log('Stock Market Data is listening on : http://localhost:' + PORT)
})