import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-net-worth',
  templateUrl: './net-worth.component.html',
  styleUrls: ['./net-worth.component.css'],
  styles: [`.form-control { width: 300px; }`, `.btn-group {width: 150px}`]
})
export class NetWorthComponent implements OnInit {

  saleData = [
    { name: "Mobiles", value: 105000 },
    { name: "Laptop", value: 55000 },
    { name: "AC", value: 15000 },
    { name: "Headset", value: 150000 },
    { name: "Fridge", value: 20000 }
  ];
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

  constructor() { }

  ngOnInit(): void {
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
