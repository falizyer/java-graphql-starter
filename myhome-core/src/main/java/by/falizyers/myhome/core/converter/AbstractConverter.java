package by.falizyers.myhome.core.converter;

import by.falizyers.myhome.core.dto.PersistentEntityDto;
import by.falizyers.myhome.core.entity.PersistentEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractConverter<ENT extends PersistentEntity, DTO extends PersistentEntityDto> {

    public abstract ENT newEntity();

    public abstract DTO newDto();

    public abstract ENT convertFromDto(ENT ent, DTO dto);

    public abstract DTO convertToDto(ENT ent, DTO dto);

    public List<ENT> convertFromDtoList(List<DTO> dtoList) {
        Iterator<DTO> iterator = dtoList.iterator();
        List<ENT> entList = new ArrayList<ENT>();
        while (iterator.hasNext()) {
            DTO dto = iterator.next();
            entList.add(convertFromDto(null, dto));
        }
        return entList;
    }

    public List<DTO> convertFromEntityList(List<ENT> entList) {
        Iterator<ENT> iterator = entList.iterator();
        List<DTO> dtoList = new ArrayList<DTO>();
        while (iterator.hasNext()) {
            ENT ent = iterator.next();
            dtoList.add(convertToDto(ent, null));
        }
        return dtoList;
    }
}
