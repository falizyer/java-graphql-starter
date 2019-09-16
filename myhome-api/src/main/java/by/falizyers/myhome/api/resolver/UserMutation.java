package by.falizyers.myhome.api.resolver;

import by.falizyers.myhome.core.dao.UsersCRUDService;
import by.falizyers.myhome.core.dto.UsersDto;
import by.falizyers.myhome.core.entity.UsersEntity;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UsersCRUDService usersCRUDService;

    public UsersEntity createUser(UsersDto dto) {
        return usersCRUDService.saveResource(dto);
    }

    public UsersEntity updateUser(Long userId, UsersDto dto) {
        return usersCRUDService.updateResource(userId, dto);
    }

    public UsersEntity deleteUser(Long userId) {
        return usersCRUDService.deleteResource(userId);
    }
}
