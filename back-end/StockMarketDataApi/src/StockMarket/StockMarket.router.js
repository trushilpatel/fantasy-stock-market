const express = require('express')
const router = express.Router()
const smServices = require('./StockMarket.services')

router.get('/sma/:symbol/:time/:interval', smServices.technicalSma)

router.get('/intraday/:symbol/', smServices.intradaySymbol)

router.get('/sectors', smServices.sectorsPerformance)

router.all('*', (req,res)=> {
  res.json({
    error: "404"
  })
})
module.exports = router