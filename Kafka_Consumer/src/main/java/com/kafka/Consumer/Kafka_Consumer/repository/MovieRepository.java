package com.kafka.Consumer.Kafka_Consumer.repository;

import com.kafka.Consumer.Kafka_Consumer.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>
{

}