package service;

import exception.NoteNotFoundException;
import model.Note;
import org.springframework.stereotype.Service;
import repository.NoteRepository;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() { return noteRepository.findAll(); }
    public Note getNoteById(Long Id) {
        return noteRepository.findById(Id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found with id " + Id));
    }
    public Note createNote(Note note){ return noteRepository.save(note); }
    public Note updateNote(Long Id, Note noteBody){
        Note noteToBeUpdated = getNoteById(Id);
        noteToBeUpdated.setTitle(noteBody.getTitle());
        noteToBeUpdated.setDescription(noteBody.getDescription());

        return noteRepository.save(noteToBeUpdated);
    }
    public void deleteNote(Long Id) { noteRepository.deleteById(Id); }

}
