package ro.fortech.carfleet.service.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClient {

  private int id;
  private int age;
  private String name;
  private int addressId;

  public boolean hasAddressId() {
    return addressId > 0;
  }
}
