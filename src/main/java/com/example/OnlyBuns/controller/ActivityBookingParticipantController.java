package com.example.OnlyBuns.controller;

import com.example.OnlyBuns.dto.ActivityBookingParticipantDto;
import com.example.OnlyBuns.service.ActivityBookingParticipantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/activity-booking-participants")
public class ActivityBookingParticipantController {

    private final ActivityBookingParticipantService service;

    public ActivityBookingParticipantController(ActivityBookingParticipantService service) {
        this.service = service;
    }

    @GetMapping
    public List<ActivityBookingParticipantDto> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityBookingParticipantDto> get(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ActivityBookingParticipantDto> create(@Valid @RequestBody ActivityBookingParticipantDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<ActivityBookingParticipantDto> patch(@PathVariable Long id,
                                                               @RequestBody ActivityBookingParticipantDto dto) {
        try {
            return ResponseEntity.ok(service.patch(id, dto));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
