import { Component } from '@angular/core';
import { initFlowbite } from 'flowbite';
@Component({
  selector: 'app-members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.css']
})
export class MembersComponent {
  ngOnInit(): void {
    initFlowbite();
  }
}
