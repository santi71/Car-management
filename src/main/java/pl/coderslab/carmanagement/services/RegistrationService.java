package pl.coderslab.carmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.carmanagement.model.user.UserCredentials;
import pl.coderslab.carmanagement.model.user.UserDetails;
import pl.coderslab.carmanagement.dtos.RegistrationFormDTO;

import pl.coderslab.carmanagement.model.user.User;
import pl.coderslab.carmanagement.repositories.UserCredentialsRepository;
import pl.coderslab.carmanagement.repositories.UserDetailsRepository;
import pl.coderslab.carmanagement.repositories.UserRepository;
import pl.coderslab.carmanagement.repositories.UserRoleRepository;
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

        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
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
