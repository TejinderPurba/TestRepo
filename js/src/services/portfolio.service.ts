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
    return this.http.get('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/lateststocks')
  }
  getETFSummaryData(){
    return this.http.get('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/latestetfs')
  }
  getBondSummaryData(){
    return this.http.get('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/latestbonds')
  }
  getCashSummaryData(){
    return this.http.get('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/latestcash')
  }

  // Lookup data
  getStockDataBySymbol(params={symbol:''}){
    return this.http.get(`http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/stocks/symbol/${params.symbol}`)
  }
  getETFDataBySymbol(params={symbol:''}){
    return this.http.get(`http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/etfs/symbol/${params.symbol}`)
  }
  getBondDataByName(params={name:''}){
    return this.http.get(`http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/bonds/name/${params.name}`)
  }
  getCashDataByAccount(params={accountNumber:0}){
    return this.http.get(`http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/cash/account/${params.accountNumber}`)
  }

  // Transaction data
  postBuyStock(stock:any){
    return this.http.post('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/stocks/buy', JSON.stringify(stock), this.httpOptions)
  }
  postSellStock(stock:any){
    return this.http.post('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/stocks/sell', stock, this.httpOptions)
  }
  postBuyETF(etf:any){
    return this.http.post('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/etfs/buy', etf, this.httpOptions)
  }
  postSellETF(etf:any){
    return this.http.post('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/etfs/sell', etf, this.httpOptions)
  }
  postBuyBond(bond:any){
    return this.http.post('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/bonds/buy', bond, this.httpOptions)
  }
  postSellBond(bond:any){
    return this.http.post('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/bonds/sell', bond, this.httpOptions)
  }
  postDepositCash(cash:any){
    return this.http.post('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/cash/deposit', cash, this.httpOptions)
  }
  postWithdrawCash(cash:any){
    return this.http.post('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/cash/withdraw', cash, this.httpOptions)
  }

  getMarketMoversData(){
    return this.http.get('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/marketmovers/10')
  }

  getMarketMoversByPeriod(params= 0) {
    return this.http.get(`http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/marketmovers/${params}`)
  }

  getNetWorth(){ // All httpClients are observables
    return this.http.get('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/networth')
  }

  getTotalCashFlow(date:any){ // All httpClients are observables
    return this.http.get(`http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/cashflow/${date}`)
  }

  getTotalIncome(date:any){ // All httpClients are observables
    return this.http.get(`http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/cashincomeflow/${date}`)
  }

  getTotalExpense(date:any){ // All httpClients are observables
    return this.http.get(`http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/cashexpenseflow/${date}`)
  }

  //Get data of history
  getCashHistory(){
    return this.http.get('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/cashhistory')
  }
  getStockHistory(){
    return this.http.get('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/stockhistory')
  }
  getETFHistory(){
    return this.http.get('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/etfhistory')
  }
  getBondHistory(){
    return this.http.get('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/bondhistory')
  }
  getNetworthHistory(){
    return this.http.get('http://portfolio-manager-back-portfolio-manager.namdevops25.conygre.com/portfolio/networthhistory')
  }
}
