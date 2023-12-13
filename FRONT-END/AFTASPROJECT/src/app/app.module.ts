import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { RouterOutlet } from '@angular/router';
import { DashbaordComponent } from './layout/dashbaord/dashbaord.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { RouterLink } from '@angular/router';
import { HerosectionComponent } from './components/herosection/herosection.component';
import { FooterComponent } from './components/footer/footer.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { CompetitionsComponent } from './components/competitions/competitions.component';
import { MembersComponent } from './components/members/members.component';
import { FishesComponent } from './components/fishes/fishes.component';
@NgModule({
  declarations: [
    AppComponent,
    DashbaordComponent,
    NavbarComponent,
    HerosectionComponent,
    FooterComponent,
    LandingPageComponent,
    CompetitionsComponent,
    MembersComponent,
    FishesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterOutlet,
    RouterLink,
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
