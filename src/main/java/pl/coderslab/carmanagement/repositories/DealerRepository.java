package pl.coderslab.carmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.carmanagement.model.dealer.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {
//    @Query("SELECT true FROM Dealer d WHERE u.login = :login")
//    Boolean isLoginUsed(@Param("login")String login);
//
//
//    @Query("SELECT true FROM Dealer d WHERE u.email = :email")
//    Boolean isEmailUsed(@Param("email")String email);
}
