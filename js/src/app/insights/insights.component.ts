import { Component, OnInit } from '@angular/core';
import { TypicodeService } from 'src/services/typicode.service';
import { SwapiService } from 'src/services/swapi.service';

@Component({
  selector: 'app-insights',
  templateUrl: './insights.component.html',
  styleUrls: ['./insights.component.css']
})
export class InsightsComponent implements OnInit {
  // We need data models for this component
  // reportData:any = {} // this is where our returned data from the API will go
  reportData = {name:'', id:1}
  reportSwapiData = {name:'', id:1}
  // category:string = 'user'
  // id:number = 1
  paramObj = {category:'user', id:1}
  paramObjSwapi = {category:'user', id:1}

  // We need access to the service
  constructor(private typicodeService:TypicodeService, private SwapiService:SwapiService) { }

  ngOnInit(): void {
  }

  makeServiceCall() {
    // We call the service method by subscribing to the service call
    // Remember the api call with be async so subscribing responds when it returns
    this.typicodeService.getApiData(this.paramObj)
      .subscribe( (data:any)=>{ // any should be a class instead specifying what properties data would have
        this.reportData = data
    } )
  }

  makeSwapiServiceCall() {
    // We call the service method by subscribing to the service call
    // Remember the api call with be async so subscribing responds when it returns
    this.SwapiService.getApiData(this.paramObjSwapi)
      .subscribe( (data:any)=>{ // any should be a class instead specifying what properties data would have
        this.reportSwapiData = data
    } )
  }

}
