package ro.fortech.carfleet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int age;
  private String name;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Address address;
}
