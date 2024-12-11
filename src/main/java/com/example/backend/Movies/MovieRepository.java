package com.example.backend.Movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Movie entities.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Long> {
    // Additional custom query methods can be defined here
    boolean existsByTitle(String title); // Custom method to check email existence

}
