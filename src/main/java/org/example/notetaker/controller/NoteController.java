package org.example.notetaker.controller;

import org.example.notetaker.dto.NoteDTO;
import org.example.notetaker.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/note")
public class NoteController {
    //Todo: CRUD of the note
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDTO noteDTO) {
        //Todo: Handle with BO
        noteDTO.setNoteId(AppUtil.createNoteId());
        System.out.println(noteDTO);
        return ResponseEntity.ok("Note created successfully");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes(){
        return null;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO getNote(@PathVariable ("noteId") String noteId)  {
        System.out.println(noteId);
        return null;
    }
}
