import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class InvoiceServiceService {

  private invoiceUrl = 'http://localhost:8080/in/invoices';

  constructor(private http: HttpClient) { }

  getAllInvoice(): Observable<any> {
    return this.http.get(`${this.invoiceUrl}`);
  }

  getInvoiceByIdUser(id: number): Observable<Object> {
    return this.http.get(`${this.invoiceUrl}/get/${id}`);
  }

  getInvoiceByusername(name: string): Observable<Object> {
    return this.http.get(`${this.invoiceUrl}/uget/${name}`);
  }
}
