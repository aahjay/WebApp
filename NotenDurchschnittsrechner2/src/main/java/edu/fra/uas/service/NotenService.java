package edu.fra.uas.service;

import java.util.ArrayList;
import java.util.Collection;
//import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fra.uas.model.Note;
import edu.fra.uas.repository.NotenRepo;

@Service
public class NotenService {

    @Autowired
    private NotenRepo notenRepo;

    private ArrayList<Note> Notenliste = new ArrayList<>();

    public ArrayList<Note> getNotenliste() {
        return Notenliste;
    }

    public Note createNote(Note n){
        Notenliste.add(n);
        notenRepo.put(n.getNotenId(), n);
        return notenRepo.get(n.getNotenId());
    }

    public void setNotenliste(ArrayList<Note> notenliste) {
        Notenliste = notenliste;
    }

    public double getNotenwert(int index) {
        Note n = Notenliste.get(index);
        return n.getNotenwert();
    }

    public void setNote(int index, Note note) {
        Notenliste.set(index, note);
        notenRepo.replace(note.getNotenId(), note);
    }

    public void addNote(Note note) {
        Notenliste.add(note);
        notenRepo.put(note.getNotenId(), note);
    }

    public double getDurschnitt() {
        double sum = 0;
        for (Note n : Notenliste) {
            sum += n.getNotenwert();
        }
        return sum / Notenliste.size();
    }

    public Collection<Note> getAllNoten(){
        return notenRepo.values();
    }

    public Note getNoteById(Long id){
        return notenRepo.get(id);
    }

}
