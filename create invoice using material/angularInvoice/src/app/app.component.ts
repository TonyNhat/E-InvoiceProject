import { Component } from '@angular/core';

import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { AddDialogComponent } from './add-dialog/add-dialog.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'angularInvoice';
  constructor(public dialog: MatDialog){
  }
    openDialog(): void {
      let dialogRef = this.dialog.open(AddDialogComponent, {
  
      });
  
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
      });
    
  

  }

  invoices = [
    {id: 1, type: 'Gas'},
    {id: 2, type: 'Water'},
    {id: 3, type: 'Internet'},
    {id: 4, type: 'Electric'},
  ]

}

