import { TestBed, inject } from '@angular/core/testing';

import { InvoiceServiceService } from './invoice-service.service';

describe('InvoiceServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InvoiceServiceService]
    });
  });

  it('should be created', inject([InvoiceServiceService], (service: InvoiceServiceService) => {
    expect(service).toBeTruthy();
  }));
});
