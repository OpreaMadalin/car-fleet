package ro.fortech.carfleet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClientDto {

  private int id;
  private int age;
  private String name;
  private int addressId;
}
