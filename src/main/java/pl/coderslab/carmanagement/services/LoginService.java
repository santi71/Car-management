package pl.coderslab.carmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.carmanagement.dtos.UserDTO;
import pl.coderslab.carmanagement.model.user.User;
import pl.coderslab.carmanagement.model.user.UserCredentials;
import pl.coderslab.carmanagement.repositories.UserCredentialsRepository;
import pl.coderslab.carmanagement.repositories.UserRepository;

@Service
@Transactional
public class LoginService {
    @Autowired
   private UserRepository userRepository;

    @Autowired
   private UserCredentialsRepository userCredentialsRepository;

    public boolean validate(String login, String password) {
        Boolean check = userCredentialsRepository.checkCredentials(login, password);
        return check != null ? check : false;
    }

    public UserDTO login(String login) {
        User user = userRepository.findByLogin(login);
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(user.getLogin());
        userDTO.setId(user.getId());
        return userDTO;
    }
}
