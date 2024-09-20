package com.example.viewCounter.repository;

import com.example.viewCounter.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepository extends JpaRepository<Video,String> {
}
