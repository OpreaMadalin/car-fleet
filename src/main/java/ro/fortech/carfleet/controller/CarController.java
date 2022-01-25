package ro.fortech.carfleet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.mapper.CarMapper;
import ro.fortech.carfleet.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

  private final CarMapper carMapper;
  private final CarService carService;

  @Autowired
  public CarController(CarMapper carMapper, CarService carServiceImpl) {
    this.carMapper = carMapper;
    this.carService = carServiceImpl;
  }

  @PostMapping
  public ResponseEntity<String> addCar(@RequestBody CarDto carDto) {
    carService.saveCar(carMapper.carDtoToCar(carDto));

    return new ResponseEntity<>("Saved", HttpStatus.OK);
  }

  @GetMapping
  public List<CarDto> getAllCars() {
    return carMapper.carToCarDtoList(carService.getAllCars());
  }

  @GetMapping("/{id}")
  public List<CarDto> getCarById(@PathVariable("id") int id) {
    return carMapper.carToCarDtoList(carService.getCarById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCarById(@PathVariable("id") int id) {
    carService.deleteCarById(id);

    return new ResponseEntity<>("Deleted", HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateCarById(
      @PathVariable("id") int id, @RequestBody CarDto carDto) {
    carDto.setId(id);
    carService.updateCarById(carMapper.carDtoToCar(carDto));

    return new ResponseEntity<>("Updated", HttpStatus.OK);
  }

  @PutMapping("/{carId}/ownerId/{ownerId}")
  public ResponseEntity<String> assignOwnerToCar(
      @PathVariable("carId") int carId, @PathVariable("ownerId") int ownerId) {
    carService.assignOwnerToCar(carId, ownerId);

    return new ResponseEntity<>("Assigned", HttpStatus.OK);
  }
}
