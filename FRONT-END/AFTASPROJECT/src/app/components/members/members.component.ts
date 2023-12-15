import { Component } from '@angular/core';
import { initFlowbite } from 'flowbite';
import { MemberService } from 'src/app/services/member.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.css']
})
export class MembersComponent {
  AddForm: FormGroup;


  ngOnInit(): void {
    initFlowbite();
    this.getMembers();

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
        identityDocument: '',
        identityNumber: '',
        nationality: '',
    })
  }


  getMembers(){
    this.membersService.getMembers().subscribe(mem => {
      console.log(mem);
      
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
