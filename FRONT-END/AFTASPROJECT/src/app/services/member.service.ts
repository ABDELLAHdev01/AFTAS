import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { environment } from 'src/environments/environment.development';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class MemberService {

  private readonly BASE_URL = environment.base_url;

  constructor(private http: HttpClient){
    
  }


  AddMember(data: any): Observable<any>{
    return this.http.post(this.BASE_URL+'/member',data); 
  }

  getMembers(): Observable<any>{
    return this.http.get(this.BASE_URL+'/member'); 
  }

}
