import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  // { path: '', component: HomeComponent },
  { path: 'welcome', component: WelcomeComponent, canActivate: [AuthGuard] },
  { path: '', redirectTo: '/welcome', pathMatch: 'full' },
  { path: '**', redirectTo: '/welcome' } // Redirect unknown paths to home
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
