package com.example.OnlyBuns.controller;

import com.example.OnlyBuns.dto.ActivityCreateDto;
import com.example.OnlyBuns.dto.ActivityResponseDto;
import com.example.OnlyBuns.dto.ActivityUpdateDto;
import com.example.OnlyBuns.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @GetMapping
    public List<ActivityResponseDto> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityResponseDto> get(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ActivityResponseDto> create(@Valid @RequestBody ActivityCreateDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ActivityResponseDto> patch(@PathVariable Long id,
                                                     @RequestBody ActivityUpdateDto dto) {
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
