import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PortfolioService } from 'src/services/portfolio.service';
@Component({
  selector: 'app-net-worth',
  templateUrl: './net-worth.component.html',
  styleUrls: ['./net-worth.component.css'],
  styles: [`.form-control { width: 300px; }`, `.btn-group {width: 150px}`]
})
export class NetWorthComponent implements OnInit {

  //data for networth
  cashResponseData = {}
  stocksResponseData = {}
  etfResponseData = {}
  bondResponseData = {}
  networthResponseData = {}


  // declare model data for this component
  total:number = 0
  codes = [
    {code:'AMZN', price:42},
    {code:'NFLX', price:12},
    {code:'GOOGL', price:142},
    {code:'FB', price:82},
    {code:'AAPL', price:11},
  ]
  newStockCode:string = ''
  newStockPrice:number = 0


  constructor(private portfolioService:PortfolioService, private modalService: NgbModal) { }


  ngOnInit(): void {
    this.fetchNetworthHistory()
  }

  fetchNetworthHistory(){
    this.portfolioService.getNetworthHistory()
      .subscribe( (data:any)=>{ // any should be a class instead specifying what properties data would have
        this.networthResponseData = data
        console.log(this.networthResponseData)
      } )
  }

  fetchCashHistory(){
    this.portfolioService.getCashHistory()
      .subscribe( (data:any)=>{ // any should be a class instead specifying what properties data would have
        this.cashResponseData = data
        console.log(this.cashResponseData)
      } )
  }
  fetchStockHistory(){
    this.portfolioService.getStockHistory()
      .subscribe( (data:any)=>{ // any should be a class instead specifying what properties data would have
        this.stocksResponseData = data
        console.log(this.stocksResponseData)
      } )
  }
  fetchETFHistory(){
    this.portfolioService.getETFHistory()
      .subscribe( (data:any)=>{ // any should be a class instead specifying what properties data would have
        this.etfResponseData = data
        console.log(this.etfResponseData)
      } )
  }
  fetchBondsHistory(){
    this.portfolioService.getBondHistory()
      .subscribe( (data:any)=>{ // any should be a class instead specifying what properties data would have
        this.bondResponseData = data
        console.log(this.bondResponseData)
      } )
  }

  handleBuy(value:number){
    // here we can handle the CUSTOM event
    this.total += value
  }

  handleSell(value:number){
    // here we can handle the CUSTOM event
    this.total -= value
  }

  handleReset(){
    // here we can handle the CUSTOM event
    this.total = 0
  }

  addNewStock(){
    let newStock = {code:this.newStockCode, price:+this.newStockPrice}
    this.codes.push(newStock)
  }

  handleRemove(value:string){
    this.codes = this.codes.filter(obj => {
      return obj.code != value
    })
  }

}
