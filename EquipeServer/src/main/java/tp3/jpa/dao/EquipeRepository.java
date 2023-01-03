package tp3.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tp3.jpa.model.Equipe;

import java.util.ArrayList;


public interface EquipeRepository extends CrudRepository<Equipe, Integer> {
    Iterable<Equipe> findByNom(String nom);
    Equipe findById(int id);
    void deleteById(int id);

}
