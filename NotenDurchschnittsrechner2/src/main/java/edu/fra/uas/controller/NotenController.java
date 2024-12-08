package edu.fra.uas.controller;

//import org.springframework.stereotype.Controller;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.Collection;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;

import edu.fra.uas.model.Note;
import edu.fra.uas.service.NotenService;



@RestController
@RequestMapping("/api")
public class NotenController {

    private final Logger log = org.slf4j.LoggerFactory.getLogger(NotenController.class);

    @Autowired
    NotenService notenService;

    @GetMapping(value ="/noten", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CollectionModel<Note>> list(@RequestParam(required = false) Integer page) {
        log.debug("<-- list() is called");
        Collection<Note> noten = notenService.getAllNoten();
        if (noten.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            Link link = linkTo(methodOn(NotenController.class).list(null)).withSelfRel();
            CollectionModel<Note> result = CollectionModel.of(noten).add(link);
            for (Note note : result) {
                Link selfLink = linkTo(NotenController.class).slash("/users/" + note.getNotenId()).withSelfRel();
                note.add(selfLink);
            }
            return new ResponseEntity<>(CollectionModel.of(noten), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/noten/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> find(@PathVariable("id") Long notenId){
        log.debug("<-- find() is called");
        Note n = notenService.getNoteById(notenId);
        if (n==null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<Note>(n, HttpStatus.OK);
    }

    @PostMapping(value= "/noten", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody Note n) {
        log.debug("<-- add() is called");
        n = notenService.createNote(n);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(URI.create("restful/noten/" + n.getNotenId()));
        return new ResponseEntity<Note>(n, header, HttpStatus.CREATED);
    }
    
    

}
