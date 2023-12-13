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
import { CompetitionService } from '../../../services/CompetitionService';


@Component({
  selector: 'app-competitions',
  standalone: true,
  imports: [AddModalComponent,TableComponent],
  templateUrl: './competitions.component.html',
  styleUrl: './competitions.component.css'
})
export class CompetitionsComponent implements OnInit {
  comps:any[]= [];



  ngOnInit(): void {
    
  }

 
  
}
