package com.kafka.Producer.Kafka_Producer.controller;


import com.kafka.Producer.Kafka_Producer.constant.KafkaConstant;
import com.kafka.Producer.Kafka_Producer.model.Movie;
import com.kafka.Producer.Kafka_Producer.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/producer")
public class Producer
{
    @Autowired
    private KafkaTemplate<String, Movie> kafkaTemplate;

    @Autowired
    private MovieService movieService;

    @PostMapping(value = "/add",consumes = "application/json",produces = "application/json")
    public void send(@RequestBody Movie movie){
        System.out.println(movie);
        movieService.addMovie(movie);
        movie.setCreationDate(LocalDateTime.now().toString());
        try{
            kafkaTemplate.send(KafkaConstant.TOPIC,movie).get();
        }
        catch (InterruptedException | ExecutionException exception){
            throw new RuntimeException(exception);
        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }

    @GetMapping
    public List<Movie> getAllMovie(){
        return movieService.getAllMovies();
    }
}
