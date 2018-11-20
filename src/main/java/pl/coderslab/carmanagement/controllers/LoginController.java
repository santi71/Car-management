package pl.coderslab.carmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.carmanagement.dtos.LoginFormDTO;
import pl.coderslab.carmanagement.dtos.UserDTO;
import pl.coderslab.carmanagement.services.LoginService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private HttpSession session;

    @GetMapping
    public String loginPage(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model) {
        if (loggedUser != null) {
            return "redirect:/home";
        }
        model.addAttribute("loginForm", new LoginFormDTO());
        return "logowanie";
    }

    @PostMapping
    public String processLogin(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                               @ModelAttribute("loginForm") @Valid LoginFormDTO form, BindingResult result,
                               HttpSession session) {
        System.out.println("[LOGOWANIE] Login: " + form.getLogin());
        System.out.println("[LOGOWANIE] Password: " + form.getPassword());
        if (loggedUser != null) {
            System.out.println("[LOGOWANIE] jest uzytkownik w sesji");
            return "redirect:/home";
        }
        if (result.hasErrors()) {
            System.out.println("[LOGOWANIE] blad danych w formularzu");
            return "logowanie";
        }
        boolean validCredentials = loginService.validate(form.getLogin(), form.getPassword());
        if (!validCredentials) {
            result.rejectValue("login", "errors.invalid", "Login i/lub hasło są niepoprawne");
            System.out.println("[LOGOWANIE] Niepoprawne dane");
            return "logowanie";
        }
        UserDTO user = loginService.login(form.getLogin());
        System.out.println("[LOGOWANIE] zalogwany uzytkownik " + user);
        session.setAttribute("loggedUser", user);

        return "redirect:/home";
    }
}
