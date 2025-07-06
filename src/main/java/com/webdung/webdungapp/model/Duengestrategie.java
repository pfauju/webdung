package com.webdung.webdungapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Duengestrategie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String kultur;
    private String duenger;
    private double menge;
    private String zeitpunkt;
    private String geraet;
    private String bemerkungen;

    // Getter & Setter

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getKultur() { return kultur; }
    public void setKultur(String kultur) { this.kultur = kultur; }

    public String getDuenger() { return duenger; }
    public void setDuenger(String duenger) { this.duenger = duenger; }

    public double getMenge() { return menge; }
    public void setMenge(double menge) { this.menge = menge; }

    public String getZeitpunkt() { return zeitpunkt; }
    public void setZeitpunkt(String zeitpunkt) { this.zeitpunkt = zeitpunkt; }

    public String getGeraet() { return geraet; }
    public void setGeraet(String geraet) { this.geraet = geraet; }

    public String getBemerkungen() { return bemerkungen; }
    public void setBemerkungen(String bemerkungen) { this.bemerkungen = bemerkungen; }
}
