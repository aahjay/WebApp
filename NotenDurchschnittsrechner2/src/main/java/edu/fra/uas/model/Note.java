package edu.fra.uas.model;

import org.slf4j.*;
import org.springframework.hateoas.RepresentationModel;

public class Note extends RepresentationModel<Note> {
    
    private static final Logger log = LoggerFactory.getLogger(Note.class);

    private double notenwert;
    private String modulName;
    private long notenId;
    private static long counter = 1;
    
    public Note() {
        log.debug("---> Note without value has been created");
    }

    public Note(double notenwert, String modulName, long notenId) {
        this.notenwert = notenwert;
        this.modulName = modulName;
        this.notenId = counter;
        counter++;
    }

    public static Logger getLog() {
        return log;
    }

    public double getNotenwert() {
        return notenwert;
    }

    public void setNotenwert(double notenwert) {
        this.notenwert = notenwert;
    }

    public String getModulName() {
        return modulName;
    }

    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    public long getNotenId() {
        return notenId;
    }

    public void setNotenId(long notenId) {
        this.notenId = notenId;
    }
    
    
    
}
