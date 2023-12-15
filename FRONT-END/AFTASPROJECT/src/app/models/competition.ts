import { Time } from "@angular/common";

export interface Competition {
    code:string;
    startTime:Time;
    endTime:Time;
    date:Date;
    numberOfParticipants:Number;
    location:String;
    amount:number;
}
