package ro.fortech.carfleet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.carfleet.model.Car;
import ro.fortech.carfleet.model.Owner;
import ro.fortech.carfleet.repository.CarRepository;
import ro.fortech.carfleet.repository.OwnerRepository;

import java.util.Collections;
import java.util.List;

@Service
public class CarService {

  private final CarRepository carRepository;
  private final OwnerRepository ownerRepository;

  @Autowired
  public CarService(CarRepository carRepository, OwnerRepository ownerRepository) {
    this.carRepository = carRepository;
    this.ownerRepository = ownerRepository;
  }

  public void saveCar(Car car) {
    carRepository.save(car);
  }

  public List<Car> getAllCars() {
    return carRepository.findAll();
  }

  public List<Car> getCarById(int id) {
    return carRepository.findAllById(Collections.singleton(id));
  }

  public void deleteCarById(int id) {
    carRepository.deleteById(id);
  }

  public void updateCarById(Car car) {
    carRepository.save(car);
  }

  public void assignOwnerToCar(int carId, int ownerId) {
    Car car = carRepository.findById(carId).get();
    Owner owner = ownerRepository.findById(ownerId).get();
    car.assignOwner(owner);
    carRepository.save(car);
  }
}
