package com.webdung.webdungapp;

import com.webdung.webdungapp.model.Duengestrategie;
import com.webdung.webdungapp.repository.DuengestrategieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
public class DuengerController {
    
    @Autowired
    private DuengestrategieRepository duengestrategieRepository;
    
    // Hauptseite anzeigen
    @GetMapping("/")
    public String index(Model model) {
        // Alle Strategien für die Anzeige laden
        List<Duengestrategie> strategien = duengestrategieRepository.findAllByOrderByErstelltAmDesc();
        model.addAttribute("strategien", strategien);
        return "index";
    }
    
    // Neue Strategie speichern
    @PostMapping("/api/strategie")
    @ResponseBody
    public ResponseEntity<?> strategieSpeichern(@RequestBody StrategieRequest request) {
        try {
            Duengestrategie strategie = new Duengestrategie(
                request.getStrategiename(),
                request.getKultur(),
                request.getDuenger(),
                request.getMenge(),
                request.getZeitpunkt(),
                request.getGeraet(),
                request.getBemerkungen()
            );
            
            Duengestrategie gespeichert = duengestrategieRepository.save(strategie);
            return ResponseEntity.ok(gespeichert);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Fehler beim Speichern: " + e.getMessage());
        }
    }
    
    // Alle Strategien abrufen
    @GetMapping("/api/strategien")
    @ResponseBody
    public List<Duengestrategie> alleStrategien() {
        return duengestrategieRepository.findAllByOrderByErstelltAmDesc();
    }
    
    // Strategie löschen
    @DeleteMapping("/api/strategie/{id}")
    @ResponseBody
    public ResponseEntity<?> strategieLoeschen(@PathVariable Long id) {
        try {
            duengestrategieRepository.deleteById(id);
            return ResponseEntity.ok("Strategie gelöscht");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Fehler beim Löschen: " + e.getMessage());
        }
    }
    
    // Strategie bearbeiten
    @PutMapping("/api/strategie/{id}")
    @ResponseBody
    public ResponseEntity<?> strategieBearbeiten(@PathVariable Long id, @RequestBody StrategieRequest request) {
        try {
            Optional<Duengestrategie> optional = duengestrategieRepository.findById(id);
            if (optional.isPresent()) {
                Duengestrategie strategie = optional.get();
                strategie.setStrategiename(request.getStrategiename());
                strategie.setKultur(request.getKultur());
                strategie.setDuenger(request.getDuenger());
                strategie.setMenge(request.getMenge());
                strategie.setZeitpunkt(request.getZeitpunkt());
                strategie.setGeraet(request.getGeraet());
                strategie.setBemerkungen(request.getBemerkungen());
                
                Duengestrategie gespeichert = duengestrategieRepository.save(strategie);
                return ResponseEntity.ok(gespeichert);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Fehler beim Bearbeiten: " + e.getMessage());
        }
    }
    
    // Hilfsklasse für Request-Daten
    public static class StrategieRequest {
        private String strategiename;
        private String kultur;
        private String duenger;
        private Double menge;
        private String zeitpunkt;
        private String geraet;
        private String bemerkungen;
        
        // Getter und Setter
        public String getStrategiename() { return strategiename; }
        public void setStrategiename(String strategiename) { this.strategiename = strategiename; }
        
        public String getKultur() { return kultur; }
        public void setKultur(String kultur) { this.kultur = kultur; }
        
        public String getDuenger() { return duenger; }
        public void setDuenger(String duenger) { this.duenger = duenger; }
        
        public Double getMenge() { return menge; }
        public void setMenge(Double menge) { this.menge = menge; }
        
        public String getZeitpunkt() { return zeitpunkt; }
        public void setZeitpunkt(String zeitpunkt) { this.zeitpunkt = zeitpunkt; }
        
        public String getGeraet() { return geraet; }
        public void setGeraet(String geraet) { this.geraet = geraet; }
        
        public String getBemerkungen() { return bemerkungen; }
        public void setBemerkungen(String bemerkungen) { this.bemerkungen = bemerkungen; }
    }
}