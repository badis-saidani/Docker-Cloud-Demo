import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { KeycloakService } from '../keycloak/keycloak.service';


@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {

    constructor(private keycloakService: KeycloakService, private router: Router) {}

    async canActivate(): Promise<boolean> {
        const isLoggedIn = this.keycloakService.profile;

        if (!isLoggedIn) {
            this.router.navigate(['/']);
            return false;
        }
        return true;
    }
}
