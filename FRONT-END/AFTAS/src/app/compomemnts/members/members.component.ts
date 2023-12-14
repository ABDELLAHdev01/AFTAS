import { Component } from '@angular/core';
import { MemberTableComponent } from '../member-table/member-table.component';
import { AddmodalmemberbtnComponent } from '../addmodalmemberbtn/addmodalmemberbtn.component';
@Component({
  selector: 'app-members',
  standalone: true,
  imports: [MemberTableComponent,AddmodalmemberbtnComponent],
  templateUrl: './members.component.html',
  styleUrl: './members.component.css'
})
export class MembersComponent {

}
