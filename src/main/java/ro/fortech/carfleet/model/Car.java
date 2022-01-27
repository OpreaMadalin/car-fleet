package ro.fortech.carfleet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String brand;
  private String model;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Owner owner;

  public void updateCarOwner(Owner owner) {
    this.owner = owner;
  }

  public void updateBrandAndModel(String brand, String model) {
    this.brand = brand;
    this.model = model;
  }
}
