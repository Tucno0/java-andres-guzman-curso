import { Routes } from '@angular/router';
import {ClientesComponent} from "@clientes/clientes/clientes.component";
import {DirectivaComponent} from "@shared/components";

export const routes: Routes = [
  { path: 'clientes', component: ClientesComponent },
  { path: 'directivas', component: DirectivaComponent },
  { path: '', redirectTo: 'clientes', pathMatch: 'full' },
  { path: '**', redirectTo: 'clientes' }
];
