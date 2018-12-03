package pl.coderslab.carmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.carmanagement.converters.MyConverter;
import pl.coderslab.carmanagement.dtos.UserDTO;
import pl.coderslab.carmanagement.model.advert.AdvertDetails;
import pl.coderslab.carmanagement.dtos.AdvertFormDTO;
import pl.coderslab.carmanagement.model.advert.Advert;
import pl.coderslab.carmanagement.model.dealer.Dealer;
import pl.coderslab.carmanagement.repositories.AdvertRepository;
import pl.coderslab.carmanagement.repositories.DealerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdvertsService {

    @Autowired
    private AdvertRepository advertRepository;

    @Autowired
    private DealerRepository dealerRepository;

    @PersistenceContext
    EntityManager entityManager;

    public void addAdvert(AdvertFormDTO addAdvertForm, Long ownerDealerId) {
        // Nie korzystam z konwertera, abyś widział co na co jest przepisywane
        // Advert advertEntity = MyConverter.INSTANCE.advert(advert);

        Advert advert = new Advert();
        advert.setDescription(addAdvertForm.getDescription());
        advert.setExpireDate(addAdvertForm.getExpireDate());
        advert.setTitle(addAdvertForm.getTitle());

        AdvertDetails details = new AdvertDetails();
        details.setColor(addAdvertForm.getColor());
        details.setDistance(addAdvertForm.getDistance());
        details.setMark(addAdvertForm.getMark());
        details.setModel(addAdvertForm.getModel());
        details.setPower(addAdvertForm.getPower());
        details.setPrice(addAdvertForm.getPrice());
        details.setProductionYear(addAdvertForm.getProductionYear());

        advert.setAdvertDetails(details);
        details.setAdvert(advert);

        Dealer dealer = dealerRepository.findOne(ownerDealerId);
        advert.setOwner(dealer);

        advertRepository.save(advert);

        dealer.getPublishedAdverts().add(advert);
        System.out.println("AdvertsService.addAdvert Zapisana encja advert: " + advert);
        System.out.println("AdvertsService.addAdvert Zapisane szczegóły: " + advert.getAdvertDetails().getId());
        System.out.println("AdvertsService.addAdvert Lista ogłoszeń dealera: " + dealer.getPublishedAdverts());
    }

    public List<AdvertFormDTO> allAdverts() {
        List<Advert> allAdverts = advertRepository.findAll();
        return allAdverts.stream().map(advert -> {
            AdvertFormDTO dto = new AdvertFormDTO();
            AdvertDetails details = advert.getAdvertDetails();
            dto.setColor(details.getColor());
            dto.setDescription(advert.getDescription());
            dto.setDistance(details.getDistance());
            dto.setExpireDate(advert.getExpireDate());
            dto.setMark(details.getMark());
            dto.setModel(details.getModel());
            dto.setPower(details.getPower());
            dto.setPrice(details.getProductionYear());
            dto.setPrice(details.getProductionYear());
            dto.setTitle(advert.getTitle());
            return dto;
        }).collect(Collectors.toList());
    }
}
