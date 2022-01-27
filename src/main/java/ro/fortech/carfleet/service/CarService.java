package ro.fortech.carfleet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.carfleet.model.Car;
import ro.fortech.carfleet.model.Owner;
import ro.fortech.carfleet.repository.CarRepository;
import ro.fortech.carfleet.repository.OwnerRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

  public List<Car> findCars(String brand) {
    return Optional.ofNullable(brand).isPresent()
        ? carRepository.findByBrand(brand)
        : carRepository.findAll();
  }

  public List<Car> findCarById(int id) {
    return carRepository.findAllById(Collections.singleton(id));
  }

  public void deleteCarById(int id) {
    carRepository.deleteById(id);
  }

  public void updateCarById(Car car, int carId, Integer ownerId) {
    if (car == null) {
      updateCarOwner(carId, ownerId);
    } else if (ownerId == null) {
      updateBrandAndModel(carId, car.getBrand(), car.getModel());
    } else {
      updateCarOwner(carId, ownerId);
      updateBrandAndModel(carId, car.getBrand(), car.getModel());
    }
  }

  private void updateCarOwner(int carId, int ownerId) {
    Car car = carRepository.getById(carId);
    Owner owner = ownerRepository.getById(ownerId);
    car.updateCarOwner(owner);
    carRepository.save(car);
  }

  private void updateBrandAndModel(int id, String brand, String model) {
    Car car = carRepository.getById(id);
    car.updateBrandAndModel(brand, model);
    carRepository.save(car);
  }
}
