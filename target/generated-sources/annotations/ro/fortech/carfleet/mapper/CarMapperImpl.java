package ro.fortech.carfleet.mapper;

import org.springframework.stereotype.Component;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.dto.CarDto.CarDtoBuilder;
import ro.fortech.carfleet.dto.OwnerDto;
import ro.fortech.carfleet.model.Car;
import ro.fortech.carfleet.model.Owner;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T16:40:59+0200",
    comments =
        "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)")
@Component
public class CarMapperImpl implements CarMapper {

  @Override
  public CarDto carToDto(Car car) {
    if (car == null) {
      return null;
    }

    CarDtoBuilder carDto = CarDto.builder();

    carDto.id(car.getId());
    carDto.brand(car.getBrand());
    carDto.model(car.getModel());
    carDto.owner(ownerToOwnerDto(car.getOwner()));

    return carDto.build();
  }

  protected OwnerDto ownerToOwnerDto(Owner owner) {
    if (owner == null) {
      return null;
    }

    OwnerDto ownerDto = new OwnerDto();

    ownerDto.setAge(owner.getAge());
    ownerDto.setName(owner.getName());

    return ownerDto;
  }
}
