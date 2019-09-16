package by.falizyers.myhome.core.dao;

import by.falizyers.myhome.core.converter.UsersConverter;
import by.falizyers.myhome.core.dao.repository.UsersRepository;
import by.falizyers.myhome.core.dto.UsersDto;
import by.falizyers.myhome.core.entity.UsersEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UsersCRUDService extends AbstractCRUDService<UsersEntity, UsersDto, Long> {

    @Autowired
    private UsersConverter usersConverter;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UsersConverter getConverter() {
        return usersConverter;
    }

    @Override
    public UsersRepository getRepository() {
        return usersRepository;
    }
}
