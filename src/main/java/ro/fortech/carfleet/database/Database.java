package ro.fortech.carfleet.database;

import org.springframework.stereotype.Component;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.model.Car;
import ro.fortech.carfleet.model.Owner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Database {

  private final Map<Integer, Car> carsDb = new HashMap<>();

  public Car addCar(CarDto body) {
    Car car = new Car();
    Owner owner = new Owner();
    owner.setAge(body.getOwner().getAge());
    owner.setName(body.getOwner().getName());
    car.setId(body.getId());
    car.setBrand(body.getBrand());
    car.setModel(body.getModel());
    car.setOwner(owner);
    carsDb.put(car.getId(), car);

    return car;
  }

  public List<Car> getAllCars() {
    return new ArrayList<>(carsDb.values());
  }

  public Car getCarById(int id) {
    return carsDb.get(id);
  }

  public Car deleteCarById(int id) {
    return carsDb.remove(id);
  }

  public Car updateCarById(CarDto body) {
    Car car = carsDb.get(getCarById(body.getId()).getId());
    Owner owner = carsDb.get(getCarById(body.getId()).getId()).getOwner();
    owner.setAge(body.getOwner().getAge());
    owner.setName(body.getOwner().getName());
    car.setBrand(body.getBrand());
    car.setModel(body.getModel());
    car.setOwner(owner);

    return carsDb.get(body.getId());
  }
}
