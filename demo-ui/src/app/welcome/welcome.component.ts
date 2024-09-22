import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WelcomeService } from './welcome.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit{

  msg: string = '';
  quote: string = '';
  author: string = '';
  username: string | null;

  constructor(private service: WelcomeService, private router: Router) {
    this.username = localStorage.getItem('username');
  }
  ngOnInit(): void {
    this.fetchWelcomeMessage();
    this.fetchQuote();
  }

  fetchWelcomeMessage(): void {
    this.service.getWelcomeMessage().subscribe( 
      (res:any) => this.msg = res.response
    );
  }
  fetchQuote(): void {
    this.service.getRandomQuote().subscribe({
      next: (data) => {
        if (data && data.length > 0) {
          this.quote = data[0].q;
          this.author = data[0].a;
        }
      }
    });
  }

  exit() {
    localStorage.removeItem('username');
    this.router.navigate(['/']);
  }


}
