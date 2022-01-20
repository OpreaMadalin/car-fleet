package ro.fortech.carfleet.mapper;

import org.mapstruct.Mapper;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.model.Car;

@Mapper(componentModel = "spring")
public interface CarMapper {
  CarDto carToDto(Car car);
}
