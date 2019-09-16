package by.falizyers.myhome.core.dao;

import by.falizyers.myhome.core.converter.UserRolesConverter;
import by.falizyers.myhome.core.dao.repository.UserRolesRepository;
import by.falizyers.myhome.core.dto.UserRolesDto;
import by.falizyers.myhome.core.entity.UserRolesEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserRolesCRUDService extends AbstractCRUDService<UserRolesEntity, UserRolesDto, Long> {

    @Autowired
    private UserRolesConverter userRolesConverter;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public UserRolesConverter getConverter() {
        return userRolesConverter;
    }

    @Override
    public UserRolesRepository getRepository() {
        return userRolesRepository;
    }
}
