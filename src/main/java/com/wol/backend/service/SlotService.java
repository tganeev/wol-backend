package com.wol.backend.service;

import com.wol.backend.dto.SlotCreateRequest;
import com.wol.backend.dto.SlotResponse;
import com.wol.backend.entity.Slot;
import com.wol.backend.entity.User;
import com.wol.backend.repository.SlotRepository;
import com.wol.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SlotService {

    private final SlotRepository slotRepository;
    private final UserRepository userRepository;

    public SlotService(SlotRepository slotRepository, UserRepository userRepository) {
        this.slotRepository = slotRepository;
        this.userRepository = userRepository;
    }

    public List<SlotResponse> getAllSlots() {
        return slotRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public SlotResponse createSlot(SlotCreateRequest request, String userEmail) {
        // Берем пользователя из токена (email)
        User host = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Host not found"));

        Slot slot = new Slot();
        slot.setTitle(request.title());
        slot.setDescription(request.description());
        slot.setStartAt(request.startAt());
        slot.setDurationMinutes(request.durationMinutes());
        slot.setFormat(request.format());
        slot.setLevel(request.level());
        slot.setMarkers(request.markers());
        slot.setCapacity(request.capacity());
        slot.setLocation(request.location());
        slot.setOnlineLink(request.onlineLink());
        slot.setHost(host);

        Slot saved = slotRepository.save(slot);
        return mapToResponse(saved);
    }

    private SlotResponse mapToResponse(Slot slot) {
        return new SlotResponse(
                slot.getId(),
                slot.getTitle(),
                slot.getDescription(),
                slot.getStartAt(),
                slot.getDurationMinutes(),
                slot.getFormat(),
                slot.getLevel(),
                slot.getMarkers(),
                slot.getCapacity(),
                (long) slot.getEnrollments().size(),
                slot.getStatus(),
                slot.getLocation(),
                slot.getHost().getName()
        );
    }
}