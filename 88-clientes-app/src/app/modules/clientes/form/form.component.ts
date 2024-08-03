import {Component, inject, Input} from '@angular/core';
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {ClienteService} from "@core/services";
import {CreateClienteDto} from "@clientes/interfaces";
import {Router} from "@angular/router";
import swal from 'sweetalert2';
import {Cliente} from "@core/models";

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './form.component.html',
  styles: ``
})
export class FormComponent {
  // Leyendo el boardId del parametro de la URL
  @Input()
  set id(id: string) {
    if (id) {
      this.title = 'Editar Cliente';
      this.getCliente(parseInt(id));
    }
  }

  public title = 'Crear Cliente';

  private readonly fb = inject(FormBuilder);
  private readonly clienteService = inject(ClienteService);
  private readonly router = inject(Router);

  public cliente!: Cliente;

  public form = this.fb.group({
    nombre: ['', [Validators.required, Validators.minLength(3)]],
    apellido: ['', [Validators.required, Validators.minLength(3)]],
    email: ['', [Validators.required, Validators.email]],
  });

  create() {
    if (this.form.invalid) {
      return Object.values(this.form.controls).forEach(control => {
        control.markAsTouched();
      });
    }

    this.clienteService.create(this.form.value as CreateClienteDto).subscribe({
      next: (cliente) => {
        swal.fire('Nuevo cliente', `Cliente ${cliente.nombre} creado con éxito`, 'success')
          .then(r => console.log('Sweet alert cerrado', r));

        this.router.navigate(['/clientes']).then(r => console.log('Navegación exitosa', r));
      },
      error: (error) => {
        console.error('Error al crear el cliente', error);
      }
    });
  }

  getCliente(id: number) {
    this.clienteService.getCliente(id).subscribe({
      next: (cliente) => {
        this.form.patchValue(cliente);
        this.cliente = cliente;
      },
      error: (error) => {
        console.error('Error al obtener el cliente', error);
      }
    });
  }

  update(id: number) {
    if (this.form.invalid) {
      return Object.values(this.form.controls).forEach(control => {
        control.markAsTouched();
      });
    }

    this.clienteService.update(id, this.form.value as CreateClienteDto).subscribe({
      next: (cliente) => {
        swal.fire('Cliente actualizado', `Cliente ${cliente.nombre} actualizado con éxito`, 'success')
          .then(r => console.log('Sweet alert cerrado', r));

        this.router.navigate(['/clientes']).then(r => console.log('Navegación exitosa', r));
      },
      error: (error) => {
        console.error('Error al actualizar el cliente', error);
      }
    });
  }
}
