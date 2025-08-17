# Employee Management Backend

This project was created as part of a backend task during my work at **Averta Strategy Pvt Ltd.**  
It showcases **employee management functionality with CRUD APIs**, built using **Spring Boot** and **MySQL**.

---

## 🚀 Features

- Add, update, view, and delete employees
- Manage salary records for employees
- Search employees by department and name
- Pagination support for employees
- RESTful APIs with JSON responses
- Built using Spring Boot layered architecture (Controller → Service → DAO → Repository)

---

## 🛠️ Tech Stack

- Java (Spring Boot)  
- Spring Data JPA / Hibernate  
- MySQL  
- Maven  
- Postman (for API testing)  

---

## 🔗 API Endpoints

### 👨‍💼 Employee APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/employee` | Add a new employee |
| GET    | `/employee` | Fetch all employees |
| GET    | `/employee/singleEmployee/{employeeId}` | Fetch one employee by ID |
| PUT    | `/employee/{employeeId}` | Update employee by ID |
| DELETE | `/employee/{employeeId}` | Delete employee by ID |
| GET    | `/employee/employeeInPages?page=0&size=3` | Fetch employees with pagination |
| GET    | `/employee/findByDept/{employeeDept}` | Fetch employees by department |
| GET    | `/employee/findByDeptAndName/{employeeDept}/{employeeName}` | Fetch employees by department and name |

---

### 💰 Salary APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/salary/{employeeId}` | Add salary for an employee |
| GET    | `/salary` | Fetch all salaries |
| GET    | `/salary/{employeeId}` | Fetch salary of an employee by ID |
| PUT    | `/salary/{employeeId}` | Update salary of an employee |
| DELETE | `/salary/{salaryId}` | Delete a salary by salary ID |
