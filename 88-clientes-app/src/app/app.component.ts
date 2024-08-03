import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DirectivaComponent, FooterComponent, HeaderComponent } from "@shared/components";
import {ClientesComponent} from "@clientes/clientes/clientes.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, FooterComponent, DirectivaComponent, ClientesComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  public title: string = 'Bienvenido a Angular';
}
