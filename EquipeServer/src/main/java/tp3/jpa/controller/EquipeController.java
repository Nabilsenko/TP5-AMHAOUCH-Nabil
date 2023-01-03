package tp3.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp3.jpa.dao.EquipeRepository;
import tp3.jpa.model.Equipe;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EquipeController {

    @Autowired
    private EquipeRepository dao;

    @Value("${me}")
    private String me;

    @GetMapping(value = "/cestqui")
    public String getName() {
        return me;
    }

    @GetMapping(value = "/equipes",produces = "application/json")
    public Iterable<Equipe> getLesEquipes() {
        System.out.println("test");
        return dao.findAll();
    }

    @GetMapping(value = "/equipes/{id}",produces = "application/json")
    public Equipe getEquipe(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping(value = "/equipes", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addEquipe(@RequestBody Equipe e) {
        dao.save(e);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping (value = "/equipes/{id}")
    public void updateEquipe(@RequestBody Equipe e, @PathVariable int id) {
        Equipe eq = dao.findById(id);
        eq = e;
        dao.save(e);
    }

    @DeleteMapping(value = "/equipes/{id}" , consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deleteEquipe(@PathVariable int id) {
        dao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
