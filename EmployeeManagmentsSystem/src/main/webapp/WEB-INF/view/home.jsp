<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Employee Management</a>
        </div>
    </nav>

    <div class="container mt-4">
        <h1 class="text-center">Welcome to Employee Management System</h1>
        <p class="text-center">Select an operation to manage employees:</p>
        <div class="d-flex justify-content-center mt-4">
            <div class="list-group">
                <a href="viewEmployees" class="list-group-item list-group-item-action btn btn-primary text-white">View All Employees</a>
                <a href="viewEmployee" class="list-group-item list-group-item-action btn btn-primary text-white">View All Employees</a>
                <a href="addEmployee" class="list-group-item list-group-item-action btn btn-success text-white">Add New Employee</a>
                <a href="updateEmployee" class="list-group-item list-group-item-action btn btn-warning text-white">Update Employee</a>
                <a href="deleteEmployee" class="list-group-item list-group-item-action btn btn-danger text-white">Delete Employee</a>
            </div>
        </div>
    </div>

    <footer class="text-center mt-5">
        <p> 2024 Employee Management System | Powered by Spring Boot</p>
    </footer>
</body>
</html>
