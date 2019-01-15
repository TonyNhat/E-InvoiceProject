import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../user';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})



export class UserService {

  private userUrl = 'http://localhost:8080/jpa/test/user';
  private pmUrl = 'http://localhost:8080/jpa/test/pm';
  private adminUrl = 'http://localhost:8080/jpa/test/admin';
  private adminUrls = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) { }

  getUserBoard(): Observable<string> {
    return this.http.get(this.userUrl, { responseType: 'text' });
  }

  getPMBoard(): Observable<string> {
    return this.http.get(this.pmUrl, { responseType: 'text' });
  }

  getAdminBoard(): Observable<string> {
    return this.http.get(this.adminUrl, { responseType: 'text' });
  }

  getUser(id: number): Observable<Object> {
    return this.http.get(`${this.adminUrls}/${id}`);
  }

  createUser(user: Object): Observable<Object> {
    return this.http.post(`${this.adminUrls}` + `/create`, user);
  }

  updateUser(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.adminUrls}/${id}`, value);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.adminUrls}/${id}`, { responseType: 'text' });
  }

  getUsersList(): Observable<any> {
    return this.http.get(`${this.adminUrls}`);
  }

  getusersByUserName(username: string): Observable<any> {
    return this.http.get(`${this.adminUrls}/username/${username}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.adminUrls}` + `/delete`, { responseType: 'text' });
  }

}
