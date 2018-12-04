package pl.coderslab.carmanagement.model.dealer;

import pl.coderslab.carmanagement.model.advert.Advert;
import pl.coderslab.carmanagement.model.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dealer")
public class Dealer extends User {

    @OneToMany(mappedBy = "owner")
    private List<Advert> publishedAdverts;

    @OneToOne(mappedBy = "dealer", cascade = CascadeType.ALL)
    private DealerDetails details;

    public List<Advert> getPublishedAdverts() {
        return publishedAdverts;
    }

    public void setPublishedAdverts(List<Advert> publishedAdverts) {
        this.publishedAdverts = publishedAdverts;
    }

    public DealerDetails getDetails() {
        return details;
    }

    public void setDetails(DealerDetails details) {
        this.details = details;
    }
}
