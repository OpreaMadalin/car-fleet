package ro.fortech.carfleet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.dto.UpdateCarDto;
import ro.fortech.carfleet.mapper.CarMapper;
import ro.fortech.carfleet.model.Car;
import ro.fortech.carfleet.service.CarService;

import java.util.List;
import java.util.Optional;

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
  public ResponseEntity<String> save(@RequestBody CarDto carDto) {
    carService.save(carMapper.carDtoToCar(carDto));

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public List<CarDto> findAll(@RequestParam(value = "brand", required = false) String brand) {
    return carMapper.listCarToListCarDto(carService.findAll(brand));
  }

  @GetMapping("/{id}")
  public Optional<CarDto> findById(@PathVariable("id") int id) {
    Optional<Car> car = carService.findById(id);

    return car.map(carMapper::carToCarDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
    carService.deleteById(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateById(
      @PathVariable(value = "id") int carId, @RequestBody UpdateCarDto updateCarDto) {
    updateCarDto.setId(carId);
    carService.updateById(carMapper.updateCarDtoToUpdateCar(updateCarDto));

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
