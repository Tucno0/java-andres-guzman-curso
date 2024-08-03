import {inject, Injectable} from '@angular/core';
import {CLIENTES} from '@core/constants';
import {Cliente} from '@core/models';
import {Observable, of} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "@environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private readonly http = inject(HttpClient);
  private readonly apiUrl: string = environment.apiUrl;

  constructor() { }

  getClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(`${this.apiUrl}/clientes`);
  }
}
