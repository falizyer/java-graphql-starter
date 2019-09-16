package by.falizyers.myhome.core.converter;

import by.falizyers.myhome.core.dto.UsersDto;
import by.falizyers.myhome.core.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersConverter extends AbstractConverter<UsersEntity, UsersDto> {

    @Autowired
    private UserRolesConverter userRolesConverter;

    @Override
    public UsersDto newDto() {
        return new UsersDto();
    }

    @Override
    public UsersEntity newEntity() {
        return new UsersEntity();
    }

    @Override
    public UsersDto convertToDto(UsersEntity entity, UsersDto dto) {
        if (dto == null) {
            dto = newDto();
        }

        dto.setId(entity.getId());
        dto.setCellPhone(entity.getCellPhone());
        dto.setEmail(entity.getEmail());
        dto.setCreationDate(entity.getCreationDate().getTime());
        dto.setUpdateDate(entity.getUpdateDate().getTime());

        if (entity.getRoles() != null) {
            dto.setRoles(userRolesConverter.convertFromEntityList(entity.getRoles()));
        }

        return dto;
    }

    @Override
    public UsersEntity convertFromDto(UsersEntity entity, UsersDto dto) {
        if (entity == null) {
            entity = newEntity();
        }

        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setCellPhone(dto.getCellPhone());

        entity.setRoles(userRolesConverter.convertFromDtoList(dto.getRoles()));

        return entity;
    }
}
