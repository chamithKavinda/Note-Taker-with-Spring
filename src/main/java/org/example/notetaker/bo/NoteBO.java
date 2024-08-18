package org.example.notetaker.bo;

import org.example.notetaker.dto.NoteDTO;

import java.util.List;

public sealed interface NoteBO permits NoteBOIMPL{
    String saveNote(NoteDTO noteDTO);
    boolean updateNote(String noteId, NoteDTO noteDTO);
    boolean deleteNote(String noteId);
    NoteDTO getSelectedNote(String noteId);
    List<NoteDTO> getAllNotes();
}
