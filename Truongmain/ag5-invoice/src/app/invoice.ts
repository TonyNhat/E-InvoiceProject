import { User } from './user';
export class Invoice {
  id: number;
  date: Date;
  i_type: string;
  vat: number;
  grandTotal: number;
  total: number;
  idUser: User;

  constructor(id: number, date: Date, i_type: string, vat: number, grandTotal: number, total: number) {
    this.id = id;
    this.date = date;
    this.i_type = i_type;
    this.vat = vat;
    this.grandTotal = grandTotal;
    this.total = total;
  }
}
