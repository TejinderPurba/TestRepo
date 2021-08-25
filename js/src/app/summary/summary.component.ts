import { NgForOf } from '@angular/common';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
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

  etfParamObj = {dateTime:'', symbol:'', name:'', transactionType:0, quantityAffected:0, totalQuantity:0, marketValue:0.0, totalValue:0.0}
  etfResponseData = [{dateTime:'', symbol:'', name:'', transactionType:0, quantityAffected:0, totalQuantity:0, marketValue:0.0, totalValue:0.0}]
  etfTotal = 0.0

  bondParamObj = {dateTime:'', issuer:'', name:'', bondType:'', transactionType:0, faceValue:0.0, maturity:'', couponRate:0.0, totalValue:0.0}
  bondResponseData = [{dateTime:'', issuer:'', name:'', bondType:'', transactionType:0, faceValue:0.0, maturity:'', couponRate:0.0, totalValue:0.0}]
  bondTotal = 0.0

  cashParamObj = {dateTime:'', financialInstitution:'', accountType:0, transactionType:0, balance:0.0, transactionAmount:0.0, accountNumber:0}
  cashResponseData = [{dateTime:'', financialInstitution:'', accountType:0, transactionType:0, balance:0.0, transactionAmount:0.0, accountNumber:0}]
  cashTotal = 0.0

  currentModalTitle = ''
  stockETFModalResponseData = [{dateTime:'', symbol:'', name:'', transactionType:0, quantityAffected:0, totalQuantity:0, marketValue:0.0, totalValue:0.0}]
  bondModalResponseData = [{dateTime:'', issuer:'', name:'', bondType:'', transactionType:0, faceValue:0.0, maturity:'', couponRate:0.0, totalValue:0.0}]
  cashModalResponseData = [{dateTime:'', financialInstitution:'', accountType:0, transactionType:0, balance:0.0, transactionAmount:0.0, accountNumber:0}]

  isStockETFLegendCollapsed = true
  isBondLegendCollapsed = true
  isCashLegendCollapsed = true
  isCashDepositTransactionCollapsed = true
  isCashWithdrawTransactionCollapsed = true

  constructor(private portfolioService:PortfolioService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.makeStockSummaryCall()
    this.makeETFSummaryCall()
    this.makeBondSummaryCall()
    this.makeCashSummaryCall()
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
        console.log(this.stockResponseData)
    } )
  }

  makeETFSummaryCall() {
    this.portfolioService.getETFSummaryData()
      .subscribe( (data:any)=>{
        this.etfResponseData = data
        this.etfTotal = 0.0
        let size = this.etfResponseData.length
        for (let i = 0; i < size; i++) {
          this.etfTotal += this.etfResponseData[i].totalValue
        } 
        console.log(this.etfResponseData)
    } )
  }

  makeBondSummaryCall() {
    this.portfolioService.getBondSummaryData()
      .subscribe( (data:any)=>{
        this.bondResponseData = data
        this.bondTotal = 0.0
        let size = this.bondResponseData.length
        for (let i = 0; i < size; i++) {
          this.bondTotal += this.bondResponseData[i].totalValue
        } 
        console.log(this.bondResponseData)
    } )
  }

  makeCashSummaryCall() {
    this.portfolioService.getCashSummaryData()
      .subscribe( (data:any)=>{
        this.cashResponseData = data
        this.cashTotal = 0.0
        let size = this.cashResponseData.length
        for (let i = 0; i < size; i++) {
          this.cashTotal += this.cashResponseData[i].balance
        } 
        console.log(this.cashResponseData)
    } )
  }

  makeStockSymbolCall(symbol:string) {
    this.stockParamObj.symbol=symbol
    this.portfolioService.getStockDataBySymbol(this.stockParamObj)
      .subscribe( (data:any)=>{
        this.stockETFModalResponseData = data
    } )
  }

  makeETFSymbolCall(symbol:string) {
    this.etfParamObj.symbol=symbol
    this.portfolioService.getETFDataBySymbol(this.etfParamObj)
      .subscribe( (data:any)=>{
        this.stockETFModalResponseData = data
    } )
  }


  makeBondNameCall(name:string) {
    this.bondParamObj.name=name
    this.portfolioService.getBondDataByName(this.bondParamObj)
      .subscribe( (data:any)=>{
        this.bondModalResponseData = data
    } )
  }


  makeCashAccountCall(account:number) {
    this.cashParamObj.accountNumber = account
    this.portfolioService.getCashDataByAccount(this.cashParamObj)
      .subscribe( (data:any)=>{
        this.cashModalResponseData = data
    } )
  }


  openDetailsModal(content:any, lookup:any, type:number) {
    switch(type) {
      case 0: {
        this.currentModalTitle = `Cash Transactions for ${lookup}`
        this.makeCashAccountCall(lookup)
        break
      }
      case 1: {
        this.currentModalTitle = `Stock Transactions for ${lookup}`
        this.makeStockSymbolCall(lookup)
        break
      }
      case 2: {
        this.currentModalTitle = `Exchange Traded Fund Transactions for ${lookup}`
        this.makeETFSymbolCall(lookup)
        break
      }
      case 3: {
        this.currentModalTitle = `Bond Transactions for ${lookup}`
        this.makeBondNameCall(lookup)
        break
      }
    }

    this.modalService.open(content, { scrollable: true, size: 'xl' });
  }

  openTransactionModal(content:any) {
    this.modalService.open(content, { scrollable: true, size: 'xl', backdrop: 'static' });
  }
  saveTransactionModal() {
    
  }

}
