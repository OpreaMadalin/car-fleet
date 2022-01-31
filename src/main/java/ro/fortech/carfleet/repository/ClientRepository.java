package ro.fortech.carfleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fortech.carfleet.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {}
