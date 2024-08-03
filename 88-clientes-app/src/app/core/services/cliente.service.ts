import {inject, Injectable} from '@angular/core';
import {CLIENTES} from '@core/constants';
import {Cliente} from '@core/models';
import {Observable, of} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "@environments/environment";
import {CreateClienteDto} from "@clientes/interfaces";

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

  getCliente(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.apiUrl}/clientes/${id}`);
  }

  create(createClienteDto: CreateClienteDto): Observable<Cliente> {
    return this.http.post<Cliente>(`${this.apiUrl}/clientes`, createClienteDto);
  }

  update(id: number, updateClienteDto: CreateClienteDto): Observable<Cliente> {
    return this.http.put<Cliente>(`${this.apiUrl}/clientes/${id}`, updateClienteDto);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/clientes/${id}`);
  }
}
