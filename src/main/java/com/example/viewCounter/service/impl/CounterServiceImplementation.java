package com.example.viewCounter.service.impl;
import com.example.viewCounter.dto.VideoDto;
import com.example.viewCounter.entity.Video;
import com.example.viewCounter.mapper.videoMapper;
import com.example.viewCounter.repository.CounterRepository;
import com.example.viewCounter.service.CounterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.viewCounter.constants.KafkaConstants.YOUTUBE_SUBSCRIPTION;

@Service
@AllArgsConstructor

public class CounterServiceImplementation implements CounterService {

    private CounterRepository counterRepository;
    @Autowired
    private KafkaTemplate<String,Object> template;
    @Override
    public String createVideo(VideoDto videoDto) {
        Video newvideo = videoMapper.MapToVideo(videoDto);
        template.send(YOUTUBE_SUBSCRIPTION,newvideo.getVideoTitle());
        Video saved = counterRepository.save(newvideo);
        return "video created successfully with ID: " + newvideo.getVideoId();
    }

    @Override
    public String click(String id) {
        Video video = counterRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: id not found!!" + id));
        video.setViewCount(video.getViewCount()+1);
        Video saved = counterRepository.save(video);
        return "View count updated successfully";
    }

    @Override
    public List<VideoDto> viewAllVideo() {
        List<Video> videos = counterRepository.findAll();
        return videos.stream().map(e -> videoMapper.MapToVideoDto(e)).collect(Collectors.toList());
    }

    @Override
    public String viewCountById(String id) {
        Video video = counterRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: id not found!!" + id));
        return "View count of "+video.getVideoTitle()+" is: "+video.getViewCount();
    }
}
