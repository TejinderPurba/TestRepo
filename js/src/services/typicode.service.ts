import { Injectable } from '@angular/core';
// I wanted to use http in this service
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class TypicodeService {

  // This is classic how-to for http
  constructor(private http:HttpClient) {  }

  // We need a method of this service - in this case we call an API end-point
  getApiData(params={category:'users', id:1}){ // All httpClients are observables
    return this.http.get(`https://jsonplaceholder.typicode.com/${params.category}/${params.id}`)
  }
}
