package edu.fra.uas.controller;

import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.model.Note;
import edu.fra.uas.service.NotenService;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.hateoas.*;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/noten")
public class ApiController {
    
    private static final Logger log = LoggerFactory.getLogger(NotenController.class);

    @Autowired
    private NotenService notenListe;

    @PostMapping("/note")
    public ResponseEntity<EntityModel<Note>> add(
            @RequestParam("notenwert") double notenwert,
            @RequestParam("modul") String modul) {
    
        log.debug("--> add is called");
        Note n = new Note();
        n.setModul(modul);
        n.setNotenwert(notenwert);
        notenListe.addNote(n);
        
        EntityModel<Note> resource = EntityModel.of(n);
        resource.add(Link.of("/api/noten/" + n.getNotenID()).withSelfRel()); // Link zur Ressource selbst
        resource.add(Link.of("/api/noten").withRel("all-noten")); // Link zur Liste aller Noten

        return ResponseEntity.created(URI.create("/api/notes/" + n.getNotenID())).body(resource);
    }

    @GetMapping("/durchschnitt", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<Double>> fetchDurchschnitt() {
        log.info("--> Durschnitt is :" + notenListe.getDurschnitt());
        double durchschnitt = notenListe.getDurschnitt();
        EntityModel<Double> resource = EntityModel.of(durchschnitt);
        resource.add(Link.of("/api/noten/durchschnitt").withSelfRel());
        resource.add(Link.of("/api/notes").withRel("all-notes")); 
        return ResponseEntity.ok(resource);
    }

}
