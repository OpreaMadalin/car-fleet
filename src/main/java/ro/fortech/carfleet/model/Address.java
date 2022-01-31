package ro.fortech.carfleet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int streetNumber;
  private String streetName;
  private String country;
}
