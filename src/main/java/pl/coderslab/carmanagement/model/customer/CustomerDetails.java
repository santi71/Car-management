package pl.coderslab.carmanagement.model.customer;

import pl.coderslab.carmanagement.model.customer.Customer;

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
