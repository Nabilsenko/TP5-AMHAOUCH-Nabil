import { Component, OnInit } from '@angular/core';
import { EquipeService } from '../equipe.service';
import { Equipe } from '../types/equipe';

@Component({
  selector: 'app-equipe',
  templateUrl: './equipe.component.html',
  styleUrls: ['./equipe.component.scss'],
})
export class EquipeComponent implements OnInit {
  public equipes: Equipe[];
  showForm = false;
  showUpdateForm = false;
  selectedEquipe: Equipe = {
    id: 0,
    nom: '',
    pays: '',
    capaciteStade: 0,
    dateFondation: new Date(),
  };
  equipe: Equipe = {
    id: 0,
    nom: '',
    pays: '',
    capaciteStade: 0,
    dateFondation: new Date(),
  };

  constructor(private equipeService: EquipeService) {
    this.equipes = [];
  }

  ngOnInit() {
    this.getEquipes();
  }

  getEquipes(): void {
    this.equipeService
      .getEquipes()
      .subscribe((equipes) => (this.equipes = equipes));
  }

  getEquipe(id: string): void {
    this.equipeService
      .getEquipe(id)
      .subscribe((equipe) => (this.equipes = [equipe]));
  }

  createEquipe(equipe: Equipe): void {
    this.equipeService.createEquipe(equipe).subscribe(() => this.getEquipes());
    this.getEquipes();
    this.showForm = false;
  }

  updateEquipe(id: number, equipe: Equipe): void {
    this.equipeService
      .updateEquipe(id, equipe)
      .subscribe(() => this.getEquipes());
      this.showUpdateForm = false;
  }

  deleteEquipe(e: Equipe): void {
    console.log('hehehe' + e.capaciteStade);
    this.equipeService.deleteEquipe(e.id).subscribe(() => this.getEquipes());
  }
}
