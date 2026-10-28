package com.wol.backend.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "enrollments", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"slot_id", "peer_id"})
})
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slot_id", nullable = false)
    private Slot slot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "peer_id", nullable = false)
    private User peer;

    @Column(nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    // Геттеры и сеттеры...
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Slot getSlot() { return slot; }
    public void setSlot(Slot slot) { this.slot = slot; }
    public User getPeer() { return peer; }
    public void setPeer(User peer) { this.peer = peer; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}