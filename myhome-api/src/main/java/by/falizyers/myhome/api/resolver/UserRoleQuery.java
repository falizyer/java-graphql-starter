package by.falizyers.myhome.api.resolver;

import by.falizyers.myhome.core.dao.UserRolesCRUDService;
import by.falizyers.myhome.core.entity.UserRolesEntity;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRoleQuery implements GraphQLQueryResolver {

    @Autowired
    private UserRolesCRUDService userRolesCRUDService;

    public List<UserRolesEntity> getUserRoles(int count, int offset) {
        return count == -1
                ? userRolesCRUDService.getResourceList()
                : userRolesCRUDService.getResourceList().subList(offset, offset + count);
    }

    public UserRolesEntity getUserRole(Long roleId) {
        return userRolesCRUDService.getResource(roleId);
    }
}
