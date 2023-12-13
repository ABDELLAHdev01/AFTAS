import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';
import { DashbaordComponent } from './layout/dashbaord/dashbaord.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { AppComponent } from './app.component';
import { HerosectionComponent } from './components/herosection/herosection.component';
import { FooterComponent } from './components/footer/footer.component';
import { CompetitionsComponent } from './components/competitions/competitions.component';
import { MembersComponent } from './components/members/members.component';
import { FishesComponent } from './components/fishes/fishes.component';

const routes: Routes = [
  {
  path : '', 
  
  component : DashbaordComponent,

  children: [
    {
      path: '',
      component: LandingPageComponent
    },
    {
      path: 'competitions',
      component:CompetitionsComponent
    }
    ,
    {
      path: 'members',
      component:MembersComponent
    }
    ,
    {
      path: 'fishes',
      component:FishesComponent
    }
  ]

  
  },{
    path: 'members',
    component: HerosectionComponent
  }
 
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]

})
export class AppRoutingModule { }
