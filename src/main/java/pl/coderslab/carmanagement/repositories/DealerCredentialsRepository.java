package pl.coderslab.carmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.carmanagement.credentials.DealerCredentials;

public interface DealerCredentialsRepository extends JpaRepository<DealerCredentials, Long> {
}
