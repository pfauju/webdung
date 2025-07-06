package com.webdung.webdungapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.webdung.webdungapp.model.Duengestrategie;
import com.webdung.webdungapp.repository.DuengestrategieRepository;

@Controller
public class DuengerController {

    @Autowired
    private DuengestrategieRepository strategieRepo;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("strategie", new Duengestrategie()); // fürs Formular
        model.addAttribute("alleStrategien", strategieRepo.findAll()); // zum Anzeigen
        return "index"; // zeigt index.html
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Duengestrategie strategie) {
        strategieRepo.save(strategie);
        return "redirect:/";
    }
}
