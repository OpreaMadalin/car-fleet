package ro.fortech.carfleet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDto {

  private int id;
  private String brand;
  private String model;
  private OwnerDto owner;
}
