import { Injectable } from '@angular/core';
// I wanted to use http in this service
import { HttpClient, HttpHeaders } from '@angular/common/http'

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
    return this.http.post('http://localhost:8080/portfolio/stocks/buy', stock, this.httpOptions)
  }
  postSellStock(stock:any){ 
    return this.http.post('http://localhost:8080/portfolio/stocks/sell', stock, this.httpOptions)
  }
}
