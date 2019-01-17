import { InvoiceServiceService } from './../services/invoice-service.service';
import { Invoice } from './../invoice';
import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-create-invoice',
  templateUrl: './create-invoice.component.html',
  styleUrls: ['./create-invoice.component.css']
})
export class CreateInvoiceComponent implements OnInit {
  form: any = {};
  invoiceInfo: Invoice;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';
  username: string;
  percent: number;

  constructor(private tokenStroge: TokenStorageService, private invoiceServices: InvoiceServiceService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.form.username = this.tokenStroge.getUsername();
    console.log(this.form);
    this.form.vat = 10;
    this.percent = (this.form.total / this.form.vat);

    this.invoiceInfo = new Invoice(
      this.form.date,
      this.form.i_type,
      this.form.vat,
      this.form.grandTotal,
      this.form.total,
      this.form.username
      );

    this.invoiceServices.createInvoice(this.invoiceInfo).subscribe(
      data => {
        console.log(data);
        this.isSignedUp = true;
        this.isSignUpFailed = false;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

}
