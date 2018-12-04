package pl.coderslab.carmanagement.model.customer;

import pl.coderslab.carmanagement.model.user.User;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer extends User {

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CustomerDetails details;

    public CustomerDetails getDetails() {
        return details;
    }

    public void setDetails(CustomerDetails details) {
        this.details = details;
    }
}
