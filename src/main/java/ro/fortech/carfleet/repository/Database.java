package ro.fortech.carfleet.repository;

import org.springframework.stereotype.Component;
import ro.fortech.carfleet.dto.CarDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Database {

  private static final Map<Integer, CarDto> carsDb = new HashMap<>();

  public CarDto addCar(CarDto body) {
    carsDb.put(body.getId(), body);

    return body;
  }

  public List<CarDto> getAllCars() {
    return new ArrayList<>(carsDb.values());
  }

  public CarDto getCarById(int id) {
    return carsDb.get(id);
  }

  public CarDto deleteCarById(int id) {
    return carsDb.remove(id);
  }

  public CarDto updateCarById(CarDto body) {
    carsDb.put(body.getId(), body);

    return body;
  }
}
