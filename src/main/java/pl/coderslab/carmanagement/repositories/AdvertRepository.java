package pl.coderslab.carmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.carmanagement.model.advert.Advert;

@Repository

public interface AdvertRepository extends JpaRepository<Advert, Long> {

}
