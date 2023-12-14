import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import {HttpClient} from "@angular/common/http";
import { competitions } from '../models/competition';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CompetitionService {

  constructor(private http: HttpClient){
    
  }

  GetAllCompetitions (){
    return this.http.get('http://localhost:8989/competition/all');
    
  }


  AddCompetition(data: any): Observable<any>{
    return this.http.post('http://localhost:8989/competition',data); 
  }
  
  
}
