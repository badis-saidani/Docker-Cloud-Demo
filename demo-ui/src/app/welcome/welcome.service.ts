import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WelcomeService {

  private msgUrl = 'http://107.22.12.230:8080/api/welcome';
  private quoteUrl = '/zenApi/api/random';

  constructor(private http: HttpClient) {}

  getWelcomeMessage(): Observable<any> {
    return this.http.get<any>(this.msgUrl);
  }
  getRandomQuote(): Observable<any> {
    return this.http.get<any>(this.quoteUrl);
  }
}
