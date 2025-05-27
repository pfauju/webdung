package com.webdung.webdungapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DuengeController {

    @GetMapping("/")
    public String zeigeForm() {
        return "index";
    }

    @PostMapping("/berechne")
    public String berechneDuenger(@RequestParam double flaeche,
                                   @RequestParam double bedarf,
                                   Model model) {
        double ergebnis = flaeche * bedarf;
        model.addAttribute("ergebnis", ergebnis);
        return "index";
    }
}
