import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class WelcomeService {

  private baseUrl = `${environment.baseUrl}:8080/api`
  private msgUrl = `${this.baseUrl}/welcome`;
  private quoteUrl = `${this.baseUrl}/quote`;

  constructor(private http: HttpClient) {}

  getWelcomeMessage(): Observable<any> {
    return this.http.get<any>(this.msgUrl);
  }
  getRandomQuote(): Observable<any> {
    return this.http.get<any>(`${this.quoteUrl}`);
  }
}
