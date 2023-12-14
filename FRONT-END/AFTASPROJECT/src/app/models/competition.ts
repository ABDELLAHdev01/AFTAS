import { Time } from "@angular/common";

export interface competitions{
    code:string;
    startTime:Date;
    endTime:Time;
    numberOfParticipants:Number;
    location:String;
    amount:number;

}