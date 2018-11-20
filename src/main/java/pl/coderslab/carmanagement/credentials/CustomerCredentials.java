package pl.coderslab.carmanagement.credentials;

import pl.coderslab.carmanagement.entity.Customer;

import javax.persistence.*;

@Entity
@Table(name = "customer_credentials")
public class CustomerCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @OneToOne(optional = false)
    private Customer customer;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
