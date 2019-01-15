
import { Component, OnInit, Input } from '@angular/core';

import { User } from '../user';
import { UserService } from '../services/user.service';
import { UserListComponent } from '../user-list/user-list.component';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  @Input() user: User;

  info: any;

  constructor(private userService: UserService, private userList: UserListComponent) { }

  ngOnInit() {
    this.info = this.userList.reloadData();
  }

  updateActive(isActive: boolean) {
    this.userService.updateUser(this.user.id,
      { username: this.user.username, password: this.user.password , name: this.user.name,
        email: this.user.email, phone: this.user.phone, address: this.user.address , active: isActive })
      .subscribe(
        data => {
          console.log(data);
          this.user = data as User;
        },
        error => console.log(error));
  }

  // deleteUser() {
  //   this.userService.deleteUser(this.user.id)
  //   .subscribe(
  //     data => {
  //       console.log(data);
  //       this.listUserCompoment.reloadData();
  //     },
  //     error => console.log(error)
  //   );
  // }

}
