package ro.fortech.carfleet.mapper;

import org.mapstruct.Mapper;
import ro.fortech.carfleet.dto.AddressDto;
import ro.fortech.carfleet.model.Address;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

  Address addressDtoToAddress(AddressDto addressDto);

  List<AddressDto> addressListToAddressDtoList(List<Address> addressDto);
}
