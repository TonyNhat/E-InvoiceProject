import { Component, OnInit } from '@angular/core';

import { Invoice } from '../invoice';
import { InvoiceService } from '../invoice.service';

@Component({
  selector: 'app-search-invoices',
  templateUrl: './search-invoices.component.html',
  styleUrls: ['./search-invoices.component.css']
})
export class SearchInvoicesComponent implements OnInit {

  type: string;
  invoices:Invoice[];
  constructor(private dataService: InvoiceService) { }

  ngOnInit() {
    this.type = '';
  }

  private searchInvoices() {
    this.dataService.getInvoicesByType(this.type)
      .subscribe(invoices => this.invoices = invoices);
  }
 
  onSubmit() {
    this.searchInvoices();
  }
  arrayinvoice = [
    { id: 1, type: 'Gas' },
    { id: 2, type: 'Water' },
    { id: 3, type: 'Internet' },
    { id: 4, type: 'Electric' },
  ]
}
