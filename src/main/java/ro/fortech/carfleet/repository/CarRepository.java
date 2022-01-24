package ro.fortech.carfleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fortech.carfleet.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
