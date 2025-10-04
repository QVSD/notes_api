package com.example.notes.controller;

import com.example.notes.model.Note;
import com.example.notes.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService){ this.noteService = noteService; }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() { return ResponseEntity.ok(noteService.getAllNotes()); }
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) { return ResponseEntity.ok(noteService.getNoteById(id)); }
    @PostMapping("/{id}")
    public ResponseEntity<Note> createNote(@RequestBody Note note){ return ResponseEntity.ok(noteService.createNote(note)); }
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) { return ResponseEntity.ok(noteService.updateNote(id, note)); }
    @DeleteMapping("{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}
