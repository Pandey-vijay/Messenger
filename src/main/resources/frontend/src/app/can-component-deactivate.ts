import { Observable } from "rxjs";

export interface CanComponentDeactivate{
    canDeactivate : () => Promise<boolean>|Observable<boolean>|boolean
} 