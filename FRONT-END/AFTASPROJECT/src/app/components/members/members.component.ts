import { Component } from '@angular/core';
import { initFlowbite } from 'flowbite';
import { MemberService } from 'src/app/services/member.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Member } from 'src/app/models/member';
import {  ViewChild, ElementRef } from '@angular/core';
import { environment } from 'src/environments/environment.development';



@Component({
  selector: 'app-members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.css']
})
export class MembersComponent {
  @ViewChild('closebtn', { static: false }) closebtn: ElementRef | undefined;
  countries: any = environment.countryList;

    // Pagination variables

    POSTS:any;
    page:number = 1;
    count:number = 0;
    tableSize:number = 10;
    tableSizes: any = [5,10,20,30];
    total:any = 0;
    
  AddForm: FormGroup;
  members: Member[] = [];

  ngOnInit(): void {
    initFlowbite();
    this.getMembers();

  }

  onTableChange(event:any){
    this.tableSize = event.target.value;
    this.page = event;
    initFlowbite();

  }

  constructor(
    private membersService: MemberService,
    private _fb: FormBuilder ,
    private toastr: ToastrService

    ){
      this.AddForm = this._fb.group({
        firstName: '',
        lastName: '',
        accessionDate: '',
        identityDocumentType: '',
        identityNumber: '',
        nationality: '',
    })
  }


  
 closethebtn(){
  if (this.closebtn) {
    this.closebtn.nativeElement.click();
    initFlowbite();

  }
 }

  getMembers(){
    this.membersService.getMembers().subscribe(mem => {
      this.members = mem.members
      initFlowbite();

    })
  }


  OnAddFormSubmite(){
    if(this.AddForm.valid){
      console.log(this.AddForm.value);
      this.membersService.AddMember(this.AddForm.value).subscribe({
        next: (val: any) => {
          this.toastr.success('Member Addedd successfully.', 'Success', {
            closeButton: true,
            timeOut: 3000,
          });
          this.AddForm.reset();
          this.closethebtn()
          this.getMembers();

        },
        error: (err: any) => {
          console.log(err);
          this.toastr.error(err.error.error,"error",{
            closeButton: true,
            timeOut: 3000,
          });
        }
      })
    }
  }
}
