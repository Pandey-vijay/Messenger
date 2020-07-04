import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs";

export class LoginAuthGaurdService implements CanActivate{
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean > | boolean{
    if(localStorage.getItem("authId").toString() === null) {
      console.log(localStorage.getItem("authId"));
      return false;
    }
    else
      return true
  }

}
