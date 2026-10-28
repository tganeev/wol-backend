package com.wol.backend.dto;

import com.wol.backend.entity.SlotFormat;
import com.wol.backend.entity.SlotLevel;
import java.time.OffsetDateTime;

public record SlotCreateRequest(
        String title,
        String description,
        OffsetDateTime startAt,
        Integer durationMinutes,
        SlotFormat format,
        SlotLevel level,
        String markers,
        Integer capacity,
        String location,
        String onlineLink
) {}