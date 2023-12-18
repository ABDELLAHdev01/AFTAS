import { HttpClient, provideHttpClient, withFetch } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
    declarations: [
      
    ],
    imports: [
      HttpClientModule,
      BrowserModule,
      RouterModule,
    ],
    providers: [ 
      provideClientHydration(),
      provideHttpClient(withFetch()),
     ]

    })
    export class AppModule { }