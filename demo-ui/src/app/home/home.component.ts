import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  username: string = '';

  constructor(private router: Router) {}

  submit() {
    if (this.username) {
      localStorage.setItem('username', this.username);
      this.router.navigate(['/welcome']);
    }
  }
}
