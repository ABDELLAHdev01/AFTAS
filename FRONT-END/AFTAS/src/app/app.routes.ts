import { Routes } from '@angular/router';
import { DashboardComponent } from './layout/dashboard/dashboard.component';
import { CompetitionsComponent } from './compomemnts/competitions/competitions.component';

export const routes: Routes = [

    {path : '',
    component : DashboardComponent,
    children:[
      {path:"competitions" , component:CompetitionsComponent},
    

    ]
  },
];
