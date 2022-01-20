package ro.fortech.carfleet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.model.Car;
import ro.fortech.carfleet.service.CarServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

  public final CarServiceImpl carServiceImpl;

  @Autowired
  public CarController(CarServiceImpl carServiceImpl) {
    this.carServiceImpl = carServiceImpl;
  }

  @PostMapping
  public CarDto addCar(@RequestBody Car body) {
    return carServiceImpl.saveCar(body);
  }

  @GetMapping
  public List<CarDto> getAllCars() {
    return carServiceImpl.getAllCars();
  }

  @GetMapping("/{id}")
  public CarDto getCarById(@PathVariable("id") int id) {
    return carServiceImpl.getCarById(id);
  }

  @DeleteMapping("/{id}")
  public CarDto deleteCar(@PathVariable("id") int id) {
    return carServiceImpl.deleteCarById(id);
  }

  @PutMapping("/{id}")
  public CarDto updateCar(@PathVariable("id") int id, @RequestBody Car body) {
    body.setId(id);

    return carServiceImpl.updateCarById(id, body);
  }
}
