import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-asset-view',
  templateUrl: './asset-view.component.html',
  styleUrls: ['./asset-view.component.css']
})
export class AssetViewComponent implements OnInit {
  // declare data-models for this component
  // if we intend to inject values, the data-model MUST be an @Input
  @Input() price:number = 0
  @Input() code:string = ''
  count:number = 0
  alternateCode:string = ''
  alternatePrice:number = 0
  removeStockCode:string = ''
  // declare a custom event for this component
  @Output() buy:EventEmitter<number> = new EventEmitter()
  @Output() sell:EventEmitter<number> = new EventEmitter()
  @Output() reset:EventEmitter<number> = new EventEmitter()
  @Output() remove:EventEmitter<string> = new EventEmitter()
  // @Output() stockCode:EventEmitter<number> = new EventEmitter()
  // @Output() stockPrice:EventEmitter<number> = new EventEmitter()

  constructor() { }

  ngOnInit(): void {
  }
  // here are the ethods of this component
  buyStock(){
    // increment the count
    this.count += 1
    // emit our custom even to the parent component
    this.buy.emit(this.price) // we can send complex data as an object
  }
  sellStock(){
    // increment the count
    if (this.count>0) {
     this.count -= 1
     // emit our custom even to the parent component
    this.sell.emit(this.price) // we can send complex data as an object
    }
  }
  resetStock(){
    // reset the count
    this.count = 0
    // emit our custom even to the parent component
    this.reset.emit() // we can send complex data as an object
  }
  setStockCode(){
    // reset the count
    this.code = this.alternateCode
  }
  setStockPrice(){
    // reset the count
    this.price = this.alternatePrice
  }
  removeStock(){
    // reset the count
    this.count = 0
    // emit our custom even to the parent component
    this.remove.emit(this.code) // we can send complex data as an object
  }

}
