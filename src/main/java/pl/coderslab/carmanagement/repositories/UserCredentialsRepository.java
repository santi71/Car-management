package pl.coderslab.carmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.carmanagement.model.user.UserCredentials;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {
    @Query("SELECT CASE WHEN count (uc.id) > 0 THEN true ELSE false END " +
            "FROM UserCredentials uc WHERE uc.user.login = :login AND uc.password = :password")
    Boolean checkCredentials(@Param("login") String login, @Param("password") String password);
}

