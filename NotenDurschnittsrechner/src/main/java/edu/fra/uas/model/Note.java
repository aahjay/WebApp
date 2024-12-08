package edu.fra.uas.model;

import java.io.Serializable;
import org.slf4j.*;

import org.slf4j.LoggerFactory;

public class Note implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(Note.class);

    private double notenwert;
    private long notenID;
    private String modul;

    public Note() {
        log.debug("--> note without values has been created");   
    }

    public Note(double notenwert, long notenID, String modul) {
        this.notenwert = notenwert;
        this.notenID = notenID;
        this.modul = modul;
    }

    public double getNotenwert() {
        return notenwert;
    }

    public void setNotenwert(double notenwert) {
        this.notenwert = notenwert;
    }

    public double getNotenID() {
        return notenID;
    }

    public void setNotenID(long notenID) {
        this.notenID = notenID;
    }

    public String getModul() {
        return modul;
    }

    public void setModul(String modul) {
        this.modul = modul;
    }


}
