package pl.coderslab.carmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.carmanagement.credentials.CustomerCredentials;

@Repository
public interface CustomerCredentialsRepository extends JpaRepository<CustomerCredentials, Long> {
}
