package by.falizyers.myhome.core.converter;

import by.falizyers.myhome.core.dto.UserPermissionsDto;
import by.falizyers.myhome.core.entity.UserPermissionsEntity;
import org.springframework.stereotype.Service;

@Service
public class UserPermissionsConverter extends AbstractConverter<UserPermissionsEntity, UserPermissionsDto> {

    @Override
    public UserPermissionsDto newDto() {
        return new UserPermissionsDto();
    }

    @Override
    public UserPermissionsEntity newEntity() {
        return new UserPermissionsEntity();
    }

    @Override
    public UserPermissionsDto convertToDto(UserPermissionsEntity entity, UserPermissionsDto dto) {
        if (dto == null) {
            dto = newDto();
        }

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());

        return dto;
    }

    @Override
    public UserPermissionsEntity convertFromDto(UserPermissionsEntity entity, UserPermissionsDto dto) {
        if (entity == null) {
            entity = newEntity();
        }

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setType(dto.getType());

        return entity;
    }
}
