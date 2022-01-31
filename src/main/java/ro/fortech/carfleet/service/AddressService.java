package ro.fortech.carfleet.service;

import org.springframework.stereotype.Service;
import ro.fortech.carfleet.model.Address;
import ro.fortech.carfleet.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

  private final AddressRepository addressRepository;

  public AddressService(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  public void addAddress(Address address) {
    addressRepository.save(address);
  }

  public List<Address> findAddress() {
    return addressRepository.findAll();
  }

  public Optional<Address> findById(int id) {
    return addressRepository.findById(id);
  }

  public void deleteAddressById(int id) {
    addressRepository.deleteById(id);
  }
}
