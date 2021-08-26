import { Component, OnInit } from '@angular/core';
import { TypicodeService } from 'src/services/typicode.service';
import { PortfolioService } from 'src/services/portfolio.service';

@Component({
  selector: 'app-investment2',
  templateUrl: './investment2.component.html',
  styleUrls: ['./investment2.component.css']
})
export class Investment2Component implements OnInit {

  myNetWorth = [1,2,3] as number[]
  totalCashFlow = 987654321

  paramCashFlowDate = ''

  totalIncome = [1,2,3] as number[]
  totalExpenses= [1,2,3] as number[]

  constructor(private typicodeService:TypicodeService, private PortfolioService:PortfolioService) { }

  ngOnInit(): void {
    console.log(this.paramCashFlowDate)
    var date = new Date()
    date.setDate(date.getDate()-90)
    this.paramCashFlowDate=date.toISOString().split('T')[0]
    //this.paramCashFlowDate = this.datePipe.transform(date, 'yyyy-MM-dd').toLocaleString();
    this.makePortfolioServiceCall()
}


public chartDatasets: Array<any> = [
    { data: [300, 50, 100, 40, 120], label: 'My First dataset' }
];
public chartOptions: any = {
    responsive: true
  };
public chartHovered(e: any): void { }


makePortfolioServiceCall() {
    // We call the service method by subscribing to the service call
    // Remember the api call with be async so subscribing responds when it returns
  this.PortfolioService.getNetWorth()
    .subscribe( (data:any)=>{ // any should be a class instead specifying what properties data would have
      this.myNetWorth = data
  } )

    this.PortfolioService.getTotalCashFlow(this.paramCashFlowDate)
    .subscribe( (data:any)=>{ // any should be a class instead specifying what properties data would have
        this.totalCashFlow = data
    } )

    this.PortfolioService.getTotalIncome(this.paramCashFlowDate)
    .subscribe( (data:any)=>{ // any should be a class instead specifying what properties data would have
        this.totalIncome = data
    } )

    this.PortfolioService.getTotalExpense(this.paramCashFlowDate)
    .subscribe( (data:any)=>{ // any should be a class instead specifying what properties data would have
        this.totalExpenses = data
    } )
  }

}