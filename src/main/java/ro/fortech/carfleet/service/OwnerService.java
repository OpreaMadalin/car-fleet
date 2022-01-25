package ro.fortech.carfleet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.carfleet.model.Owner;
import ro.fortech.carfleet.repository.OwnerRepository;

import java.util.Collections;
import java.util.List;

@Service
public class OwnerService {

  private final OwnerRepository ownerRepository;

  @Autowired
  public OwnerService(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }

  public void saveOwner(Owner owner) {
    ownerRepository.save(owner);
  }

  public List<Owner> getAllOwners() {
    return ownerRepository.findAll();
  }

  public List<Owner> getOwnerById(int id) {
    return ownerRepository.findAllById(Collections.singleton(id));
  }

  public void deleteOwnerById(int id) {
    ownerRepository.deleteById(id);
  }

  public void updateOwnerById(Owner owner) {
    ownerRepository.save(owner);
  }
}
