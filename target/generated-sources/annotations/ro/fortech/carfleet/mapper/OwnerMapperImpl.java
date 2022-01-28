package ro.fortech.carfleet.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ro.fortech.carfleet.dto.OwnerDto;
import ro.fortech.carfleet.model.Owner;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-28T16:35:20+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class OwnerMapperImpl implements OwnerMapper {

    @Override
    public Owner ownerDtoToOwner(OwnerDto ownerDto) {
        if ( ownerDto == null ) {
            return null;
        }

        Owner owner = new Owner();

        owner.setId( ownerDto.getId() );
        owner.setAge( ownerDto.getAge() );
        owner.setName( ownerDto.getName() );

        return owner;
    }

    @Override
    public OwnerDto ownerToOwnerDto(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerDto ownerDto = new OwnerDto();

        ownerDto.setId( owner.getId() );
        ownerDto.setAge( owner.getAge() );
        ownerDto.setName( owner.getName() );

        return ownerDto;
    }

    @Override
    public List<OwnerDto> ownerToOwnerDtoList(List<Owner> owner) {
        if ( owner == null ) {
            return null;
        }

        List<OwnerDto> list = new ArrayList<OwnerDto>( owner.size() );
        for ( Owner owner1 : owner ) {
            list.add( ownerToOwnerDto( owner1 ) );
        }

        return list;
    }
}
