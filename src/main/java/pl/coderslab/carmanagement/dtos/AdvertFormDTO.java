package pl.coderslab.carmanagement.dtos;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AdvertFormDTO {

    @NotNull @NotBlank @Size(min = 3, max = 20)
    private String title;
    @Size(max = 300)
    private String description;
    @NotNull @DateTimeFormat(pattern = "uuuu-MM-dd")
    private LocalDate expireDate;
    @NotNull @NotBlank @Size(min = 2, max = 12)
    private String mark;
    @NotNull @NotBlank @Size(min = 2, max = 10)
    private String model;
    @NotNull @NotBlank @Size(max = 10)
    private String color;
    @NotNull
    private Integer power;
    @NotNull
    private Double price;
    @NotNull
    private Double distance;
    @NotNull
    private Double productionYear;


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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Double productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {
        return "AdvertFormDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", expireDate=" + expireDate +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", power=" + power +
                ", price=" + price +
                ", distance=" + distance +
                ", productionYear=" + productionYear +
                '}';
    }
}
