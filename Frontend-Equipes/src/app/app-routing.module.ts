import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EquipeComponent } from './equipe/equipe.component';

const routes: Routes = [
  { path: '', redirectTo: 'equipe', pathMatch: 'full' },
  { path: 'equipes', component: EquipeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
