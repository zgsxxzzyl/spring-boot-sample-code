package com.example.mapstruct;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAssembler {

    UserDTO toUserDTO(UserEntity userEntity);

    List<UserDTO> toUserDTOs(List<UserEntity> userEntities);
}
