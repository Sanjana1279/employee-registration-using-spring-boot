# Employee Registration API

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![H2 Database](https://img.shields.io/badge/H2-Database-orange)](https://www.h2database.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](#)
# Employee Registration API

A **Spring Boot REST API** for employee management with **H2 in-memory database**, **Spring Security (Basic Auth)**, and **Swagger UI** for API documentation and testing.  

This project allows you to **register employees**, **fetch employee details**, and **compute salary statistics**.

---

## **Table of Contents**

- [Features](#features)  
- [Technologies Used](#technologies-used)  
- [Project Structure](#project-structure)  
- [Setup Instructions](#setup-instructions)  
- [API Endpoints](#api-endpoints)  
- [Testing](#testing)  
- [H2 Database](#h2-database)  
- [Swagger UI](#swagger-ui)  
- [Security](#security)  
- [GitHub Repository](#github-repository)

---

## **Features**

- Employee Registration with **username, password, name, salary**  
- Employee authentication using **Spring Security (Basic Auth)**  
- Fetch all employees or individual employee by ID  
- Compute **total salary, average salary, and employee count**  
- In-memory database (H2) for easy testing  
- Swagger UI integration for interactive API documentation  

---

## **Technologies Used**

- Java 17  
- Spring Boot 3.x  
- Spring Data JPA  
- Spring Security  
- H2 Database (In-memory)  
- Maven for dependency management  
- Swagger / OpenAPI for documentation  

---
## **Project Structure**
employee-registration/
│
├─ src/main/java/com/employeeregistration
│ ├─ config/
│ │ └─ SecurityConfig.java
│ ├─ controller/
│ │ └─ EmployeeController.java
│ ├─ dto/
│ │ ├─ EmployeeRegisterRequest.java
│ │ ├─ EmployeeResponse.java
│ │ └─ SalarySummary.java
│ ├─ entity/
│ │ └─ Employee.java
│ ├─ repository/
│ │ └─ EmployeeRepository.java
│ ├─ security/
│ │ └─ CustomUserDetailsService.java
│ ├─ service/
│ │ └─ EmployeeService.java
│ └─ EmployeeRegistrationApplication.java
│
├─ src/main/resources/
│ ├─ application.properties
│
└─ pom.xml

---

## **API Endpoints**
| Method | Endpoint                      | Description           | Auth Required    |
| ------ | ----------------------------- | --------------------- | ---------------- |
| POST   | /api/employees/register       | Register new employee | No               |
| GET    | /api/employees                | Get all employees     | Yes (Basic Auth) |
| GET    | /api/employees/{id}           | Get employee by ID    | Yes (Basic Auth) |
| GET    | /api/employees/salary/summary | Get salary statistics | Yes (Basic Auth) |


---
## **Testing**
**1.Postman**

**Register:**

**POST** http://localhost:8081/api/employees/register
Body (JSON):
{
  "name": "Sanjana",
  "username": "sanjana123",
  "password": "pass123",
  "salary": 50000
}


**Get all employees:**

GET http://localhost:8081/api/employees
Authorization: Basic Auth
Username: sanjana123
Password: pass123

---
## **H2 Database**

Access the H2 console:

http://localhost:8081/h2-console


JDBC URL: jdbc:h2:mem:testdb

User: sa

Password: (leave empty)

---
## **Security**

Uses Spring Security Basic Authentication

Passwords are stored encrypted using BCrypt

/register endpoint is public; all others require login

Example query to see all employees:

SELECT * FROM EMPLOYEE;

---
## **GitHub Repository**

Repository URL:
https://github.com/username/employee-registration](https://github.com/Sanjana1279/employee-registration-using-spring-boot
