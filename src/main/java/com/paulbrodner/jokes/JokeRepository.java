package com.paulbrodner.jokes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JokeRepository extends CrudRepository<Joke, Long> {

    @Query(value="SELECT * FROM Joke ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Joke getRandomJoke();
}
