import { Routes } from '@angular/router';
import { DashboardComponent } from './layout/dashboard/dashboard.component';
import { CompetitionsComponent } from './compomemnts/competitions/competitions.component';
import { MembersComponent } from './compomemnts/members/members.component';
import { FishesComponent } from './compomemnts/fishes/fishes.component';
import { HomeComponent } from './compomemnts/home/home.component';

export const routes: Routes = [

    {path : '',
    component : DashboardComponent,
    children:[
      {path : '', component: HomeComponent},
      {path:"competitions" , component:CompetitionsComponent},
      {path: "members", component:MembersComponent},
      {path: "fishes", component:FishesComponent}
    

    ]
  },

  
  
];


