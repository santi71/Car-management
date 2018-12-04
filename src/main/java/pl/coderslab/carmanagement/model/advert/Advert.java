package pl.coderslab.carmanagement.model.advert;

import pl.coderslab.carmanagement.model.dealer.Dealer;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "advert")
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 8, max = 30)
    private String title;
    @Size(max = 500)
    private String description;
    private LocalDate expireDate;
    @ManyToOne
    private Dealer owner;
    // Możemy spokojnie dać kaskadę na wszystko, bo relacja jest typowo właściciel-własność
    @OneToOne(mappedBy = "advert", cascade = CascadeType.ALL)
    private AdvertDetails advertDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public Dealer getOwner() {
        return owner;
    }

    public void setOwner(Dealer owner) {
        this.owner = owner;
    }

    public AdvertDetails getAdvertDetails() {
        return advertDetails;
    }

    public void setAdvertDetails(AdvertDetails advertDetails) {
        this.advertDetails = advertDetails;
    }
}
