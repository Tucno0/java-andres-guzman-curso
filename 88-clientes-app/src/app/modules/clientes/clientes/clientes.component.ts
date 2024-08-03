import {Component, inject} from '@angular/core';
import {Cliente} from "@core/models";
import {ClienteService} from "@core/services";
import {toSignal} from "@angular/core/rxjs-interop";

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [],
  templateUrl: './clientes.component.html',
})
export class ClientesComponent {
  private readonly ClienteService = inject(ClienteService);

  public clientes= toSignal(this.ClienteService.getClientes());

}
