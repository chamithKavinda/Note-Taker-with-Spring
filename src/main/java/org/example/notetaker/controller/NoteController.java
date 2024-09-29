package org.example.notetaker.controller;

import lombok.RequiredArgsConstructor;
import org.example.notetaker.customObj.NoteResponse;
import org.example.notetaker.exception.DataPersistFailedException;
import org.example.notetaker.exception.NoteNotFound;
import org.example.notetaker.service.NoteService;
import org.example.notetaker.impl.NoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cc")
@RequiredArgsConstructor
public class NoteController {

    @Autowired
    private final NoteService noteService;

    //Todo: CRUD of the note
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createNote(@RequestBody NoteDTO note) {
        if (note == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                noteService.saveNote(note);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping(value = "allnotes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes(){
        return null;
    }

    @GetMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteResponse getSelectedNote(@PathVariable ("noteId") String noteId){
        return noteService.getSelectedNote(noteId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateNote(@PathVariable ("noteId") String noteId, @RequestBody NoteDTO note) {
        try {
            noteService.updateNote(noteId, note);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NoteNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value ="/{noteId}" )
    public ResponseEntity<String> deleteNote(@PathVariable ("noteId") String noteId) {
        return noteService.deleteNote(noteId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
