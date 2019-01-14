import { Component, OnInit } from '@angular/core';

import { Invoice } from '../invoice';
import { InvoiceService } from '../invoice.service';

import {MatDialog} from '@angular/material';

@Component({
  selector: 'app-create-invoice',
  templateUrl: './create-invoice.component.html',
  styleUrls: ['./create-invoice.component.css']
})
export class CreateInvoiceComponent implements OnInit {

  invoice: Invoice = new Invoice();
  submitted = false;
  constructor(private invoiceService: InvoiceService,public dialog: MatDialog) { }

  ngOnInit() {
  }

  newInvoice(): void {
    this.submitted = false;
    this.invoice = new Invoice();
  }

  save() {
    this.invoiceService.createInvoice(this.invoice)
      .subscribe(data => console.log(data), error => console.log(error));
    this.invoice = new Invoice();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  arrayinvoices = [
    { id: 1, type: 'Gas' },
    { id: 2, type: 'Water' },
    { id: 3, type: 'Internet' },
    { id: 4, type: 'Electric' },
  ]

}
