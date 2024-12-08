package edu.fra.uas.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import edu.fra.uas.model.Note;

@Service
public class NotenService {

    private ArrayList<Note> Notenliste = new ArrayList<>();

    public ArrayList<Note> getNotenliste() {
        return Notenliste;
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
    }

    public void addNote(Note note) {
        Notenliste.add(note);
    }

    public double getDurschnitt() {
        double sum = 0;
        for (Note n : Notenliste) {
            sum += n.getNotenwert();
        }
        return sum / Notenliste.size();
    }

}
