package ro.fortech.carfleet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.dto.UpdateCarDto;
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

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public List<CarDto> getCars(@RequestParam(value = "brand", required = false) String brand) {
    return carMapper.listCarToListCarDto(carService.findCars(brand));
  }

  @GetMapping("/{id}")
  public CarDto getCarById(@PathVariable("id") int id) {
    return carMapper.carToCarDto(carService.findCarById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCarById(@PathVariable("id") int id) {
    carService.deleteCarById(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateCarById(
      @PathVariable(value = "id") int carId, @RequestBody UpdateCarDto updateCarDto) {
    updateCarDto.setId(carId);
    carService.updateCarById(carMapper.updateCarDtoToUpdateCar(updateCarDto));

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
