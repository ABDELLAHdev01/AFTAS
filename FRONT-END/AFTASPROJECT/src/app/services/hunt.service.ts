import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class HuntService {

  private readonly BASE_URL = environment.base_url;

  constructor(private http : HttpClient) { }


 

  addHunt(data:any): Observable<any>{
    return this.http.post(this.BASE_URL+"/hunting/add", data);
  }

}
