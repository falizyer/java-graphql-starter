package by.falizyers.myhome.core.dao.repository;

import by.falizyers.myhome.core.entity.UsersEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends DataRepository<UsersEntity, Long> {
}
