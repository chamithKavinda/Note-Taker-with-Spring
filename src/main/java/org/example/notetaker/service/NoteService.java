package org.example.notetaker.service;

import org.example.notetaker.dto.NoteDTO;

import java.util.List;

public interface NoteService{
    String saveNote(NoteDTO noteDTO);
    boolean updateNote(String noteId, NoteDTO noteDTO);
    boolean deleteNote(String noteId);
    NoteDTO getSelectedNote(String noteId);
    List<NoteDTO> getAllNotes();
}
