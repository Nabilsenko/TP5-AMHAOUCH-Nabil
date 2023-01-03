package tp3.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.UUID;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String pays;
    private int capaciteStade;
    private Date dateFondation;

    public Equipe() {
    }

    public Equipe(int id, String nom, String pays, int capaciteStade, Date dateFondation) {
        this.id = id;
        this.nom = nom;
        this.pays = pays;
        this.capaciteStade = capaciteStade;
        this.dateFondation = dateFondation;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPays() {
        return pays;
    }

    public int getCapaciteStade() {
        return capaciteStade;
    }

    public Date getDateFondation() {
        return dateFondation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setCapaciteStade(int capaciteStade) {
        this.capaciteStade = capaciteStade;
    }

    public void setDateFondation(Date dateFondation) {
        this.dateFondation = dateFondation;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", pays='" + pays + '\'' +
                ", capaciteStade=" + capaciteStade +
                ", dateFondation=" + dateFondation +
                '}';
    }
}
