package by.falizyers.myhome.core.dao;

import by.falizyers.myhome.core.converter.AbstractConverter;
import by.falizyers.myhome.core.dao.repository.DataRepository;
import by.falizyers.myhome.core.dto.PersistentEntityDto;
import by.falizyers.myhome.core.entity.PersistentEntity;
import by.falizyers.myhome.core.entity.TrackUpdateEntity;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public abstract class AbstractCRUDService<ENT extends PersistentEntity<ID>,
        DTO extends PersistentEntityDto<ID>,
        ID extends Serializable> {

    public abstract DataRepository<ENT, ID> getRepository();

    public abstract AbstractConverter<ENT, DTO> getConverter();

    public ENT getResource(ID id) {
        Specification<ENT> specification = Specification.where((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id));
        Optional<ENT> opt = getRepository().findOne(specification);
        if (!opt.isPresent()) {
            throw new RuntimeException("find one failed");
        }
        return opt.get();
    }

    public List<ENT> getResourceList() {
        return this.getRepository().findAll();
    }

    public ENT saveResource(DTO dto) {
        ENT ent = getConverter().convertFromDto(null, dto);

        if (ent instanceof TrackUpdateEntity) {
            Date now = new Date();
            ((TrackUpdateEntity) ent).setCreationDate(now);
            ((TrackUpdateEntity) ent).setUpdateDate(now);
        }

        return getRepository().saveAndFlush(ent);
    }

    @Transactional
    public ENT updateResource(ID id, DTO dto) {
        ENT source = getRepository().getOne(id);
        ENT ent = getConverter().convertFromDto(source, dto);

        if (ent instanceof TrackUpdateEntity) {
            Date now = new Date();
            ((TrackUpdateEntity) ent).setUpdateDate(now);
        }

        return getRepository().saveAndFlush(ent);
    }

    public ENT deleteResource(ID id) {
        ENT ent = getRepository().getOne(id);
        getRepository().deleteById(id);
        return ent;
    }
}
