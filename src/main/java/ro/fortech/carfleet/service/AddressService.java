package ro.fortech.carfleet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.carfleet.model.Address;
import ro.fortech.carfleet.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

  private final AddressRepository addressRepository;

  @Autowired
  public AddressService(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  public void save(Address address) {
    addressRepository.save(address);
  }

  public List<Address> findAll(String country) {
    return Optional.ofNullable(country).isPresent()
        ? addressRepository.findByCountry(country)
        : addressRepository.findAll();
  }

  public Optional<Address> findById(int id) {
    return addressRepository.findById(id);
  }

  public void deleteById(int id) {
    addressRepository.deleteById(id);
  }
}
