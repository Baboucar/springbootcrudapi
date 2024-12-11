package com.example.backend.Movies;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Represents a Movie entity mapped to the 'movies' table in the database.
 */
@Entity
@Table(name = "movies")
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Lombok annotation to generate a no-arguments constructor
@AllArgsConstructor // Lombok annotation to generate a constructor with all arguments
public class MovieModel {

    /**
     * The primary key of the Movie entity.
     * Uses GenerationType.IDENTITY to auto-increment the ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The title of the movie.
     * Mapped to the 'first_name' column in the database.
     */
    @Column(name = "title", nullable = false)
    private String title;


        /**
     * The movie description of the movie.
     * Mapped to the 'movieDescription' column in the database.
     */
    @Column(name = "movieDescription", nullable = false)
    private String movieDescription;
        /**
     * The quality of the movie.
     * Mapped to the 'quality' column in the database.
     */
    @Column(name = "quality", nullable = false)
    private String quality;
        /**
     * The genre of the movie.
     * Mapped to the 'genre' column in the database.
     */
    @Column(name = "genre", nullable = false)
    private String genre;
        /**
     * The durationof the movie.
     * Mapped to the 'duration' column in the database.
     */
    @Column(name = "duration", nullable = false)
    private String duration;
        /**
     * The release date of the movie.
     * Mapped to the 'releaseDate' column in the database.
     */
    @Column(name = "releaseDate", nullable = true)
    private String releaseDate;
        /**
     * The poster url of the movie.
     * Mapped to the 'poster' column in the database.
     */
    @Column(name = "poster", nullable = true)
    private String poster;
        /**
     * The average rating of the movie.
     * Mapped to the 'avrRating' column in the database.
     */
    @Column(name = "avrRating", nullable = true)
    private int avrRating;
        /**
     * The user ids of the movie.
     * Mapped to the 'userIds' column in the database.
     */
    @Column(name = "userIds", nullable = true)
    private String userIds;

    /**
     * The view count of the movie.
     * Mapped to the 'viewCount' column in the database.
     */
    @Column(name = "viewCount", nullable = true)
    private int viewCount;

}
