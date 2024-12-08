package edu.fra.uas.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NotenDurchschitt {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotenDurchschitt.class);

    private ArrayList<Double> notenliste = new ArrayList<Double>();

    public void addNote(double note) {
        notenliste.add(note);
        LOGGER.info("<-- Note wurde geaddet");
    }

    public void setNote(int i , double note) {
        notenliste.set(i, note);
    }

    public double getNote(int i) {
       return notenliste.get(i);
    }

    public double getDurchschnitt() {
        double sum = 0;
        for (Double i : notenliste) {
           sum += i; 
        }
        double d = sum / notenliste.size();
        LOGGER.info("<-- Durchschnitt has been calculated");
        return d;
    }

    
    
}
