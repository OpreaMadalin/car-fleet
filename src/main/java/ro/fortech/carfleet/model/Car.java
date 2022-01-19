package ro.fortech.carfleet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

  private int id;
  private String brand;
  private String model;
  private Owner owner;
}
