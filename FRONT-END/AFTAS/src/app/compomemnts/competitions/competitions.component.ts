import { Component } from '@angular/core';
import { initFlowbite } from 'flowbite';
import { AddModalComponent } from '../add-modal/add-modal.component';
import { TableComponent } from '../table/table.component';


@Component({
  selector: 'app-competitions',
  standalone: true,
  imports: [AddModalComponent,TableComponent],
  templateUrl: './competitions.component.html',
  styleUrl: './competitions.component.css'
})
export class CompetitionsComponent {

}
