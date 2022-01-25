package ro.fortech.carfleet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.carfleet.dto.OwnerDto;
import ro.fortech.carfleet.mapper.OwnerMapper;
import ro.fortech.carfleet.repository.OwnerRepository;

@Service
public class OwnerService {

  private final OwnerMapper ownerMapper;
  private final OwnerRepository ownerRepository;

  @Autowired
  public OwnerService(OwnerMapper ownerMapper, OwnerRepository ownerRepository) {
    this.ownerMapper = ownerMapper;
    this.ownerRepository = ownerRepository;
  }

  public void saveOwner(OwnerDto ownerDto) {
    ownerRepository.save(ownerMapper.ownerDtoToOwner(ownerDto));
  }
}
