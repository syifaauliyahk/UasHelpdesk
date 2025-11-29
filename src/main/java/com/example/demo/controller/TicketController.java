package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/helpdesk")
public class TicketController {

    @Autowired
    private TicketService service;

    // 1. CREATE: Lapor Masalah
    @PostMapping("/lapor")
    public Ticket lapor(@RequestBody Ticket ticket) {
        return service.buatTiket(ticket);
    }

    // 2. READ: Lihat Semua Tiket
    @GetMapping("/list")
    public List<Ticket> list() {
        return service.ambilSemuaTiket();
    }

    // 3. UPDATE: Assign Teknisi (BPM Step 2)
    // URL: /api/helpdesk/assign/1?teknisi=MasJoko
    @PutMapping("/assign/{id}")
    public Ticket assign(@PathVariable Long id, @RequestParam String teknisi) {
        return service.tugaskanTeknisi(id, teknisi);
    }

    // 4. UPDATE: Tutup Tiket (BPM Step 3)
    // URL: /api/helpdesk/close/1
    @PutMapping("/close/{id}")
    public Ticket close(@PathVariable Long id) {
        return service.selesaikanTiket(id);
    }
}
