package ro.fortech.carfleet.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ro.fortech.carfleet.dto.OwnerDto;
import ro.fortech.carfleet.model.Owner;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-25T14:38:46+0200",
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
}
