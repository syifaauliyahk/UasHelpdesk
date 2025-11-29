package com.example.demo.service;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    // 1. STEP 1: User Lapor (Status auto OPEN)
    public Ticket buatTiket(Ticket ticket) {
        ticket.setStatus("OPEN");
        ticket.setWaktuLapor(LocalDateTime.now());
        ticket.setTeknisi("-"); // Belum ada yang handle
        return repository.save(ticket);
    }

    // Read All
    public List<Ticket> ambilSemuaTiket() {
        return repository.findAll();
    }

    // 2. STEP 2: Manager Assign Teknisi (Status -> IN_PROGRESS)
    public Ticket tugaskanTeknisi(Long id, String namaTeknisi) {
        Ticket ticket = repository.findById(id).orElseThrow();
        ticket.setTeknisi(namaTeknisi);
        ticket.setStatus("IN_PROGRESS");
        return repository.save(ticket);
    }

    // 3. STEP 3: Teknisi Selesaikan Tugas (Status -> CLOSED)
    public Ticket selesaikanTiket(Long id) {
        Ticket ticket = repository.findById(id).orElseThrow();
        ticket.setStatus("CLOSED");
        return repository.save(ticket);
    }
}
