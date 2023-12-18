import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Competition } from '../models/Competition';

@Injectable({
  providedIn: 'root'
})


export class CompetitonService {

  
  constructor(private http:HttpClient) {
  }

  private readonly base_url = environment.BASE_URL+"/competition";



  // addCompetition(competition: Competition):Observable<any> {
  //         return this.http.post(`${this.base_url}/addComp`,competition)
  // }

  getAllCompetitions():Observable<any>{
      return this.http.get<Competition[]>(`${this.base_url}/`)
  }
}
