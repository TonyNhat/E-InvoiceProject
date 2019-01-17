import { Invoice } from './../invoice';
import { Observable } from 'rxjs';
import { InvoiceServiceService } from './../services/invoice-service.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-invoice',
  templateUrl: './list-invoice.component.html',
  styleUrls: ['./list-invoice.component.css']
})
export class ListInvoiceComponent implements OnInit {

  headElements = ['#ID', 'Date', 'Type', 'VAT', 'Grand', 'Total'];
  errorMessage: string;

  invoices: Observable<Invoice[]>;
  constructor(private invoiceService: InvoiceServiceService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.invoiceService.getAllInvoice().subscribe(
      data => {
        this.invoices = this.invoiceService.getAllInvoice();
      }
      ,
      error => {
        this.errorMessage = `ERROR: ${error.status}: You don't have permission to do this action!`;
      }
    );
    // this.users = this.userServices.getUsersList();

  }

}
