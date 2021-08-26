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
  networthResponseData = [{name: 0, value: 0}]


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

}
