import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { environment } from '../environments/environment';
import { Competition } from '../app/models/Competition';

@Injectable({
  providedIn: 'root'
})
export class CompetitionService{

    private readonly base_url = environment.BASE_URL+"/competition";

    constructor(private http:HttpClient) {
    }

    addCompetition(competition: Competition) {
            return this.http.post(`${this.base_url}/addComp`,competition)
    }


}