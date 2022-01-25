package ro.fortech.carfleet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owner")
public class Owner {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int age;
  private String name;

//  @JsonIgnore
//  @OneToMany(mappedBy = "owner")
//  private Set<Car> cars = new HashSet<>();
}
