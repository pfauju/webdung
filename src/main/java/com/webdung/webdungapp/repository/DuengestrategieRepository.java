package com.webdung.webdungapp.repository;

import com.webdung.webdungapp.model.Duengestrategie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DuengestrategieRepository extends JpaRepository<Duengestrategie, Long> {
    
    // Strategien nach Kultur finden
    List<Duengestrategie> findByKultur(String kultur);
    
    // Strategien nach Dünger finden
    List<Duengestrategie> findByDuenger(String duenger);
    
    // Strategien nach Name finden
    List<Duengestrategie> findByStrategienameContainingIgnoreCase(String name);
    
    // Alle Strategien sortiert nach Erstellungsdatum
    List<Duengestrategie> findAllByOrderByErstelltAmDesc();
}
