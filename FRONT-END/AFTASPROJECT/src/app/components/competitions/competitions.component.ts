import { initFlowbite } from 'flowbite';
import { Competition } from 'src/app/models/competition';
import { CompetitionService } from 'src/app/services/competition.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Component, ViewChild, ElementRef } from '@angular/core';
import { CompetitionResponse } from 'src/app/models/competition-response';
import { MemberService } from 'src/app/services/member.service';
import { Member } from 'src/app/models/member';
import { MemberResponse } from 'src/app/models/member-response';
import { RankService } from 'src/app/services/rank.service';
import { NgxPaginationModule } from 'ngx-pagination';
import { Fish } from 'src/app/models/fish';
import { FishService } from 'src/app/services/fish.service';
import { HuntService } from 'src/app/services/hunt.service';
import { RankResponse } from 'src/app/models/rank-response';
import { RankingEntry } from 'src/app/models/ranking-entry';
import { Rank } from 'src/app/models/rank';
import { RankingResponse } from 'src/app/models/ranking-response';
import { Time } from '@angular/common';
@Component({
  selector: 'app-competitions',
  templateUrl: './competitions.component.html',
  styleUrls: ['./competitions.component.css']
})
export class CompetitionsComponent {


  competitions: Competition[] = [];
  members: Member[] = [];
  fishes: Fish[] = [];
  rankings: RankingEntry[] = [];
  filteredMembers: any[] = [];
  dateValue:any;
  comID: string;
  AddForm: FormGroup;
  Assigne: FormGroup;
  Hunt: FormGroup;
  showModal = true; 
  @ViewChild('closeModalButton', { static: false }) closeModalButton: ElementRef | undefined;
  @ViewChild('closeModalButtonasss', { static: false }) closeModalButtonasss: ElementRef | undefined;


  // Pagination variables

  page:number = 1;
  count:number = 0;
  tableSize:number = 5;
  tableSizes: any = [5,10,20,30];
  total:any = 0;
  




  constructor(
    private competitionsService: CompetitionService ,
     private _fb: FormBuilder ,
     private toastr: ToastrService,
     private fisherService: FishService,
     private memberService: MemberService,
     private rankService: RankService,
     private huntService: HuntService

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
    this.Assigne= this._fb.group({
      memberId: 0,
      codeCompetition:''
    })
    this.comID = "";

    this.Hunt = this._fb.group({
      code: '',
      number:0,
      fishId:0,
      weight:0
      

    });
  }

  ngOnInit(): void {
    initFlowbite();
    this.getAllCompetitions();
    this.getAllMembers();    
    this. getFishe();
    this.getRanksOfCompitition();
  }

  isCompetitionDateBeforeToday(startdate: Date): boolean {
    const today = new Date();
    today.setHours(0, 0, 0, 0);

    const dateCopy = new Date(startdate);
    dateCopy.setHours(0, 0, 0, 0);


    return dateCopy.getTime() == today.getTime() ;
}

changeCompetitionsToFilterStatus(no: number) {
  
  const today = new Date();
  today.setHours(0, 0, 0, 0);

  const filteredCompetitionsStill = this.competitions.filter(competition => {
    const startDate = new Date(competition.date); // Assuming date is a property in your competition object
    startDate.setHours(0, 0, 0, 0);

    return startDate.getTime() > today.getTime();
  });

  const filteredCompetitionsGoing = this.competitions.filter(competition => {
    const startDate = new Date(competition.date); // Assuming date is a property in your competition object
    startDate.setHours(0, 0, 0, 0);

    return startDate.getTime() === today.getTime();
  });

  const filteredCompetitionsDone = this.competitions.filter(competition => {
    const startDate = new Date(competition.date); // Assuming date is a property in your competition object
    startDate.setHours(0, 0, 0, 0);

    return startDate.getTime() < today.getTime();
  });

  if (no === 1) {
    this.competitions = filteredCompetitionsStill;
  }
  if (no === 2) {
    this.competitions = filteredCompetitionsGoing;
  }
  if (no === 3) {
    this.competitions = filteredCompetitionsDone;
  }
}


