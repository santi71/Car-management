package pl.coderslab.carmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.carmanagement.converters.MyConverter;
import pl.coderslab.carmanagement.details.AdvertDetails;
import pl.coderslab.carmanagement.dtos.AdvertFormDTO;
import pl.coderslab.carmanagement.entity.Advert;
import pl.coderslab.carmanagement.repositories.AdvertRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdvertsService {

    @Autowired
    private AdvertRepository advertRepository;
    @PersistenceContext
    EntityManager entityManager;

    public void addAdvert(AdvertFormDTO advert) {
        Advert advertEntity = MyConverter.INSTANCE.advert(advert);
        advertRepository.save(advertEntity);
        System.out.println("AdvertsService.addAdvert: Zapisana encja advert: " + advertEntity);
    }

    public List<AdvertFormDTO> allAdverts() {
        List<Advert> allAdverts = advertRepository.findAll();
        return allAdverts.stream().map(advert -> MyConverter.INSTANCE.advertDTO(advert)).collect(Collectors.toList());
    }

    public void advert(AdvertFormDTO form) {
        Advert advert = new Advert();
        String title = form.getTitle();
        String description = form.getDescription();
        String model = form.getModel();
        String mark = form.getMark();
        Double price = form.getPrice();
        Double productionYear = form.getProductionYear();
        Double distance = form.getDistance();
        Integer power = form.getPower();
        LocalDate expireDate = form.getExpireDate();
        String content = form.getContent();
        String color = form.getColor();


        advert.setTitle(title);
        advert.setDescription(description);
        advert.setExpireDate(expireDate);

        AdvertDetails details = new AdvertDetails();
        details.setColor(color);
        details.setAdvert(advert);
        details.setDistance(distance);
        details.setMark(mark);
        details.setModel(model);
        details.setPrice(price);
        details.setProductionYear(productionYear);
        details.setPower(power);

        advert.setAdvertDetails(details);
        entityManager.persist(advert);




    }
}
