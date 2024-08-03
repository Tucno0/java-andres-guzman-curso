import { Routes } from '@angular/router';
import {ClientesComponent} from "@clientes/clientes/clientes.component";
import {DirectivaComponent} from "@shared/components";
import {FormComponent} from "@clientes/form/form.component";

export const routes: Routes = [
  { path: 'clientes', component: ClientesComponent },
  { path: 'directivas', component: DirectivaComponent },
  { path: 'clientes/form', component: FormComponent },
  { path: 'clientes/form/:id', component: FormComponent },
  { path: '', redirectTo: 'clientes', pathMatch: 'full' },
  { path: '**', redirectTo: 'clientes' }
];
