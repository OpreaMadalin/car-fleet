package ro.fortech.carfleet.mapper;

import org.mapstruct.Mapper;
import ro.fortech.carfleet.dto.OwnerDto;
import ro.fortech.carfleet.model.Owner;

@Mapper(componentModel = "spring")
public interface OwnerMapper {
  Owner ownerDtoToOwner(OwnerDto ownerDto);
}
