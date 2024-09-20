package com.example.viewCounter.service;

import com.example.viewCounter.dto.VideoDto;

import java.util.List;

public interface CounterService {
    String createVideo(VideoDto videoDto);
    String click(String id);
    List<VideoDto> viewAllVideo();

    String viewCountById(String id);
}
