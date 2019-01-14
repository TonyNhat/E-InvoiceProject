import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { InvoiceDetailsComponent } from './invoice-details/invoice-details.component';
import { InvoicesListComponent } from './invoices-list/invoices-list.component';
import { CreateInvoiceComponent } from './create-invoice/create-invoice.component';
import { SearchInvoicesComponent } from './search-invoices/search-invoices.component';

import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';

import { InvoiceService } from './invoice.service';



@NgModule({
  declarations: [
    AppComponent,
    
    InvoiceDetailsComponent,
    InvoicesListComponent,
    CreateInvoiceComponent,
    SearchInvoicesComponent,
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,

    MatButtonModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatDialogModule
  ],
  providers: [
              InvoicesListComponent
            ],
  bootstrap: [AppComponent],

  entryComponents:[
    
  ],
})
export class AppModule { }
