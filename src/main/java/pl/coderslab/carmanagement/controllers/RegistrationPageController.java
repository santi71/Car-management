package pl.coderslab.carmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.carmanagement.dtos.RegistrationFormDTO;
import pl.coderslab.carmanagement.services.RegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationPageController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping()
    public String showRegistrationPage(Model model) {
        model.addAttribute("regForm", new RegistrationFormDTO());
        return "rejestracja";
    }
    @PostMapping
    public String processRegistrationForm(@ModelAttribute("regForm") @Valid RegistrationFormDTO form,
                                          BindingResult results, Model model) {
        // 1. Zwalidować poprawność pól
        if (results.hasErrors()) {
            return "rejestracja";
        }
        if (!form.getConfirmedPassword().equals(form.getPassword())) {
            results.rejectValue("password","errors.notmatch","Hasło i powtórzone hasło muszą być zgodne");
            return "rejestracja";
        }

        // 2. Wywołanie procesu rejestracji
        try {
            registrationService.register(form);
            return "homepage";
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            results.rejectValue("login", "errors.nonunique", "Login/email są już zajęte");
            return "rejestracja";
        } catch (RuntimeException re) {
            re.printStackTrace();
            // 2.b. Dodać informację o błędzie przetwarzania
            model.addAttribute("error", true);
            return "rejestracja";
        }
    }
}

