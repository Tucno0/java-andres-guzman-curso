import { Injectable } from '@angular/core';
import {CLIENTES} from '@core/constants';
import {Cliente} from '@core/models';
import {Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor() { }

  getClientes(): Observable<Cliente[]> {
    return of(CLIENTES);
  }
}
