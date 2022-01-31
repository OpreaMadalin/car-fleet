package ro.fortech.carfleet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.carfleet.model.Car;
import ro.fortech.carfleet.model.Client;
import ro.fortech.carfleet.repository.CarRepository;
import ro.fortech.carfleet.service.business.UpdateCar;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

  private final CarRepository carRepository;
  private final ClientService clientService;

  @Autowired
  public CarService(CarRepository carRepository, ClientService clientService) {
    this.carRepository = carRepository;
    this.clientService = clientService;
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
    if (updateCar.hasClientId()) {
      Optional<Client> optionalClient = clientService.findById(updateCar.getClientId());
      optionalClient.ifPresent(client -> car.ifPresent(value -> value.setClient(client)));
    }
    car.ifPresent(carRepository::save);
  }
}
