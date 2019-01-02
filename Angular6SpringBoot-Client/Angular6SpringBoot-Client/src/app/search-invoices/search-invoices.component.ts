import { Component, OnInit } from '@angular/core';

import { Invoice } from '../invoice';
import { InvoiceService } from '../invoice.service';

@Component({
  selector: 'app-search-invoices',
  templateUrl: './search-invoices.component.html',
  styleUrls: ['./search-invoices.component.css']
})
export class SearchInvoicesComponent implements OnInit {

  VAT: number;
  invoices:Invoice[];
  constructor(private dataService: InvoiceService) { }

  ngOnInit() {
    this.VAT = 0;
  }

  private searchInvoices() {
    this.dataService.getInvoicesByVAT(this.VAT)
      .subscribe(customers => this.invoices = this.invoices);

      // this.dataService.getInvoicesByVAT(this.VAT)
      // .subscribe(customers => this.invoices = invoices);
  }
 
  onSubmit() {
    this.searchInvoices();
  }

}
