import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import {HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs';
import { CompetitionResponse } from '../models/competition-response';


@Injectable({
  providedIn: 'root'
})
export class CompetitionService {
  private readonly BASE_URL = environment.base_url;

  constructor(private http: HttpClient){
    
  }

  GetAllCompetitions (): Observable<any>{
    return this.http.get(this.BASE_URL+'/competition/all');
    
  }


  AddCompetition(data: any): Observable<any>{
    return this.http.post(this.BASE_URL+'/competition',data); 
  }
  
  
}
