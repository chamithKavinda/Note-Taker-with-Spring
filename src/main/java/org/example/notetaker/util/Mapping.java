package org.example.notetaker.util;

import org.example.notetaker.impl.NoteDTO;
import org.example.notetaker.impl.UserDTO;
import org.example.notetaker.entity.NoteEntity;
import org.example.notetaker.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //matters of NoteEntity and DTO
    public NoteDTO convertToDTO(NoteEntity note) {
        return modelMapper.map(note, NoteDTO.class);
    }
    public NoteEntity convertToEntity(NoteDTO dto) {
        return modelMapper.map(dto, NoteEntity.class);
    }
    public List<NoteDTO> convertToDTO(List<NoteEntity> notes) {

        return modelMapper.map(notes, new TypeToken<List<NoteDTO>>() {}.getType());
    }

    //User matters mapping
    public UserEntity convertToUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDTO convertToUserDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public List<UserDTO> convertUserToDTOList(List<UserEntity> userEntities) {
        return modelMapper.map(userEntities, new TypeToken<List<UserDTO>>() {}.getType());
    }
}
