package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity //Hibernate (memetakan class java ke tabel database)
public class Ticket {

    @Id //Hibernate (memetakan class java ke tabel database)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pelapor;       
    private String deskripsi;     
    private String prioritas;     // HIGH / MEDIUM / LOW
    
    // BPM State: OPEN -> IN_PROGRESS -> CLOSED
    private String status;
    
    private String teknisi;       
    private LocalDateTime waktuLapor;

    // Constructor kosong
    public Ticket() {}

    // Getters & Setters Manual 
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPelapor() { return pelapor; }
    public void setPelapor(String pelapor) { this.pelapor = pelapor; }
    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
    public String getPrioritas() { return prioritas; }
    public void setPrioritas(String prioritas) { this.prioritas = prioritas; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getTeknisi() { return teknisi; }
    public void setTeknisi(String teknisi) { this.teknisi = teknisi; }
    public LocalDateTime getWaktuLapor() { return waktuLapor; }
    public void setWaktuLapor(LocalDateTime waktuLapor) { this.waktuLapor = waktuLapor; }
}

