package pl.coderslab.carmanagement.details;

import pl.coderslab.carmanagement.entity.Advert;

import javax.persistence.*;

@Entity
@Table(name = "advert_details")
public class AdvertDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "color")
    private String color;
    @Column(name = "model")
    private String model;
    @Column(name = "mark")
    private String mark;
    @Column(name = "power")
    private Integer power;
    @Column(name = "distance")
    private Double distance;
    @Column(name = "price")
    private Double price;
    @Column(name = "production_year")
    private Double productionYear;
    @OneToOne(optional = false)
    private Advert advert;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Double productionYear) {
        this.productionYear = productionYear;
}

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }
}
