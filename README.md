# Employee Management System

## Overview

This is a simple Employee Management System built using **Spring Boot** and **Spring Security**. The system is designed to manage employees with different roles: **Admin**, **Manager**, and **Employee**. It incorporates **database-based authentication and authorization** with custom logic to ensure role-based access control.This project showcases my skills in performing CRUD operations using **Spring Data & Repository** and demonstrates a strong understanding of the **Spring framework** , **Spring Boot**
and **spring security**.

## Technologies Used
- **Core Java** & **Advanced Java**
- **Servlets & JSP**
- **Spring MVC** (Model-View-Controller Architecture)
- **Spring DI** (Dependency Injection)
- **Spring Data** (JPA and Spring Data Repositories)
- **Repository-Service-Controller**(Architecture)
- **Spring Security** (For Authentication and Authorization)
- **MySQL** (Database)


## Features

- **Role-Based Access Control**: 
  - **Admin**: Has full access to add employees,update employees and delete employees.
  - **Manager**: Can manage employees(like add or update), but with limited access(no 
                 delete employee)compared to Admin.
  - **Employee**: Limited access, can view home page only.
  
- **Database-based Authentication & Authorization**: 
  Custom logic implemented using Spring Security for access control based on roles.

- **CRUD Operations for Employees**: Admins can perform CRUD operations (Create, Read, 
   Update, Delete) for employees.

## Custom Security Implementation
### User Class
A custom `User` class represents the employee data and their role (Admin, Manager, or Employee). It contains user-specific details and is integrated with Spring Security to represent authenticated users.

### UserDao Interface
The `UserDao` interface provides data access methods for CRUD operations on the `User` entity. This interface is implemented by a DAO class that interacts with the database.

### UserService Class
The `UserService` class contains the business logic to handle user-related operations. It provides services like user creation, authentication, and fetching user details.

### UserRepository
The `UserRepository` extends **JpaRepository** and is used to manage database interactions for the `User` entity.

### Custom UserDetails and UserDetailsService
We create a custom `UserDetails` implementation that provides user-specific details to Spring Security for authentication. The `UserDetailsService` is implemented to load user data by username and provide it for authentication.

### DaoAuthenticationProvider
We use **DaoAuthenticationProvider** to authenticate users. This provider fetches user details from the database and validates the credentials against the stored data.

### HttpSecurity and Authorization Manager
Using **HttpSecurity**, we configure URL-based access control, ensuring that different roles (Admin, Manager, Employee) have appropriate access to different parts of the system.

## Project Structure
This is the basic structure of the Employee Management System project. The project follows a layered architecture, separating concerns into distinct packages for better maintainability and scalability.

### Explanation of Major Packages:
1. **com.employeemanagementsystem.pojo**
   - Contains the **POJOs** or **entities** like `User.java`,'Role.java', which 
     represent the employee and their role.

2. **com.employeemanagementsystem.dao**
   - **DAO Layer**: Contains interfaces like `UserDao.java`, responsible for 
       interacting with the database to perform CRUD operations.

3. **com.employeemanagementsystem.service**
   - **Service Layer**: Handles the business logic of the application. For example, `UserService.java` contains methods to manage user operations such as authentication, CRUD actions, etc.

4. **com.employeemanagementsystem.repository**
   - **Repository Layer**: Contains the Spring Data JPA repositories like `UserRepository.java` that extend `JpaRepository` for database interactions.

5. **com.employeemanagementsystem.security**
   - Contains classes related to **Spring Security** for user authentication and authorization, such as `MyUserDetails.java`, `MyUserDetailsService.java`, and `DaoAuthenticationProvider.java`.

6. **com.employeemanagementsystem.controller**
   - **Controller Layer**: Manages HTTP requests from users and interacts with the service layer. For instance, `UserController.java` is responsible for handling employee-related endpoints.

7. **resources**
   - Contains configuration files like **`application.properties`** .

8. **views**
  -We use view Folder inside Web-INF Folder to represent views.

### Key Files:
- **EmployeeManagementSystemApplication.java**: The entry point of the Spring Boot application.
- **application.properties**: Contains configurations like database connection,view resolver,dialect etc.

This structure is designed to separate concerns and make the application easier to maintain, with each layer handling a specific responsibility.

  
- **Pre-configured Users**:
  - **Admin**: `mohan` (Role: Admin)
  - **Manager**: `abhinash` (Role: Manager)
  - **Employee**: `vaibhav`, `sushant` (Role: Employee)

## Project Setup
### Prerequisites

- **JDK 17 **
- **Spring Boot** (version 3.4.2)
- **Maven** (or **Meaven** for alternative build tool)
- **MySQL Database** setup

## Contributing
We welcome contributions from the community! Whether you're fixing bugs, improving the documentation, or adding new features, your contributions help make this project better. Here are a few ways you can get involved:

### How to Contribute
1. **Fork the Repository**: Start by forking this repository to your own GitHub account and clone it to your local machine.
   
   ```bash
   git clone https://github.com/RitikBankhede/EmployeeManagementsSystem.git
