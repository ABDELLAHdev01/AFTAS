import { Component } from '@angular/core';
import { Competition } from '../../models/Competition';
import { CompetitonService } from '../../services/competiton.service';
import { HttpClientModule } from '@angular/common/http';
@Component({
  selector: 'app-table',
  standalone: true,
  imports: [
    HttpClientModule,
  ],
  templateUrl: './table.component.html',
  styleUrl: './table.component.css'
})
export class TableComponent {  

  // ngOnInit(): void {
  //   this.competitionService.getAllCompetitions().subscribe(competitions => {
  //     this.competition = competitions;
  //   })

    // console.log(this.competition);
    
  // }

}
