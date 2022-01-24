package ro.fortech.carfleet.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.dto.OwnerDto;
import ro.fortech.carfleet.model.Car;
import ro.fortech.carfleet.model.Car.CarBuilder;
import ro.fortech.carfleet.model.Owner;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-24T13:32:25+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public Car carDtoToCar(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        CarBuilder car = Car.builder();

        car.id( carDto.getId() );
        car.brand( carDto.getBrand() );
        car.model( carDto.getModel() );
        car.owner( ownerDtoToOwner( carDto.getOwner() ) );

        return car.build();
    }

    @Override
    public CarDto carToCarDto(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        carDto.setId( car.getId() );
        carDto.setBrand( car.getBrand() );
        carDto.setModel( car.getModel() );
        carDto.setOwner( ownerToOwnerDto( car.getOwner() ) );

        return carDto;
    }

    protected Owner ownerDtoToOwner(OwnerDto ownerDto) {
        if ( ownerDto == null ) {
            return null;
        }

        Owner owner = new Owner();

        owner.setId( ownerDto.getId() );
        owner.setAge( ownerDto.getAge() );
        owner.setName( ownerDto.getName() );

        return owner;
    }

    protected OwnerDto ownerToOwnerDto(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerDto ownerDto = new OwnerDto();

        ownerDto.setId( owner.getId() );
        ownerDto.setAge( owner.getAge() );
        ownerDto.setName( owner.getName() );

        return ownerDto;
    }
}
