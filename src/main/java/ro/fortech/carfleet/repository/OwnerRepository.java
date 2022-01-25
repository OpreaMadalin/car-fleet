package ro.fortech.carfleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fortech.carfleet.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {}
