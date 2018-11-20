package pl.coderslab.carmanagement.credentials;

import pl.coderslab.carmanagement.entity.Dealer;

import javax.persistence.*;

@Entity
@Table(name = "dealer_credentials")
public class DealerCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @OneToOne(optional = false)
    private Dealer dealer;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
