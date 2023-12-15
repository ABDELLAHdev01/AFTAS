import { initFlowbite } from 'flowbite';
import { Competition } from 'src/app/models/competition';
import { CompetitionService } from 'src/app/services/competition.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Component, ViewChild, ElementRef } from '@angular/core';
import { CompetitionResponse } from 'src/app/models/competition-response';
@Component({
  selector: 'app-competitions',
  templateUrl: './competitions.component.html',
  styleUrls: ['./competitions.component.css']
})
export class CompetitionsComponent {


  competitions: Competition[] = [];
  AddForm: FormGroup;
  showModal = true; 
  @ViewChild('closeModalButton', { static: false }) closeModalButton: ElementRef | undefined;

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
          this.AddForm.reset();
          this.triggerCloseButtonClick();
          this.getAllCompetitions();


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
  

  getAllCompetitions(){
    
   
    this.competitionsService.GetAllCompetitions().subscribe((data: CompetitionResponse) => {
      this.competitions = data.AllCompetitions;
      console.log(this.competitions);
      
    });
   
    

    
    
    
  }

  ngAfterViewInit() {
    // Now you can use this.closeModalButton safely
  }

  // ... rest of your component code

  closeModal() {
    // Assuming your modal library uses the 'hidden' class to hide the modal
    // You may need to adapt this based on your modal library
    if (this.closeModalButton) {
      this.closeModalButton.nativeElement.classList.add('hidden');
    }
  }

  // Programmatically trigger the click event of the close button
  triggerCloseButtonClick() {
    if (this.closeModalButton) {
      this.closeModalButton.nativeElement.click();
    }
  }

}
