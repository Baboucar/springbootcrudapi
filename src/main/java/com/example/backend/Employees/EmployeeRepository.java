package com.example.backend.Employees;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Employee entities.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    // Additional custom query methods can be defined here
    boolean existsByEmail(String email); // Custom method to check email existence

}

