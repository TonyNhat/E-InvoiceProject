import { ListInvoiceComponent } from './list-invoice/list-invoice.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { UserListComponent } from './user-list/user-list.component';

const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'user',
        component: UserComponent
    },
    {
        path: 'admin',
        component: AdminComponent
    },
    {
        path: 'user-details',
        component: UserDetailsComponent
    },
    {
        path: 'auth/login',
        component: LoginComponent
    },
    {
        path: 'invoices',
        component: ListInvoiceComponent
    },
    {
        path: 'signup',
        component: RegisterComponent
    },
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    },
    {
        path: 'user-list',
        component: UserListComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
