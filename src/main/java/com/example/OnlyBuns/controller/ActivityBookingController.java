package com.example.OnlyBuns.controller;

import com.example.OnlyBuns.dto.ActivityBookingDto;
import com.example.OnlyBuns.service.ActivityBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/activity-bookings")
public class ActivityBookingController {

    private final ActivityBookingService service;

    public ActivityBookingController(ActivityBookingService service) {
        this.service = service;
    }

    @GetMapping
    public List<ActivityBookingDto> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityBookingDto> get(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ActivityBookingDto> create(@Valid @RequestBody ActivityBookingDto dto) {
        try {
            return ResponseEntity.ok(service.create(dto));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ActivityBookingDto> patch(@PathVariable Long id,
                                                    @RequestBody ActivityBookingDto dto) {
        try {
            return ResponseEntity.ok(service.patch(id, dto));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
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
