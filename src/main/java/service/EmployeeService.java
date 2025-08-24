package com.employeeregistration.service;

import com.employeeregistration.dto.EmployeeRegisterRequest;
import com.employeeregistration.dto.EmployeeResponse;
import com.employeeregistration.dto.SalarySummary;
import com.employeeregistration.entity.Employee;
import com.employeeregistration.repository.EmployeeRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public EmployeeResponse register(EmployeeRegisterRequest request) {
        Employee emp = new Employee();
        emp.setName(request.getName());
        emp.setUsername(request.getUsername());
        emp.setPassword(passwordEncoder.encode(request.getPassword()));
        emp.setSalary(request.getSalary());
        Employee saved = repository.save(emp);
        return new EmployeeResponse(saved.getId(), saved.getName(), saved.getUsername(), saved.getSalary());
    }

    public List<EmployeeResponse> getAllEmployees() {
        return repository.findAll().stream()
                .map(e -> new EmployeeResponse(e.getId(), e.getName(), e.getUsername(), e.getSalary()))
                .collect(Collectors.toList());
    }

    public EmployeeResponse getById(Long id) {
        Employee e = repository.findById(id).orElseThrow();
        return new EmployeeResponse(e.getId(), e.getName(), e.getUsername(), e.getSalary());
    }

    public SalarySummary getSalarySummary() {
        List<Employee> employees = repository.findAll();
        double total = employees.stream().mapToDouble(Employee::getSalary).sum();
        double avg = employees.isEmpty() ? 0 : total / employees.size();
        int count = employees.size();
        return new SalarySummary(total, avg, count);
    }
}
