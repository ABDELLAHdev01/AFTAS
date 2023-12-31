import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';


@Injectable({
  providedIn: 'root'
})
export class FishService {


  private readonly BASE_URL = environment.base_url;

  constructor(private http : HttpClient) { }


  getFishes(): Observable<any>{
    return this.http.get(this.BASE_URL+'/fish'); 
  }
}
