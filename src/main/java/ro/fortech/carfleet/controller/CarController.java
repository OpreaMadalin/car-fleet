package ro.fortech.carfleet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.fortech.carfleet.database.Database;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.model.Car;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

  private final Database database;

  @Autowired
  public CarController(Database database) {
    this.database = database;
  }

  @PostMapping
  public Car addCar(@RequestBody CarDto body) {
    return database.addCar(body);
  }

  @GetMapping
  public List<Car> getAllCars() {
    return database.getAllCars();
  }

  @GetMapping("/{id}")
  public Car getCarById(@PathVariable("id") int id) {
    return database.getCarById(id);
  }

  @DeleteMapping("/{id}")
  public Car deleteCar(@PathVariable("id") int id) {
    return database.deleteCarById(id);
  }

  @PutMapping("/{id}")
  public Car updateCar(@PathVariable("id") int id, @RequestBody CarDto body) {
    body.setId(id);

    return database.updateCarById(body);
  }
}
