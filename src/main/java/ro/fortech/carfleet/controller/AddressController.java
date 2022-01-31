package ro.fortech.carfleet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fortech.carfleet.dto.AddressDto;
import ro.fortech.carfleet.mapper.AddressMapper;
import ro.fortech.carfleet.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

  private final AddressMapper addressMapper;
  private final AddressService addressService;

  @Autowired
  public AddressController(AddressMapper addressMapper, AddressService addressService) {
    this.addressMapper = addressMapper;
    this.addressService = addressService;
  }

  @PostMapping
  public ResponseEntity<String> saveAddress(@RequestBody AddressDto addressDto) {
    addressService.addAddress(addressMapper.addressDtoToAddress(addressDto));

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public List<AddressDto> getAddress() {
    return addressMapper.addressListToAddressDtoList(addressService.findAddress());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
    addressService.deleteAddressById(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
