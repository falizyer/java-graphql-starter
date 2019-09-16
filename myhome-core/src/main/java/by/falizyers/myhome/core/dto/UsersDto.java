package by.falizyers.myhome.core.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UsersDto implements PersistentEntityDto<Long>, TrackUpdateEntityDto {

    @ReadOnlyDtoAttribute
    private Long id;

    private String email;

    private String password;

    private Long cellPhone;

    private Long creationDate;

    private Long updateDate;

    private List<UserRolesDto> roles;
}
