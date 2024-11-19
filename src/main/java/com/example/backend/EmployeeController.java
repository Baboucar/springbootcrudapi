package com.example.backend;



import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Employee entities.
 * Handles API requests under the '/api/employees' path.
 */

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    /**
     * Injects the EmployeeRepository to interact with the database.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Retrieves all employees.
     * @return A list of Employee objects.
     */
    @GetMapping
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Creates a new employee.
     * @param employee The employee data from the request body.
     * @return The saved Employee object.
     */
    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeModel employee) {
        // Check if the email already exists
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            return ResponseEntity.badRequest().body("An employee with this email already exists.");
        }

        // Save the employee if the email is unique
        EmployeeModel savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(savedEmployee);
    }


    /**
     * Retrieves an employee by ID.
     * @param id The ID of the employee.
     * @return A ResponseEntity containing the Employee object.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable Long id) {
       EmployeeModel employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + id));
        return ResponseEntity.ok(employee);
    }

    /**
     * Updates an existing employee.
     * @param id The ID of the employee to update.
     * @param employeeDetails The updated employee data.
     * @return A ResponseEntity containing the updated Employee object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(
            @PathVariable Long id, @RequestBody EmployeeModel employeeDetails) {

        EmployeeModel employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + id));

        // Update the employee's details using Lombok-generated setters
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());

        // Save the updated employee
        EmployeeModel updatedEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok(updatedEmployee);
    }

    /**
     * Deletes an employee by ID.
     * @param id The ID of the employee to delete.
     * @return A ResponseEntity with HTTP status.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        EmployeeModel employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + id));

        employeeRepository.delete(employee);

        return ResponseEntity.noContent().build();
    }
}
