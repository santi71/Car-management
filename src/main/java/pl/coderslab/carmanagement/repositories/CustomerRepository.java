package pl.coderslab.carmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.carmanagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    @Query("SELECT true FROM Customer c WHERE u.login = :login")
//    Boolean isLoginUsed(@Param("login")String login);
//
//
//    @Query("SELECT true FROM Customer c WHERE u.email = :email")
//    Boolean isEmailUsed(@Param("email")String email);
}


