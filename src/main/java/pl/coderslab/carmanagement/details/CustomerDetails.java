package pl.coderslab.carmanagement.details;

import pl.coderslab.carmanagement.entity.Customer;

import javax.persistence.*;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "country")
    private String country;
    @OneToOne(optional = false)
    private Customer customer;


}
