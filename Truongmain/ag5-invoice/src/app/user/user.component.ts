import { Observable } from 'rxjs';
import { TokenStorageService } from './../auth/token-storage.service';
import { InvoiceServiceService } from './../services/invoice-service.service';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Invoice } from '../invoice';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  board: string;
  errorMessage: string;
  info: any;
  username: string;
  users: Observable<any[]>;
  id = 11;


  constructor(private userService: UserService, private invoiceService: InvoiceServiceService, private tokenStroge: TokenStorageService) { }

  ngOnInit() {
    this.username = this.tokenStroge.getUsername();
    this.reloadData(this.username);
  }

  reloadData(name: string) {
    this.invoiceService.getInvoiceByUsername(name).subscribe(
      data => {
        this.users = this.invoiceService.getInvoiceByUsername(name);
        console.log('get all user by username = ' + name );
      },
      error => {
        console.log(error);
      }
    );
  }

  // reloadData() {
  //   this.invoiceService.getAllInvoice().subscribe(
  //     data => {
  //       this.users = this.invoiceService.getAllInvoice();
  //       console.log('get all user by username = ' + this.username );
  //     }, error => {
  //       console.error(error);
  //     }
  //   );
  // }


}
