import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { InvoiceDetailsComponent } from './invoice-details/invoice-details.component';
import { CreateInvoiceComponent } from './create-invoice/create-invoice.component';
import { SearchInvoicesComponent } from './search-invoices/search-invoices.component';

const routes: Routes = [
    // { path: '', redirectTo: 'customer', pathMatch: 'full' },
    // { path: 'customer', component: CustomersListComponent },
    // { path: 'add', component: CreateCustomerComponent },
    // { path: 'findbyage', component: SearchCustomersComponent },

    { path: '', redirectTo: 'invoice', pathMatch: 'full' },
    { path: 'invoice', component: InvoiceDetailsComponent},
    { path: 'add', component: CreateInvoiceComponent },
    { path: 'findbyType', component: SearchInvoicesComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
