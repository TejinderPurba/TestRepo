import { NgForOf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/services/portfolio.service';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {

  stockParamObj = {dateTime:'', symbol:'', name:'', transactionType:0, quantityAffected:0, totalQuantity:0, marketValue:0.0, totalValue:0.0}
  stockResponseData = [{dateTime:'', symbol:'', name:'', transactionType:0, quantityAffected:0, totalQuantity:0, marketValue:0.0, totalValue:0.0}]
  stockTotal = 0.0

  constructor(private portfolioService:PortfolioService) { }

  ngOnInit(): void {
    this.makeStockSummaryCall()
    console.log(this.stockResponseData)
  }

  makeStockSummaryCall() {
    // We call the service method by subscribing to the service call
    // Remember the api call with be async so subscribing responds when it returns
    this.portfolioService.getStockSummaryData()
      .subscribe( (data:any)=>{ // any should be a class instead specifying what properties data would have
        this.stockResponseData = data
        this.stockTotal = 0.0
        let size = this.stockResponseData.length
        for (let i = 0; i < size; i++) {
          this.stockTotal += this.stockResponseData[i].totalValue
        } 
    } )
  }

  makeStockSymbolCall() {
    this.portfolioService.getStockDataBySymbol(this.stockParamObj)
      .subscribe( (data:any)=>{
        this.stockResponseData = data
    } )
  }

}
