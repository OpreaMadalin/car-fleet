package ro.fortech.carfleet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

  private int id;
  private int streetNumber;
  private String streetName;
  private String country;
}
