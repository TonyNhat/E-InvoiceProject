import { User } from './../user';
import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';

import { UserService } from '../services/user.service';
import { UserDetailsComponent } from '../user-details/user-details.component';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  headElements = ['#ID', 'Name', 'Email', 'Phone', 'Address', 'Active', 'Action'];
  errorMessage: string;
  users: Observable<User[]>;


  submitted = false;
  message: string;

  @Input() user: User;

  constructor( private userServices: UserService) { }

  ngOnInit() {
    this.reloadData();
  }

  deleteUsers() {
    this.userServices.deleteAll().subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log('ERROR: ' + error)
    );
  }

  reloadData() {
    this.userServices.getUsersList().subscribe(
      data => {
        this.users = this.userServices.getUsersList();
      }
      ,
      error => {
        this.errorMessage = `ERROR: ${error.status}: You don't have permission to do this action!`;
      }
    );
    // this.users = this.userServices.getUsersList();

  }


  delete(id: number) {
    this.userServices.deleteUser(id).subscribe(
      data => {
        this.reloadData();
      },
      error => {
        console.error(this.message);
      }
    );
  }

  update(id: number, username: string, password: string, name: string, email: string, phone: string, address: string , isActive: boolean) {
    this.userServices.updateUser(id,
      { username: username, password: password , name: name,
        email: email, phone: phone, address: address , active: isActive })
      .subscribe(
        data => {
          console.log(data);
          this.user = data as User;
          this.reloadData();
        },
        error => console.log(error));
  }

}
