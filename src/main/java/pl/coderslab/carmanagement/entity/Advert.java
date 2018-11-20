package pl.coderslab.carmanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "advert")
@Inheritance(strategy = InheritanceType.JOINED)
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
}
