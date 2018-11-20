package pl.coderslab.carmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.carmanagement.model.user.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT true FROM User u WHERE u.login = :login")
    Boolean isLoginUsed(@Param("login")String login);


    @Query("SELECT true FROM User u WHERE u.email = :email")
    Boolean isEmailUsed(@Param("email")String email);

    User findByLogin(String login);

}


