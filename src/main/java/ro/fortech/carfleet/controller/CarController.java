package ro.fortech.carfleet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.model.Car;
import ro.fortech.carfleet.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

  public final CarService carServiceImpl;

  @Autowired
  public CarController(CarService carServiceImpl) {
    this.carServiceImpl = carServiceImpl;
  }

  @PostMapping
  public ResponseEntity<String> addCar(@RequestBody CarDto body) {
    carServiceImpl.saveCar(body);

    return new ResponseEntity<>("Saved", HttpStatus.OK);
  }

  @GetMapping
  public List<Car> getAllCars() {
    return carServiceImpl.getAllCars();
  }

  @GetMapping("/{id}")
  public Optional<Car> getCarById(@PathVariable("id") int id) {
    return carServiceImpl.getCarById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteCar(@PathVariable("id") int id) {
    carServiceImpl.deleteCarById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateCar(@PathVariable("id") int id, @RequestBody CarDto body) {
    body.setId(id);
    carServiceImpl.updateCarById(body);

    return new ResponseEntity<>("Updated", HttpStatus.OK);
  }

  @PutMapping("/{carId}/ownerId/{ownerId}")
  public void assignOwnerToCar(
      @PathVariable("carId") int carId, @PathVariable("ownerId") int ownerId) {
    carServiceImpl.assignOwnerToCar(carId, ownerId);
  }
}
