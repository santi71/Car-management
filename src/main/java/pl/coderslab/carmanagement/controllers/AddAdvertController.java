package pl.coderslab.carmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.carmanagement.dtos.AdvertFormDTO;
import pl.coderslab.carmanagement.repositories.AdvertRepository;
import pl.coderslab.carmanagement.services.AdvertsService;

import javax.validation.Valid;

@Controller
@RequestMapping("/adverts/add-advert")
public class AddAdvertController {

    @Autowired
    AdvertsService advertsService;

    @GetMapping
    public String beginAddAdvert(Model model) {
        model.addAttribute("advert", new AdvertFormDTO());
        return "secured/ogloszenie";
    }

    @PostMapping
    public String addAdvert(@ModelAttribute("advert") @Valid AdvertFormDTO advert, BindingResult errors) {
        if (errors.hasErrors()) {
            return "secured/ogloszenie";
        }
        advertsService.addAdvert(advert);
        return "redirect:/listaOgloszen";
    }

}
