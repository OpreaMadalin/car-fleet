package ro.fortech.carfleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fortech.carfleet.model.Address;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
  List<Address> findByCountry(String country);
}
