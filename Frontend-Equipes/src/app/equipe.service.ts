import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Equipe } from './types/equipe';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EquipeService {
  private baseUrl = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  // Method to retrieve a list of all equipes
  getEquipes(): Observable<Equipe[]> {
    return this.http.get<Equipe[]>(`${this.baseUrl}/equipes`);
  }

  getEquipe(id: string): Observable<Equipe> {
    return this.http.get<Equipe>(`${this.baseUrl}/equipes/${id}`);
  }

  createEquipe(equipe: Equipe): Observable<Equipe> {
    return this.http.post<Equipe>(`${this.baseUrl}/equipes`, equipe);
  }

  updateEquipe(id: number, equipe: Equipe): Observable<Equipe> {
    return this.http.put<Equipe>(`${this.baseUrl}/equipes/${id}`, equipe);
  }

  deleteEquipe(id: number): Observable<Equipe> {
    return this.http.delete<Equipe>(`${this.baseUrl}/equipes/${id}`);
  }
}