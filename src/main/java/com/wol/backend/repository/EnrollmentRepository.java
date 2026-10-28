package com.wol.backend.repository;

import com.wol.backend.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EnrollmentRepository extends JpaRepository<Enrollment, UUID> {
}