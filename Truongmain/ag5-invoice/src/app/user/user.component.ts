import { TokenStorageService } from './../auth/token-storage.service';
import { InvoiceServiceService } from './../services/invoice-service.service';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

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
  constructor(private userService: UserService, private invoiceService: InvoiceServiceService, private tokenStroge: TokenStorageService) { }

  ngOnInit() {
    this.username = this.tokenStroge.getUsername();

    this.invoiceService.getInvoiceByusername(this.username);
  }

  reloadData(id: number) {
    this.invoiceService.getInvoiceByIdUser(id);
  }
}
