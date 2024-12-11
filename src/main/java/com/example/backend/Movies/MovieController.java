package com.example.backend.Movies;




import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Movie entities.
 * Handles API requests under the '/api/movies' path.
 */

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "http://localhost:5173")
public class MovieController {

    /**
     * Injects the EmployeeRepository to interact with the database.
     */
    @Autowired
    private MovieRepository movieRepository;

    /**
     * Retrieves all movies.
     * @return A list of Movie objects.
     */
    @GetMapping
    public List<MovieModel> getAllMovies() {
        return movieRepository.findAll();
    }

    /**
     * Creates a new movie.
     * @param movie The movie data from the request body.
     * @return The saved Movie object.
     */
    @PostMapping
    public ResponseEntity<?> createMovie(@RequestBody MovieModel movie) {
        // Check if the email already exists
        if (movieRepository.existsByTitle(movie.getTitle())) {
            return ResponseEntity.badRequest().body("An movie with this title already exists.");
        }

        // Save the movie if the email is unique
        MovieModel savedMovie = movieRepository.save(movie);
        return ResponseEntity.ok(savedMovie);
    }


    /**
     * Retrieves an movie by ID.
     * @param id The ID of the movie.
     * @return A ResponseEntity containing the Employee object.
     */
    @GetMapping("/{id}")
    public ResponseEntity<MovieModel> getMovieById(@PathVariable Long id) {
        MovieModel movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with ID: " + id));
        return ResponseEntity.ok(movie);
    }

    /**
     * Updates an existing movie.
     * @param id The ID of the movie to update.
     * @param movieDetails The updated movie data.
     * @return A ResponseEntity containing the updated Movie object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<MovieModel> updateMovie(
            @PathVariable Long id, @RequestBody MovieModel movieDetails) {

        MovieModel movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with ID: " + id));

        // Update the employee's details using Lombok-generated setters
        movie.setTitle(movieDetails.getTitle());
        movie.setMovieDescription(movieDetails.getMovieDescription());
        movie.setQuality(movieDetails.getQuality());
        movie.setGenre(movieDetails.getGenre());
        movie.setDuration(movieDetails.getDuration());
        movie.setReleaseDate(movieDetails.getReleaseDate());
        movie.setPoster(movieDetails.getPoster());
        movie.setAvrRating(movieDetails.getAvrRating());
        movie.setUserIds(movieDetails.getUserIds());
        movie.setViewCount(movieDetails.getViewCount());

        // Save the updated employee
        MovieModel updatedMovie = movieRepository.save(movie);

        return ResponseEntity.ok(updatedMovie);
    }

    /**
     * Deletes an movie by ID.
     * @param id The ID of the movie to delete.
     * @return A ResponseEntity with HTTP status.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        MovieModel movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with ID: " + id));

        movieRepository.delete(movie);

        return ResponseEntity.noContent().build();
    }
}
