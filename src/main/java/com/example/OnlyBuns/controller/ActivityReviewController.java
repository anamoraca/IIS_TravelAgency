package com.example.OnlyBuns.controller;

import com.example.OnlyBuns.dto.ActivityReviewDto;
import com.example.OnlyBuns.service.ActivityReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/activity-reviews")
public class ActivityReviewController {

    private final ActivityReviewService service;

    public ActivityReviewController(ActivityReviewService service) {
        this.service = service;
    }

    @GetMapping
    public List<ActivityReviewDto> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityReviewDto> get(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ActivityReviewDto> create(@Valid @RequestBody ActivityReviewDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ActivityReviewDto> patch(@PathVariable Long id,
                                                   @RequestBody ActivityReviewDto dto) {
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
