package ro.fortech.carfleet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.mapper.CarMapper;
import ro.fortech.carfleet.model.Car;
import ro.fortech.carfleet.model.Owner;
import ro.fortech.carfleet.repository.CarRepository;
import ro.fortech.carfleet.repository.OwnerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

  private final CarMapper carMapper;
  private final CarRepository carRepository;
  private final OwnerRepository ownerRepository;

  @Autowired
  public CarService(
      CarMapper carMapper, CarRepository carRepository, OwnerRepository ownerRepository) {
    this.carMapper = carMapper;
    this.carRepository = carRepository;
    this.ownerRepository = ownerRepository;
  }

  public void saveCar(CarDto car) {
    carRepository.save(carMapper.carDtoToCar(car));
  }

  public List<Car> getAllCars() {
    return carRepository.findAll();
  }

  public Optional<Car> getCarById(int id) {
    return carRepository.findById(id);
  }

  public void deleteCarById(int id) {
    carRepository.deleteById(id);
  }

  public void updateCarById(CarDto car) {
    carRepository.save(carMapper.carDtoToCar(car));
  }

  public void assignOwnerToCar(int carId, int ownerId) {
    Car car = carRepository.findById(carId).get();
    Owner owner = ownerRepository.findById(ownerId).get();
    car.assignOwner(owner);
    carRepository.save(car);
  }
}
