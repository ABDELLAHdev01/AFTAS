import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { environment } from 'src/environments/environment.development';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RankService {
  private readonly BASE_URL = environment.base_url;

  constructor(private http: HttpClient){
    
  }

  assignMeberToCompetition(data:any){
    return this.http.post(this.BASE_URL+"/competition/assing", data);
  }

  getRankskOfCompetition(code:string): Observable<any>{
    return this.http.get(this.BASE_URL+"/ranking/finalrank/"+code);
  }
}
