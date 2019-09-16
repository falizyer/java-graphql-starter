package by.falizyers.myhome.api.resolver;

import by.falizyers.myhome.core.dao.UsersCRUDService;
import by.falizyers.myhome.core.entity.UsersEntity;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UsersCRUDService usersCRUDService;

    public List<UsersEntity> getUsers(int count, int offset) {
        return count == -1
                ? usersCRUDService.getResourceList()
                : usersCRUDService.getResourceList().subList(offset, offset + count);
    }

    public UsersEntity getUser(Long userId) {
        return usersCRUDService.getResource(userId);
    }
}
