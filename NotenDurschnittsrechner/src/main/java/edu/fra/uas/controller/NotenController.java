package edu.fra.uas.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import edu.fra.uas.model.Note;
import edu.fra.uas.service.NotenService;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotenController {

    private static final Logger log = LoggerFactory.getLogger(NotenController.class);

    @Autowired
    private NotenService notenListe;

    @RequestMapping
    public String get() {
        log.debug("get() is called");
        return "index.html";
    }

    @PostMapping({ "/add" })
    public String add(@RequestParam double notenwert, @RequestParam String modul, Model model)
            throws MissingServletRequestParameterException {
        log.debug("--> add is called");
        Note n = new Note();
        n.setModul(modul);
        n.setNotenwert(notenwert);
        notenListe.addNote(n);
        model.addAttribute("Note", n);
        return "add.html";
    }

    @GetMapping("/calculate")
    public String calculate(Model m) {
        double durchschnitt = notenListe.getDurschnitt();
        m.addAttribute("Durchschnitt", durchschnitt);
        return "calculate.html";
    }

    public void addNote(Note note) {
        notenListe.addNote(note);
        log.info("--> Note " + note + " has been added");
    }

    public double fetchDurchschnitt() {
        log.info("--> Durschnitt is :" + notenListe.getDurschnitt());
        return notenListe.getDurschnitt();
    }

}
