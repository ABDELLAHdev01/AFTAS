import { TestBed } from '@angular/core/testing';

import { CompetitonService } from './competiton.service';

describe('CompetitonService', () => {
  let service: CompetitonService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompetitonService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
