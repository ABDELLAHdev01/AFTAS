import { Component } from '@angular/core';
import {  Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-pagination-component',
  templateUrl: './pagination-component.component.html',
  template: `
    <ul class="inline-flex items-stretch -space-x-px">
      <li>
        <a (click)="navigateToPage(currentPage - 1)" [class.disabled]="currentPage === 1">
          <span class="sr-only">Previous</span>
          <svg class="w-5 h-5" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z" clip-rule="evenodd" />
          </svg>
        </a>
      </li>
      <li *ngFor="let page of pages" [class.active]="currentPage === page">
        <a (click)="navigateToPage(page)">{{ page }}</a>
      </li>
      <li>
        <a (click)="navigateToPage(currentPage + 1)" [class.disabled]="currentPage === totalPages">
          <span class="sr-only">Next</span>
          <svg class="w-5 h-5" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z" clip-rule="evenodd" />
          </svg>
        </a>
      </li>
    </ul>
  `,
  styleUrls: ['./pagination-component.component.css']
})
export class PaginationComponentComponent {
  @Input() currentPage: number;
  @Input() totalPages: number;
  @Output() pageChanged = new EventEmitter<number>();
  constructor(){
    this.currentPage = 0;
    this.totalPages = 0;
  }

  get pages(): number[] {
    return Array.from({ length: this.totalPages }, (_, index) => index + 1);
  }

  navigateToPage(page: number): void {
    if (page >= 1 && page <= this.totalPages && page !== this.currentPage) {
      this.pageChanged.emit(page);
    }
  }
}
