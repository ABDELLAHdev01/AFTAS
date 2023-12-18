import { Component } from '@angular/core';
import { initFlowbite } from 'flowbite';
import { Fish } from 'src/app/models/fish';
import { FishService } from 'src/app/services/fish.service';
import { FishResponse } from 'src/app/models/fish-response';
@Component({
  selector: 'app-fishes',
  templateUrl: './fishes.component.html',
  styleUrls: ['./fishes.component.css']
})
export class FishesComponent {
  fishes: Fish[] = [];

   // Pagination variables

   page:number = 1;
   count:number = 0;
   tableSize:number = 5;
   tableSizes: any = [5,10,20,30];
   total:any = 0;
   
  ngOnInit(): void {
    initFlowbite();
    this.getAllFishes()
  }

  constructor(private fishservice:FishService){

  }

  getAllFishes(){
    this.fishservice.getFishes().subscribe((data: FishResponse) =>{
        this.fishes = data.success;
    })
  }
}
