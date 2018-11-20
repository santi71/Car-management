package pl.coderslab.carmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.carmanagement.converters.MyConverter;
import pl.coderslab.carmanagement.dtos.AdvertFormDTO;
import pl.coderslab.carmanagement.entity.Advert;
import pl.coderslab.carmanagement.repositories.AdvertRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdvertsService {

    @Autowired
    private AdvertRepository advertRepository;

    public void addAdvert(AdvertFormDTO advert) {
        Advert advertEntity = MyConverter.INSTANCE.advert(advert);
        advertRepository.save(advertEntity);
        System.out.println("AdvertsService.addAdvert: Zapisana encja advert: " + advertEntity);
    }

    public List<AdvertFormDTO> allAdverts() {
        List<Advert> allAdverts = advertRepository.findAll();
        return allAdverts.stream().map(advert -> MyConverter.INSTANCE.advertDTO(advert)).collect(Collectors.toList());
    }
}
