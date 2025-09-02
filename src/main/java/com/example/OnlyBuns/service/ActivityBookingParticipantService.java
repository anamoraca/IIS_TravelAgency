package com.example.OnlyBuns.service;

import com.example.OnlyBuns.dto.ActivityBookingParticipantDto;
import com.example.OnlyBuns.mapper.ActivityBookingParticipantMapper;
import com.example.OnlyBuns.model.ActivityBooking;
import com.example.OnlyBuns.model.ActivityBookingParticipant;
import com.example.OnlyBuns.repository.ActivityBookingParticipantRepository;
import com.example.OnlyBuns.repository.ActivityBookingRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityBookingParticipantService {

    private final ActivityBookingParticipantRepository participantRepo;
    private final ActivityBookingRepository bookingRepo;

    public ActivityBookingParticipantService(ActivityBookingParticipantRepository participantRepo,
                                             ActivityBookingRepository bookingRepo) {
        this.participantRepo = participantRepo;
        this.bookingRepo = bookingRepo;
    }

    public List<ActivityBookingParticipantDto> list() {
        return participantRepo.findAll().stream()
                .map(ActivityBookingParticipantMapper::toDto)
                .collect(Collectors.toList());
    }

    public ActivityBookingParticipantDto get(Long id) {
        ActivityBookingParticipant e = participantRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participant not found: " + id));
        return ActivityBookingParticipantMapper.toDto(e);
    }

    public ActivityBookingParticipantDto create(ActivityBookingParticipantDto dto) {
        ActivityBooking booking = bookingRepo.findById(dto.activityBookingId)
                .orElseThrow(() -> new EntityNotFoundException("ActivityBooking not found: " + dto.activityBookingId));

        ActivityBookingParticipant saved =
                participantRepo.save(ActivityBookingParticipantMapper.toEntity(dto, booking));

        return ActivityBookingParticipantMapper.toDto(saved);
    }

    public ActivityBookingParticipantDto patch(Long id, ActivityBookingParticipantDto dto) {
        ActivityBookingParticipant e = participantRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participant not found: " + id));

        ActivityBooking booking = null;
        if (dto.activityBookingId != null) {
            booking = bookingRepo.findById(dto.activityBookingId)
                    .orElseThrow(() -> new EntityNotFoundException("ActivityBooking not found: " + dto.activityBookingId));
        }

        ActivityBookingParticipantMapper.apply(e, dto, booking);
        return ActivityBookingParticipantMapper.toDto(participantRepo.save(e));
    }

    public void delete(Long id) {
        if (!participantRepo.existsById(id)) {
            throw new EntityNotFoundException("Participant not found: " + id);
        }
        participantRepo.deleteById(id);
    }
}