  onTableChange(event:any){
    this.tableSize = event.target.value;
    this.page = event;
  
  }

  getRanksOfCompitition(){
    this.rankService.getRankskOfCompetition("2078-10-29Tan").subscribe((data: RankingResponse) => {
      this.rankings = data.success;
      console.log(data);
      
    });}


   
  onAssingFormSubmit(){
    // iwanna asgine member id here
    if(this.Assigne.valid){
      console.log(this.Assigne.value);
      
      this.rankService.assignMeberToCompetition(this.Assigne.value).subscribe({
        next: (val: any) => {
          this.toastr.success('Item moved successfully.', 'Success', {
            closeButton: true,
            timeOut: 3000,
          });

          this.triggerCloseButtonClickAssigne();
        },
        error: (err: any) => {
          console.log(err);
            this.toastr.error(err.error.details,"error",{
              closeButton: true,
              timeOut: 3000,
            });
        }

      })
    }
  }

  openAssignmentModal(id:string){
    this.comID = id;
    this.Assigne.patchValue({ codeCompetition: id }); // Set the competition ID in the form
    console.log(id);
    
  }

  openRankModal(code: string): void {
    this.rankService.getRankskOfCompetition(code).subscribe(
      (data) => {
        console.log(data);
        // Assign the success property of RankResponse to rankingss
        this.rankings = data.success;
        this.toastr.success('Ranks Calculated Successfully.', 'Success', {
          closeButton: true,
          timeOut: 3000,
        });
      },
      (error) => {
        console.error('Error fetching rankings:', error);
        this.toastr.error(error.error.error,"error",{
          closeButton: true,
          timeOut: 3000,
        });
      }
    );
    this.getAllMembers();
   
    const memberIdsToFilter = [...new Set(this.rankings.map(rank => rank.id.memberNumber))];

    this.filteredMembers = this.members.filter(member => memberIdsToFilter.includes(member.number));

    console.log(this.filteredMembers);
    
  }

  openHuntModal(id: string){
    this.comID = id;
    this.Hunt.patchValue({code: id})
    console.log(id);

  }

  onHuntSubmit(){
    if(this.Hunt.valid){
      this.huntService.addHunt(this.Hunt.value).subscribe({
        next: (val: any) => {
          this.toastr.success('Hunt Has Been Adedd Successfully', 'Success', {
            closeButton: true,
            timeOut: 3000,
          });
      


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
 

  OnAddFormSubmite(){
    if(this.AddForm.valid){
      console.log(this.AddForm.value);
      this.competitionsService.AddCompetition(this.AddForm.value).subscribe({
        next: (val: any) => {
          const dateControl = this.AddForm.get('date');
          if (dateControl) {
             this.dateValue = dateControl.value;
            
          }

          this.toastr.success('Competition Has Beem Created At '+this.dateValue, 'Success', {
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


  getFishe(){

    this.fisherService.getFishes().subscribe(data =>{
      this.fishes = data.success;
      console.log(this.fishes);
      
    })
      
  }


  getAllCompetitionswtithField(field: string){
    
    
   
    this.competitionsService.GetAllCompetitionsField(field).subscribe((data: CompetitionResponse) => {
      this.competitions = data.AllCompetitions;
      console.log(this.competitions);
      
    });}
  getAllMembers(){

    this.memberService.getMembers().subscribe((data: MemberResponse) => {
      this.members = data.members;
      console.log(this.members);
      
    });
  }

  

 

  // Programmatically trigger the click event of the close button
  triggerCloseButtonClick() {
    if (this.closeModalButton) {
      this.closeModalButton.nativeElement.click();
    }
  }

  triggerCloseButtonClickAssigne() {
    if(this.closeModalButtonasss){
      this.closeModalButtonasss.nativeElement.click();
    }
    
    }
}
