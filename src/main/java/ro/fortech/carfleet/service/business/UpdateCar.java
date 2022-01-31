package ro.fortech.carfleet.service.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCar {

  private int id;
  private String brand;
  private String model;
  private int clientId;

  public boolean hasClientId() {
    return clientId > 0;
  }
}
