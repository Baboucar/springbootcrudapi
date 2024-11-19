package com.example.backend;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Represents an Employee entity mapped to the 'employees' table in the database.
 */
@Entity
@Table(name = "employees")
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Lombok annotation to generate a no-arguments constructor
@AllArgsConstructor // Lombok annotation to generate a constructor with all arguments
public class EmployeeModel {

    /**
     * The primary key of the Employee entity.
     * Uses GenerationType.IDENTITY to auto-increment the ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The first name of the employee.
     * Mapped to the 'first_name' column in the database.
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * The last name of the employee.
     * Mapped to the 'last_name' column in the database.
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * The email address of the employee.
     * .
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;
}
