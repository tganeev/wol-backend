package com.wol.backend.dto;

import com.wol.backend.entity.*;
import java.time.OffsetDateTime;
import java.util.UUID;

public record SlotResponse(
        UUID id,
        String title,
        String description,
        OffsetDateTime startAt,
        Integer durationMinutes,
        SlotFormat format,
        SlotLevel level,
        String markers,
        Integer capacity,
        Long enrolledCount,
        SlotStatus status,
        String location,
        String hostName
        // onlineLink мы сюда НЕ добавляем, чтобы он не утекал в публичный календарь
) {}