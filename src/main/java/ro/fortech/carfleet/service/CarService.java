package ro.fortech.carfleet.service;

import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.model.Car;

import java.util.List;

public interface CarService {

  CarDto saveCar(Car car);

  List<CarDto> getAllCars();

  CarDto getCarById(int id);

  CarDto deleteCarById(int id);

  CarDto updateCarById(int id, Car body);
}
