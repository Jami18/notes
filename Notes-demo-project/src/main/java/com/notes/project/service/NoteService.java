package com.notes.project.service;

import com.notes.project.entity.Notes;
import com.notes.project.reposotory.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Notes> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Notes> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Notes saveNote(Notes note) {
        return noteRepository.save(note);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
