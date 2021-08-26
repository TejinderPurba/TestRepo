import { Injectable } from '@angular/core';
// I wanted to use http in this service
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class PortfolioService {

  constructor(private http:HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  // Summary Data
  getStockSummaryData(){
    return this.http.get('http://localhost:8080/portfolio/lateststocks')
  }
  getETFSummaryData(){
    return this.http.get('http://localhost:8080/portfolio/latestetfs')
  }
  getBondSummaryData(){
    return this.http.get('http://localhost:8080/portfolio/latestbonds')
  }
  getCashSummaryData(){ 
    return this.http.get('http://localhost:8080/portfolio/latestcash')
  }

  // Lookup data
  getStockDataBySymbol(params={symbol:''}){ 
    return this.http.get(`http://localhost:8080/portfolio/stocks/symbol/${params.symbol}`)
  }
  getETFDataBySymbol(params={symbol:''}){ 
    return this.http.get(`http://localhost:8080/portfolio/etfs/symbol/${params.symbol}`)
  }
  getBondDataByName(params={name:''}){ 
    return this.http.get(`http://localhost:8080/portfolio/bonds/name/${params.name}`)
  }
  getCashDataByAccount(params={accountNumber:0}){ 
    return this.http.get(`http://localhost:8080/portfolio/cash/account/${params.accountNumber}`)
  }

  // Transaction data
  postBuyStock(stock:any){ 
    return this.http.post('http://localhost:8080/portfolio/stocks/buy', JSON.stringify(stock), this.httpOptions)
  }
  postSellStock(stock:any){ 
    return this.http.post('http://localhost:8080/portfolio/stocks/sell', stock, this.httpOptions)
  }
  postBuyETF(etf:any){ 
    return this.http.post('http://localhost:8080/portfolio/etfs/buy', etf, this.httpOptions)
  }
  postSellETF(etf:any){ 
    return this.http.post('http://localhost:8080/portfolio/etfs/sell', etf, this.httpOptions)
  }
  postBuyBond(bond:any){ 
    return this.http.post('http://localhost:8080/portfolio/bonds/buy', bond, this.httpOptions)
  }
  postSellBond(bond:any){ 
    return this.http.post('http://localhost:8080/portfolio/bonds/sell', bond, this.httpOptions)
  }
  postDepositCash(cash:any){ 
    return this.http.post('http://localhost:8080/portfolio/cash/deposit', cash, this.httpOptions)
  }
  postWithdrawCash(cash:any){ 
    return this.http.post('http://localhost:8080/portfolio/cash/withdraw', cash, this.httpOptions)
  }

  getMarketMoversData(){
    return this.http.get('http://localhost:8080/portfolio/marketmovers/10')
  }

  getMarketMoversByPeriod(params= 0) {
    return this.http.get(`http://localhost:8080/portfolio/marketmovers/${params}`)
  }

  getNetWorth(){ // All httpClients are observables
    return this.http.get('http://localhost:8080/portfolio/networth')
  }

  getTotalCashFlow(date:any){ // All httpClients are observables
    return this.http.get(`http://localhost:8080/portfolio/cashflow/${date}`)
  }

  getTotalIncome(date:any){ // All httpClients are observables
    return this.http.get(`http://localhost:8080/portfolio/cashincomeflow/${date}`) 
  }

  getTotalExpense(date:any){ // All httpClients are observables
    return this.http.get(`http://localhost:8080/portfolio/cashexpenseflow/${date}`) 
  }
}
