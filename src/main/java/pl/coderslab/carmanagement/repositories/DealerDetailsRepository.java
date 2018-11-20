package pl.coderslab.carmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.carmanagement.details.DealerDetails;

public interface DealerDetailsRepository extends JpaRepository<DealerDetails, Long> {
}
