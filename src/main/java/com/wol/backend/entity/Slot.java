package com.wol.backend.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "slots")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id", nullable = false)
    private User host;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private OffsetDateTime startAt;

    @Column(nullable = false)
    private Integer durationMinutes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SlotFormat format;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SlotLevel level;

    // Маркеры (ограничения) можно хранить как строку через запятую или JSON
    private String markers;

    private Integer capacity; // Для онлайн-слотов

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SlotStatus status = SlotStatus.SCHEDULED;

    private String location; // Для офлайн-слотов
    private String onlineLink; // Для онлайн-слотов (отдается только после записи)

    // Связь с записями (пирами)
    @OneToMany(mappedBy = "slot", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enrollment> enrollments = new HashSet<>();

    // Геттеры и сеттеры...
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public User getHost() { return host; }
    public void setHost(User host) { this.host = host; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public OffsetDateTime getStartAt() { return startAt; }
    public void setStartAt(OffsetDateTime startAt) { this.startAt = startAt; }
    public Integer getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }
    public SlotFormat getFormat() { return format; }
    public void setFormat(SlotFormat format) { this.format = format; }
    public SlotLevel getLevel() { return level; }
    public void setLevel(SlotLevel level) { this.level = level; }
    public String getMarkers() { return markers; }
    public void setMarkers(String markers) { this.markers = markers; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public SlotStatus getStatus() { return status; }
    public void setStatus(SlotStatus status) { this.status = status; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getOnlineLink() { return onlineLink; }
    public void setOnlineLink(String onlineLink) { this.onlineLink = onlineLink; }
    public Set<Enrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(Set<Enrollment> enrollments) { this.enrollments = enrollments; }
}