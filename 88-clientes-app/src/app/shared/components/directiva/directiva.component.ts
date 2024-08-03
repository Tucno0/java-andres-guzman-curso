import {ChangeDetectionStrategy, Component} from '@angular/core';
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-directiva',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './directiva.component.html',
})
export class DirectivaComponent {
  public listaCurso: string[] = ['TypeScript', 'JavaScript', 'Java SE', 'C#', 'PHP'];
  public habilitar: boolean = true;

  public setHabilitar(): void {
    this.habilitar = !this.habilitar;
  }
}
