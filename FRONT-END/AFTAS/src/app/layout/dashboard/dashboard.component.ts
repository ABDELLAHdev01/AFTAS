import { Component } from '@angular/core';
import { NavbarComponent } from '../../compomemnts/navbar/navbar.component';
import { RouterOutlet } from '@angular/router';
import { FooterComponent } from '../../compomemnts/footer/footer.component';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [NavbarComponent,RouterOutlet,FooterComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

}
