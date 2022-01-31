package ro.fortech.carfleet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

  private int id;
  private int age;
  private String name;
  private AddressDto address;
}
