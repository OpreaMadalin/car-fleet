package ro.fortech.carfleet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.carfleet.repository.Database;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.mapper.CarMapper;
import ro.fortech.carfleet.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

  private final Database database;
  private final CarMapper carMapper;

  @Autowired
  public CarServiceImpl(Database database, CarMapper carMapper) {
    this.database = database;
    this.carMapper = carMapper;
  }

  @Override
  public CarDto saveCar(Car car) {
    return database.addCar(carMapper.carToDto(car));
  }

  @Override
  public List<CarDto> getAllCars() {
    return database.getAllCars();
  }

  @Override
  public CarDto getCarById(int id) {
    return database.getCarById(id);
  }

  @Override
  public CarDto deleteCarById(int id) {
    return database.deleteCarById(id);
  }

  @Override
  public CarDto updateCarById(int id, Car car) {
    return database.updateCarById(carMapper.carToDto(car));
  }
}
