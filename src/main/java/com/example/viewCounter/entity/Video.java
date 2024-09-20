package com.example.viewCounter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Counter")
public class Video {
    @Id
    private String videoId;
    @Column(name="video_title")
    private String videoTitle;
    @Column(name="view_count")
    private long viewCount;

    @PrePersist
    public void setId() {
        this.videoId = generateAlphanumericId();
    }

    private String generateAlphanumericId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();
    }
}
