package com.example.mapstruct;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dto.PageVO;
import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserAssembler {

    UserDTO toUserDTO(UserEntity userEntity);

    List<UserDTO> toUserDTOs(List<UserEntity> userEntities);

    PageVO<UserDTO> pageToVo(Page<UserEntity> page);
}
