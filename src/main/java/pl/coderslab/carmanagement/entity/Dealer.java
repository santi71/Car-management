package pl.coderslab.carmanagement.entity;

import pl.coderslab.carmanagement.model.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dealer")
@Inheritance(strategy = InheritanceType.JOINED)
public class Dealer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @OneToMany(mappedBy = "owner")
    private List<Advert> adverts;



    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }
}
