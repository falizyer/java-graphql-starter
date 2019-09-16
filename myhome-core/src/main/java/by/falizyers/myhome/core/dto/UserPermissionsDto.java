package by.falizyers.myhome.core.dto;

import lombok.Data;

@Data
public class UserPermissionsDto implements PersistentEntityDto<Long> {

    @ReadOnlyDtoAttribute
    private Long id;

    private String name;

    private UserPermissionsType type;
}
