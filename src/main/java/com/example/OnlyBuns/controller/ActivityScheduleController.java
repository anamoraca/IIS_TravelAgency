package com.example.OnlyBuns.controller;

import com.example.OnlyBuns.dto.ActivityScheduleDto;
import com.example.OnlyBuns.service.ActivityScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/activity-schedules")
public class ActivityScheduleController {

    private final ActivityScheduleService service;

    public ActivityScheduleController(ActivityScheduleService service) {
        this.service = service;
    }

    @GetMapping
    public List<ActivityScheduleDto> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityScheduleDto> get(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ActivityScheduleDto> create(@Valid @RequestBody ActivityScheduleDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ActivityScheduleDto> patch(@PathVariable Long id,
                                                     @RequestBody ActivityScheduleDto dto) {
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
