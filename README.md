# 🎓 Student Course Management System (SCMS)

A **Java JDBC + MySQL** based console application that efficiently manages **Students, Courses, and Enrollments** using a layered architecture (DAO + Service). The project demonstrates real-world database operations, object-oriented programming principles, and relational database design.

---

## 🚀 Features

### 👨‍🎓 Student Management

* Add Student
* View All Students
* Search Student by ID
* Update Student Details
* Delete Student

### 📚 Course Management

* Add Course
* View All Courses
* Search Course
* Delete Course

### 📝 Enrollment Management

* Enroll Student into a Course
* View All Enrollments
* Remove Enrollment
* View Courses of a Student
* View Students in a Course

### 📊 Dashboard

* Total Students
* Total Courses
* Total Enrollments
* Most Popular Course

### ✅ Data Validation

* Student existence validation
* Course existence validation
* Duplicate enrollment prevention
* Input validation for age, email, and required fields

---

# 🏗️ Project Architecture

```
                Main.java
                    │
        ┌───────────┴───────────┐
        │                       │
    Service Layer
        │
        ▼
      DAO Layer
        │
        ▼
 JDBC (PreparedStatement)
        │
        ▼
      MySQL Database
```

---

# 📂 Project Structure

```
Student-Course-Management-System
│
├── src
│   └── main
│       └── java
│           └── com
│               └── gayatri
│                   └── scms
│
│                       ├── database
│                       │     └── DBConnection.java
│                       │
│                       ├── dao
│                       │     ├── StudentDAO.java
│                       │     ├── CourseDAO.java
│                       │     ├── EnrollmentDAO.java
│                       │     └── DashboardDAO.java
│                       │
│                       ├── model
│                       │     ├── Student.java
│                       │     └── Course.java
│                       │
│                       ├── service
│                       │     ├── StudentService.java
│                       │     ├── CourseService.java
│                       │     ├── EnrollmentService.java
│                       │     └── DashboardService.java
│                       │
│                       └── Main.java
│
└── pom.xml
```

---

# 🛠️ Technologies Used

* Java 21
* JDBC
* MySQL
* MySQL Connector/J
* IntelliJ IDEA
* Git & GitHub

---

# 🗄️ Database Design

### Students

| Column     | Type                              |
| ---------- | --------------------------------- |
| student_id | INT (Primary Key, Auto Increment) |
| name       | VARCHAR                           |
| age        | INT                               |
| email      | VARCHAR (Unique)                  |

---

### Courses

| Column      | Type                  |
| ----------- | --------------------- |
| course_id   | VARCHAR (Primary Key) |
| course_name | VARCHAR               |
| duration    | VARCHAR               |
| credits     | INT                   |

---

### Enrollments

| Column     | Type                  |
| ---------- | --------------------- |
| student_id | INT (Foreign Key)     |
| course_id  | VARCHAR (Foreign Key) |

This table implements a **Many-to-Many Relationship** between Students and Courses.

---

# 🔗 SQL Concepts Implemented

* CREATE TABLE
* INSERT
* SELECT
* UPDATE
* DELETE
* WHERE
* JOIN
* GROUP BY
* COUNT()
* Foreign Keys
* Unique Constraints
* Prepared Statements

---

# 💻 How to Run

### 1. Clone the repository

```bash
git clone https://github.com/<your-username>/Student-Course-Management-System.git
```

### 2. Open the project

Open the project using **IntelliJ IDEA**.

### 3. Create the database

```sql
CREATE DATABASE scms_db;
```

### 4. Import the SQL schema

Run the provided SQL file to create all required tables.

### 5. Update database credentials

Edit `DBConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/scms_db";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

### 6. Run

Execute `Main.java`.

---

# 📸 Console Preview

```
====================================
 Student Course Management System
====================================

1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student

6. Add Course
7. View Courses
8. Search Course
9. Delete Course

10. Enroll Student
11. View Enrollments
12. Remove Enrollment
13. View Student Courses
14. View Course Students

15. Dashboard

0. Exit
```

---

# 🎯 Learning Outcomes

This project helped strengthen my understanding of:

* Object-Oriented Programming (OOP)
* Layered Architecture (DAO Pattern)
* JDBC Programming
* MySQL Database Design
* Relational Database Management
* CRUD Operations
* SQL JOINs and Foreign Keys
* Exception Handling
* Input Validation
* Git and GitHub

---

# 🚀 Future Enhancements

* Java Swing GUI
* Spring Boot REST API
* Spring Data JPA
* Authentication & User Roles
* Attendance Management
* Marks & Grades Module
* Faculty Management
* Export Reports to PDF/Excel

---

# 👩‍💻 Author

**Gayatri Potdar**

* GitHub: https://github.com/<Gayatri2203>

If you found this project useful, feel free to ⭐ the repository!
