// Replace key with your API key
const alpha = require('alphavantage')({ key: 'qweqweqwe2' });

async function intradaySymbol(req,res){
  const response = await alpha.data.intraday(req.params.symbol)
  res.json(response)
}

async function technicalSma(symbol, interval, timePeriod){
  const response =  await alpha.technical.sma(
    req.params.symbol,
    req.params.interval,
    req.params.timePeriod,'close'
    )
  res.json(response)
}
async function sectorsPerformance(req, res){

  const response = await alpha.performance.sector()
  res.json(response)
}

module.exports = {
  sectorsPerformance,
  intradaySymbol,
  technicalSma
}