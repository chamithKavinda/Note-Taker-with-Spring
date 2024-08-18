package org.example.notetaker.bo;

import org.example.notetaker.dto.NoteDTO;
import org.example.notetaker.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public final class NoteBOIMPL implements NoteBO{
    @Override
    public String saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNoteId());
        System.out.println(noteDTO);
        return "Saved successfully in BO layer";
    }

    @Override
    public boolean updateNote(String noteId, NoteDTO noteDTO) {
        return false;
    }

    @Override
    public boolean deleteNote(String noteId) {
        return false;
    }

    @Override
    public NoteDTO getSelectedNote(String noteId) {
        return null;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return List.of();
    }
}
