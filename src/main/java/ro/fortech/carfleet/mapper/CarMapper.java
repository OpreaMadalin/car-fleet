package ro.fortech.carfleet.mapper;

import org.mapstruct.Mapper;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.dto.UpdateCarDto;
import ro.fortech.carfleet.model.Car;
import ro.fortech.carfleet.service.business.UpdateCar;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
  Car carDtoToCar(CarDto carDto);

  CarDto carToCarDto(Car car);

  List<CarDto> listCarToListCarDto(List<Car> car);

  UpdateCar updateCarDtoToUpdateCar(UpdateCarDto updateCarDto);
}
