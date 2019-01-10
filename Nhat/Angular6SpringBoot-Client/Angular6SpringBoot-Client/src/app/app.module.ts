import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';


import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { InvoiceDetailsComponent } from './invoice-details/invoice-details.component';
import { InvoicesListComponent } from './invoices-list/invoices-list.component';
import { CreateInvoiceComponent } from './create-invoice/create-invoice.component';
import { SearchInvoicesComponent } from './search-invoices/search-invoices.component';

import { InvoiceService } from './invoice.service';


@NgModule({
  declarations: [
    AppComponent,
    
    InvoiceDetailsComponent,
    InvoicesListComponent,
    CreateInvoiceComponent,
    SearchInvoicesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
              InvoicesListComponent
            ],
  bootstrap: [AppComponent]
})
export class AppModule { }
