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

  public void save(Car car) {
    carRepository.save(car);
  }

  public List<Car> findAll(String brand) {
    return Optional.ofNullable(brand).isPresent()
        ? carRepository.findByBrand(brand)
        : carRepository.findAll();
  }

  public Optional<Car> findById(int id) {
    return carRepository.findById(id);
  }

  public void deleteById(int id) {
    carRepository.deleteById(id);
  }

  public void updateById(UpdateCar updateCar) {
    Optional<Car> car = findById(updateCar.getId());
    Optional<Client> client = clientService.findById(updateCar.getClientId());
    if (car.isPresent()) {
      car.get().setBrand(updateCar.getBrand());
      car.get().setModel(updateCar.getModel());
      client.ifPresent(value -> car.get().setClient(value));
      carRepository.save(car.get());
    }
  }
}
