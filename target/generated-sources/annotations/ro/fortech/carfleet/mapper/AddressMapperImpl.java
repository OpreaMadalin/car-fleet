package ro.fortech.carfleet.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ro.fortech.carfleet.dto.AddressDto;
import ro.fortech.carfleet.model.Address;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-31T17:55:52+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDto.getId() );
        address.setStreetNumber( addressDto.getStreetNumber() );
        address.setStreetName( addressDto.getStreetName() );
        address.setCountry( addressDto.getCountry() );

        return address;
    }

    @Override
    public List<AddressDto> addressToAddressDto(List<Address> address) {
        if ( address == null ) {
            return null;
        }

        List<AddressDto> list = new ArrayList<AddressDto>( address.size() );
        for ( Address address1 : address ) {
            list.add( addressToAddressDto1( address1 ) );
        }

        return list;
    }

    protected AddressDto addressToAddressDto1(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( address.getId() );
        addressDto.setStreetNumber( address.getStreetNumber() );
        addressDto.setStreetName( address.getStreetName() );
        addressDto.setCountry( address.getCountry() );

        return addressDto;
    }
}
