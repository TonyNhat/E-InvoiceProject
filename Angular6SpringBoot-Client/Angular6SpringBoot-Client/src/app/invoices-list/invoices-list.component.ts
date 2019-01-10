import { Component, OnInit } from '@angular/core';

import { Observable } from 'rxjs';
 
import { InvoiceService } from '../invoice.service';
import { Invoice } from '../invoice';

@Component({
  selector: 'app-invoices-list',
  templateUrl: './invoices-list.component.html',
  styleUrls: ['./invoices-list.component.css']
})
export class InvoicesListComponent implements OnInit {

  invoices: Observable<Invoice[]>;
  constructor(private invoiceService: InvoiceService) { }

  ngOnInit() {
    this.reloadData();
  }
  deleteInvoices() {
    this.invoiceService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }
 
  reloadData() {
    this.invoices = this.invoiceService.getInvoicesList();
  }

}
