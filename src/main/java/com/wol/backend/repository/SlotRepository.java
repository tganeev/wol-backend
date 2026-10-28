package com.wol.backend.repository;

import com.wol.backend.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SlotRepository extends JpaRepository<Slot, UUID> {
}