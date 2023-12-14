import {
  ChangeDetectionStrategy,
  ChangeDetectorRef,
  Component,
  Inject,
  LOCALE_ID,
  OnDestroy,
  OnInit,
} from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AddModalComponent } from '../add-modal/add-modal.component';
import { TableComponent } from '../table/table.component';
import { CompetitonService } from '../../services/competiton.service';


@Component({
  selector: 'app-competitions',
  standalone: true,
  imports: [AddModalComponent,TableComponent],
  templateUrl: './competitions.component.html',
  styleUrl: './competitions.component.css'
})
export class CompetitionsComponent implements OnInit {
  comps:any[]= [];

  constructor(private competitionService: CompetitonService){
  }

  ngOnInit()  {
    console.log("frf");
    
  }

  // getAllCompetitions(){
   
  //   this.competitionService.getAllCompetitions().subscribe(compet =>{
  //    this.comps = compet;
  //   })

//  }
 
  
}
