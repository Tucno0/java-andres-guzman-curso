import {Component, inject, OnInit, signal} from '@angular/core';
import {Cliente} from "@core/models";
import {ClienteService} from "@core/services";
import {toSignal} from "@angular/core/rxjs-interop";
import {RouterLink} from "@angular/router";
import swal from 'sweetalert2';

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [
    RouterLink
  ],
  templateUrl: './clientes.component.html',
})
export class ClientesComponent implements OnInit {
  private readonly ClienteService = inject(ClienteService);
  public clientes = signal<Cliente[]>([]);

  ngOnInit() {
    this.getClientes();
  }

  getClientes(): void {
    this.ClienteService.getClientes().subscribe({
      next: (clientes) => {
        this.clientes.set(clientes);
      },
      error: (error) => {
        console.error('Error al obtener los clientes', error);
      }
    });
  }

  delete(cliente: Cliente): void {
    swal.fire({
      title: '¿Está seguro?',
      text: `¿Seguro que desea eliminar al cliente ${cliente.nombre} ${cliente.apellido}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí, eliminar',
      cancelButtonText: 'No, cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        this.ClienteService.delete(cliente.id).subscribe({
          next: () => {
            swal.fire('Cliente eliminado', `Cliente ${cliente.nombre} eliminado con éxito`, 'success')
              .then(r => console.log('Sweet alert cerrado', r));

            this.clientes.update((clientes) => clientes.filter(c => c.id !== cliente.id));
          },
          error: (error) => {
            console.error('Error al eliminar el cliente', error);
          }
        });
      }
    });
  }
}
