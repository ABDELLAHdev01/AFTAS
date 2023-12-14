import { Component } from '@angular/core';
import { initFlowbite } from 'flowbite';
import { competitions } from 'src/app/models/competition';
import { CompetitionService } from 'src/app/services/competition.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-competitions',
  templateUrl: './competitions.component.html',
  styleUrls: ['./competitions.component.css']
})
export class CompetitionsComponent {

  private dataList : any = [];
  AddForm: FormGroup;
  showModal = true; 

  constructor(
    private competitionsService: CompetitionService ,
     private _fb: FormBuilder ,
     private toastr: ToastrService

     ){
    this.AddForm = this._fb.group({
        code: '',
        date: '',
        startTime: '',
        endTime: '',
        numberOfParticipants: '',
        location: '',
        amount: ''
    })
  }

  ngOnInit(): void {
    initFlowbite();
    this.getAllCompetitions();
    this.AddForm
    
  }


  OnAddFormSubmite(){
    if(this.AddForm.valid){
      console.log(this.AddForm.value);
      this.competitionsService.AddCompetition(this.AddForm.value).subscribe({
        next: (val: any) => {
          this.toastr.success('Item moved successfully.', 'Success', {
            closeButton: true,
            timeOut: 3000,
          });
          this.closeModal();
          this.AddForm.reset();

        },
        error: (err: any) => {
          console.log(err);
          
        }
      })
    }
  }
  closeModal() {
    this.showModal = false;
  }

  getAllCompetitions(){
    
    this.competitionsService.GetAllCompetitions().subscribe(data =>{
      console.log(data);
      this.dataList = data;

      
    })

   
    

    
    
    
  }
}
