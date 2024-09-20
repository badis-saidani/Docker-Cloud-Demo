import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit{

  msg = '';
  username: string | null;

  exit() {
    localStorage.removeItem('username');
    this.router.navigate(['/']);
  }
  constructor(private http: HttpClient, private router: Router) {
    this.username = localStorage.getItem('username');
  }
  ngOnInit(): void {
    this.http.get('http://107.22.12.230:8080/api/welcome').subscribe( 
      (res:any) => this.msg = res.response
    );
  }



}
