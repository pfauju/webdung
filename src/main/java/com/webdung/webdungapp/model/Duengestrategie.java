package com.webdung.webdungapp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "duengestrategien")
public class Duengestrategie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String strategiename;
    
    @Column(nullable = false)
    private String kultur;
    
    @Column(nullable = false)
    private String duenger;
    
    @Column(nullable = false)
    private Double menge;
    
    @Column(nullable = false)
    private String zeitpunkt;
    
    @Column(nullable = false)
    private String geraet;
    
    @Column(columnDefinition = "TEXT")
    private String bemerkungen;
    
    @Column(name = "erstellt_am")
    private LocalDateTime erstelltAm;
    
    // Konstruktoren
    public Duengestrategie() {
        this.erstelltAm = LocalDateTime.now();
    }
    
    public Duengestrategie(String strategiename, String kultur, String duenger, 
                          Double menge, String zeitpunkt, String geraet, String bemerkungen) {
        this.strategiename = strategiename;
        this.kultur = kultur;
        this.duenger = duenger;
        this.menge = menge;
        this.zeitpunkt = zeitpunkt;
        this.geraet = geraet;
        this.bemerkungen = bemerkungen;
        this.erstelltAm = LocalDateTime.now();
    }
    
    // Getter und Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
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
    
    public LocalDateTime getErstelltAm() { return erstelltAm; }
    public void setErstelltAm(LocalDateTime erstelltAm) { this.erstelltAm = erstelltAm; }
}