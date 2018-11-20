package pl.coderslab.carmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.carmanagement.dtos.AdvertFormDTO;
import pl.coderslab.carmanagement.services.AdvertsService;

import java.util.List;

@Controller
@RequestMapping("adverts")
public class AdvertViewController {
    @Autowired
    private AdvertsService advertsService;

    @ModelAttribute("adverts")
    public List<AdvertFormDTO> allAdverts() {
        return advertsService.allAdverts();
    }

    @GetMapping
    public String adverts() {
        return "secured/listaOgloszen";
    }
}
