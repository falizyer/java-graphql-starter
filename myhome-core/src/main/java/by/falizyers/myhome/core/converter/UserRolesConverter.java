package by.falizyers.myhome.core.converter;

import by.falizyers.myhome.core.dto.UserRolesDto;
import by.falizyers.myhome.core.entity.UserRolesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRolesConverter extends AbstractConverter<UserRolesEntity, UserRolesDto> {

    @Autowired
    private UserPermissionsConverter userPermissionsConverter;

    @Override
    public UserRolesDto newDto() {
        return new UserRolesDto();
    }

    @Override
    public UserRolesEntity newEntity() {
        return new UserRolesEntity();
    }

    @Override
    public UserRolesDto convertToDto(UserRolesEntity entity, UserRolesDto dto) {
        if (dto == null) {
            dto = newDto();
        }

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCreationDate(entity.getCreationDate().getTime());
        dto.setUpdateDate(entity.getUpdateDate().getTime());

        dto.setPermissions(userPermissionsConverter.convertFromEntityList(entity.getPermissions()));

        return dto;
    }

    @Override
    public UserRolesEntity convertFromDto(UserRolesEntity entity, UserRolesDto dto) {
        if (entity == null) {
            entity = newEntity();
        }

        entity.setId(dto.getId());

        return entity;
    }
}
