package org.example.notetaker.service;

import jakarta.transaction.Transactional;
import org.example.notetaker.dao.NoteDao;
import org.example.notetaker.dto.NoteDTO;
import org.example.notetaker.entity.NoteEntity;
import org.example.notetaker.util.AppUtil;
import org.example.notetaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@Service
@Transactional
public  class NoteServiceIMPL implements NoteService {
    @Autowired
    private NoteDao noteDao;
    @Autowired
    private Mapping mapping;
    @Override
    public String saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNoteId());
        var noteEntity = mapping.convertToEntity(noteDTO);
        noteDao.save(noteEntity);
        return "Saved successfully in Service layer";
    }

    @Override
    public boolean updateNote(String noteId, NoteDTO incomeNoteDTO) {
        Optional<NoteEntity> tmpNoteEntity= noteDao.findById(noteId);
        if(!tmpNoteEntity.isPresent()){
            return false;
        }else {
            tmpNoteEntity.get().setNoteDesc(incomeNoteDTO.getNoteDesc());
            tmpNoteEntity.get().setNoteTitle(incomeNoteDTO.getNoteTitle());
            tmpNoteEntity.get().setCreateDate(incomeNoteDTO.getCreateDate());
            tmpNoteEntity.get().setPriorityLevel(incomeNoteDTO.getPriorityLevel());
        }
        return true;
    }

    @Override
    public boolean deleteNote(String noteId) {
//        noteDao.deleteById(noteId);
        if(noteDao.existsById(noteId)){
            noteDao.deleteById(noteId);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public NoteDTO getSelectedNote(String noteId) {
        return mapping.convertToDTO(noteDao.getReferenceById(noteId));
    }

    @Override
    public List<NoteDTO> getAllNotes() {
//        List<NoteEntity> getAllNotes = noteDao.findAll();
//        List<NoteDTO> noteDTOS = mapping.convertToDTO(getAllNotes);
//        return noteDTOS;

        return mapping.convertToDTO(noteDao.findAll());
    }
}
