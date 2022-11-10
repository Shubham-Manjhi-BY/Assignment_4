package com.kafka.Producer.Kafka_Producer.service;

import com.kafka.Producer.Kafka_Producer.model.Movie;
import com.kafka.Producer.Kafka_Producer.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService
{
    @Autowired
    MovieRepository repository;

    public List<Movie> getAllMovies()
    {
        return repository.findAll();
    }

    public void addMovie(Movie movie)
    {
        repository.save(movie);
    }
}
