package com.example.viewCounter.mapper;

import com.example.viewCounter.dto.VideoDto;
import com.example.viewCounter.entity.Video;

public class videoMapper {
    public static Video MapToVideo(VideoDto videodto){
        return new Video(
                videodto.getVideoId(),
                videodto.getVideoTitle(),
                videodto.getViewCount()
        );
    }

    public static VideoDto MapToVideoDto(Video video){
        return new VideoDto(
                video.getVideoId(),
                video.getVideoTitle(),
                video.getViewCount()
        );
    }
}
