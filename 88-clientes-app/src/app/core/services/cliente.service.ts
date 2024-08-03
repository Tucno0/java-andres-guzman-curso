import {inject, Injectable} from '@angular/core';
import {Cliente} from '@core/models';
import {catchError, Observable, of, throwError} from "rxjs";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {environment} from "@environments/environment";
import {CreateClienteDto} from "@clientes/interfaces";
import swal from 'sweetalert2';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private readonly http = inject(HttpClient);
  private readonly apiUrl: string = environment.apiUrl;
  private readonly router = inject(Router);

  constructor() { }

  getClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(`${this.apiUrl}/clientes`);
  }

  getCliente(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.apiUrl}/clientes/${id}`)
      .pipe(
        catchError((error: HttpErrorResponse) => {
          this.router.navigate(['/clientes']);
          swal.fire('Error al editar', error.error.mensaje, 'error').then();
          return throwError( () => error );
        })
      )
  }

  create(createClienteDto: CreateClienteDto): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/clientes`, createClienteDto)
      .pipe(
        catchError((error: HttpErrorResponse) => {
          swal.fire('Error al crear', error.error.mensaje, 'error').then();
          return throwError( () => error );
        })
      );
  }

  update(id: number, updateClienteDto: CreateClienteDto): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/clientes/${id}`, updateClienteDto)
      .pipe(
        catchError((error: HttpErrorResponse) => {
          swal.fire('Error al actualizar', error.error.mensaje, 'error').then();
          return throwError( () => error );
        })
      );
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/clientes/${id}`)
      .pipe(
        catchError((error: HttpErrorResponse) => {
          swal.fire('Error al eliminar', error.error.mensaje, 'error').then();
          return throwError( () => error );
        })
      );
  }
}
