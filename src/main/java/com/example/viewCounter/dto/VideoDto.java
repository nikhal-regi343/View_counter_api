package com.example.viewCounter.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class VideoDto {
    @Size(min = 5,max = 50,message = "Give a Proper ID")
    private String videoId;
    private String videoTitle;
    private long viewCount;

}
