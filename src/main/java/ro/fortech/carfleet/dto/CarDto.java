package ro.fortech.carfleet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {

  private int id;
  private String brand;
  private String model;
  private OwnerDto owner;
}
