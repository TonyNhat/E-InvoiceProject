import { Component, OnInit, Input } from '@angular/core';
import { InvoiceService } from '../invoice.service';
import { Invoice } from '../invoice';

@Component({
  selector: 'app-invoice-details',
  templateUrl: './invoice-details.component.html',
  styleUrls: ['./invoice-details.component.css']
})
export class InvoiceDetailsComponent implements OnInit {

  @Input() invoice: Invoice;
  constructor(private invoiceService: InvoiceService) { }

  ngOnInit() {
  }

  deleteCustomer() {
    this.invoiceService.deleteInvoice(this.invoice.id)
      .subscribe(
        data => {
          console.log(data);
         // this.listComponent.reloadData();
        },
        error => console.log(error));
  }

}
