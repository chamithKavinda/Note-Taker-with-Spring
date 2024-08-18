package org.example.notetaker.controller;

import org.example.notetaker.dto.Note;
import org.example.notetaker.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/note")
public class NoteController {
    //Todo: CRUD of the note
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody Note note) {
        //Todo: Handle with BO
        note.setNoteId(AppUtil.createNoteId());
        System.out.println(note);
        return ResponseEntity.ok("Note created successfully");
    }
}
