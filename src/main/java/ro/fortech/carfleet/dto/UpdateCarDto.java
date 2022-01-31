package ro.fortech.carfleet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarDto {

  private int id;
  private String brand;
  private String model;
  private int clientId;
}
