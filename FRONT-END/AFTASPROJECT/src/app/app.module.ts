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
import { CompetitionService } from './services/competition.service';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import {BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { TranslateLoader, TranslateModule } from  '@ngx-translate/core';
import { TranslateHttpLoader } from  '@ngx-translate/http-loader';
import { PaginationComponentComponent } from './components/pagination-component/pagination-component.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { initFlowbite } from 'flowbite';

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
    FishesComponent,

    PaginationComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterOutlet,
    RouterLink,
    HttpClientModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule,
    ReactiveFormsModule,
   
    NgxPaginationModule
    
   
  ],
  providers: [ ],
  bootstrap: [AppComponent]
})
export class AppModule { }
