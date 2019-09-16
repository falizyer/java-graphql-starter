package by.falizyers.myhome.core.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserRolesDto implements PersistentEntityDto<Long> {

    @ReadOnlyDtoAttribute
    private Long id;

    private String name;

    private Long creationDate;

    private Long updateDate;

    private List<UserPermissionsDto> permissions;
}
