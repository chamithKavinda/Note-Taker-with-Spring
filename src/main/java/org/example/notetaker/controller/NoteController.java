package org.example.notetaker.controller;

import lombok.RequiredArgsConstructor;
import org.example.notetaker.service.NoteService;
import org.example.notetaker.dto.NoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/note")
@RequiredArgsConstructor
public class NoteController {
    @Autowired
    private final NoteService noteService;

    //Todo: CRUD of the note
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDTO note) {
        //Todo: Handle with service
        var saveData = noteService.saveNote(note);
        return ResponseEntity.ok(saveData);
    }

    @GetMapping(value = "allnotes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes(){
        return null;
    }

    @GetMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO getNote(@PathVariable ("noteId") String noteId)  {
        return noteService.getSelectedNote(noteId);
    }

    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateNote(@PathVariable ("noteId") String noteId, @RequestBody NoteDTO note) {
        System.out.println(noteId);
        System.out.println(note+ " Updated");
    }
    @DeleteMapping(value ="/{noteId}" )
    public void deleteNote(@PathVariable ("noteId") String noteId) {
        System.out.println(noteId + " Deleted");
    }
}
