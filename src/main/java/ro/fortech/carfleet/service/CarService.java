package ro.fortech.carfleet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.carfleet.model.Car;
import ro.fortech.carfleet.model.Owner;
import ro.fortech.carfleet.repository.CarRepository;
import ro.fortech.carfleet.service.business.UpdateCar;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

  private final CarRepository carRepository;
  private final OwnerService ownerService;

  @Autowired
  public CarService(CarRepository carRepository, OwnerService ownerService) {
    this.carRepository = carRepository;
    this.ownerService = ownerService;
  }

  public void saveCar(Car car) {
    carRepository.save(car);
  }

  public List<Car> findCars(String brand) {
    return Optional.ofNullable(brand).isPresent()
        ? carRepository.findByBrand(brand)
        : carRepository.findAll();
  }

  public Optional<Car> findCarById(int id) {
    return carRepository.findById(id);
  }

  public void deleteCarById(int id) {
    carRepository.deleteById(id);
  }

  public void updateCarById(UpdateCar updateCar) {
    Optional<Car> car = findCarById(updateCar.getId());
    if (car.isPresent()) {
      car.get().setModel(updateCar.getModel());
      car.get().setBrand(updateCar.getBrand());
    }
    if (updateCar.hasOwnerId()) {
      Optional<Owner> ownerOptional = ownerService.findById(updateCar.getOwnerId());
      ownerOptional.ifPresent(owner -> car.ifPresent(value -> value.setOwner(owner)));
    }
    car.ifPresent(carRepository::save);
  }
}
