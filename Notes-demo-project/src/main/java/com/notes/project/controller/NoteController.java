package com.notes.project.controller;

import com.notes.project.entity.Notes;
import com.notes.project.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Notes> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public Notes getNoteById(@PathVariable("id") Long id) {
        return noteService.getNoteById(id).orElseThrow(() -> new RuntimeException("Notes not found"));
    }

//    @GetMapping("/new")
//    public Notes createNote( Notes notes) {
//        return noteService.saveNote(notes);
//    }

    @PostMapping("/create")
    public Notes createNote(@RequestBody Notes note) {
        return noteService.saveNote(note);
    }

//    @GetMapping("/{id}/edit")
//    public String showEditNoteForm(@PathVariable("id") Long id) {
//        noteService.getNoteById(id).ifPresent(note -> model.addAttribute("note", note));
//        return "note-form";
//    }

    @PostMapping("/{id}/edit")
    public Notes updateNote(@PathVariable("id") Long id, @RequestBody Notes note) {
        note.setId(id);
        return noteService.saveNote(note);
    }
    @GetMapping("/{id}/delete")
    public String deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNoteById(id);
        String messaage = "Note: " + id.toString() + " is successfully deleted!";
        return messaage;

    }
}
