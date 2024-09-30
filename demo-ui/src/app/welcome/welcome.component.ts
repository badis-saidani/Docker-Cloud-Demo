import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WelcomeService } from './welcome.service';
import { KeycloakService } from '../keycloak/keycloak.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit{

  msg: string = '';
  quote: string = '';
  author: string = '';
  username: string | undefined;

  constructor(private service: WelcomeService, private router: Router, private keycloak: KeycloakService) {
    this.username = keycloak.profile?.firstName;
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
    this.service.getRandomQuote().subscribe(
      (data) => {
        this.quote = data.q;
        this.author = data.a;
      },
      (err) => {
        console.error(err);
        
      }
    );
  }

  // exit() {
  //   localStorage.removeItem('username');
  //   this.router.navigate(['/']);
  // }

  logout() {
    this.keycloak.logout();
}

}
