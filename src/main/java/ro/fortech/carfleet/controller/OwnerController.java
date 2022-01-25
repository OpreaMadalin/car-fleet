package ro.fortech.carfleet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fortech.carfleet.dto.OwnerDto;
import ro.fortech.carfleet.mapper.OwnerMapper;
import ro.fortech.carfleet.service.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

  private final OwnerMapper ownerMapper;
  private final OwnerService ownerService;

  @Autowired
  public OwnerController(OwnerMapper ownerMapper, OwnerService ownerService) {
    this.ownerMapper = ownerMapper;
    this.ownerService = ownerService;
  }

  @PostMapping
  public ResponseEntity<String> addOwner(@RequestBody OwnerDto ownerDto) {
    ownerService.saveOwner(ownerMapper.ownerDtoToOwner(ownerDto));

    return new ResponseEntity<>("Saved", HttpStatus.OK);
  }

  @GetMapping
  public List<OwnerDto> getAllCars() {
    return ownerMapper.ownerToOwnerDtoList(ownerService.getAllOwners());
  }

  @GetMapping("/{id}")
  public List<OwnerDto> getOwnerById(@PathVariable("id") int id) {
    return ownerMapper.ownerToOwnerDtoList(ownerService.getOwnerById(id));
  }

  @DeleteMapping("/{id}")
  public void deleteOwnerById(@PathVariable("id") int id) {
    ownerService.deleteOwnerById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateOwnerById(
      @PathVariable("id") int id, @RequestBody OwnerDto ownerDto) {
    ownerDto.setId(id);
    ownerService.updateOwnerById(ownerMapper.ownerDtoToOwner(ownerDto));

    return new ResponseEntity<>("Updated", HttpStatus.OK);
  }
}
