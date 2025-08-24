package com.employeeregistration.controller;

import com.employeeregistration.dto.EmployeeRegisterRequest;
import com.employeeregistration.dto.EmployeeResponse;
import com.employeeregistration.dto.SalarySummary;
import com.employeeregistration.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @Operation(summary = "Register a new employee")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employee registered successfully")
    })
    @PostMapping("/register")
    public ResponseEntity<EmployeeResponse> register(@RequestBody EmployeeRegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @Operation(summary = "Get all employees")
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAll() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @Operation(summary = "Get employee by ID")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Get salary summary of all employees")
    @GetMapping("/salary/summary")
    public ResponseEntity<SalarySummary> salarySummary() {
        return ResponseEntity.ok(service.getSalarySummary());
    }
}
