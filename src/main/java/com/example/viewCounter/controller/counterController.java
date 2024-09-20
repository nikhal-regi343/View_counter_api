package com.example.viewCounter.controller;

import com.example.viewCounter.dto.VideoDto;
import com.example.viewCounter.service.CounterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/counter")
public class counterController {
    private CounterService counterService;

    @PostMapping
    public ResponseEntity<String> createVideo(@Valid @RequestBody VideoDto videodto){
        return new ResponseEntity<>(counterService.createVideo(videodto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VideoDto>> viewAllVideo(){

        return ResponseEntity.ok(counterService.viewAllVideo());
    }

    @GetMapping("{id}")
    public ResponseEntity<String> viewCountById(@PathVariable("id") String id){
        return ResponseEntity.ok(counterService.viewCountById(id));
    }
    @PatchMapping("{id}")
    public ResponseEntity<String> click(@PathVariable("id") String id){
        return new ResponseEntity<>(counterService.click(id),HttpStatus.ACCEPTED);
    }
}
