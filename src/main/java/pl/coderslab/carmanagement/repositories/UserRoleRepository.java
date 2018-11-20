package pl.coderslab.carmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.carmanagement.model.user.UserRole;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
