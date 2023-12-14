import { Component } from '@angular/core';
import { initFlowbite } from 'flowbite';
@Component({
  selector: 'app-fishes',
  templateUrl: './fishes.component.html',
  styleUrls: ['./fishes.component.css']
})
export class FishesComponent {
  ngOnInit(): void {
    initFlowbite();
  }
}
