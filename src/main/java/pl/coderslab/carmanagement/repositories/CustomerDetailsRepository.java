package pl.coderslab.carmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.carmanagement.details.CustomerDetails;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
}
