package pl.coderslab.carmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.carmanagement.model.dealer.Dealer;
import pl.coderslab.carmanagement.model.dealer.DealerDetails;
import pl.coderslab.carmanagement.model.user.UserCredentials;
import pl.coderslab.carmanagement.model.user.UserDetails;
import pl.coderslab.carmanagement.dtos.RegistrationFormDTO;

import pl.coderslab.carmanagement.model.user.User;
import pl.coderslab.carmanagement.repositories.*;
import pl.coderslab.carmanagement.model.user.UserRole;

@Service
@Transactional
public class RegistrationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private DealerRepository dealerRepository;

    public void register(RegistrationFormDTO form) {
        String login = form.getLogin();
        String email = form.getEmail();
        String password = form.getPassword();

        Boolean loginUsed = userRepository.isLoginUsed(login);

        if(loginUsed != null && loginUsed) {
            throw new IllegalArgumentException("Login zajęty!");

        }

        Boolean emailUsed = userRepository.isEmailUsed(email);
        if(emailUsed != null && emailUsed) {
            throw new IllegalArgumentException("Email zajęty!");
        }

        // W twoim przypadku rejestrujemy Dealer'a a nie User'a
        // User jest tutaj nadklasą, a my chcemy stworzyć konkretną podklasę

        Dealer user = new Dealer();
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);

        // Zapis wymyślonych danych szczegółowych dealera
        DealerDetails dealerDetails = new DealerDetails();
        dealerDetails.setFirstName("Jan");
        dealerDetails.setLastName("Zbigniew");
        dealerDetails.setDealer(user);

        user.setDetails(dealerDetails);
        userRepository.save(user);

        UserDetails details = new UserDetails();
        details.setFirstName(form.getFirstName());
        details.setLastName(form.getLastName());
        details.setUser(user);

        userDetailsRepository.save(details);

        UserCredentials credentials = new UserCredentials();
        credentials.setUser(user);
        credentials.setPassword(password);
        userCredentialsRepository.save(credentials);

        UserRole role = new UserRole();
        role.setUser(user);
        role.setRole("USER");

        userRoleRepository.save(role);

    }
}
