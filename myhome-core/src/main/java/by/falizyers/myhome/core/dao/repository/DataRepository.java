package by.falizyers.myhome.core.dao.repository;

import by.falizyers.myhome.core.entity.PersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DataRepository<ENT extends PersistentEntity<ID>, ID>
        extends JpaRepository<ENT, ID>,
        JpaSpecificationExecutor<ENT>,
        CrudRepository<ENT, ID> {
}
