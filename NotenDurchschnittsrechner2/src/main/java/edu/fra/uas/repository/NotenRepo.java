package edu.fra.uas.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import edu.fra.uas.model.Note;

@Repository
public class NotenRepo extends HashMap<Long, Note> {

}
