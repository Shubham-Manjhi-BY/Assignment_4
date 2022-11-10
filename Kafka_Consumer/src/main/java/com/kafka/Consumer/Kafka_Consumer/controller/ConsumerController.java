package com.kafka.Consumer.Kafka_Consumer.controller;

import com.kafka.Consumer.Kafka_Consumer.model.Movie;
import com.kafka.Consumer.Kafka_Consumer.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController
{
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovie(){
        return movieService.getAllMovies();
    }
}