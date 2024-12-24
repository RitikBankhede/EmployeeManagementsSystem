<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <div>
      <p style="text-align:center;color:${MSGCOLOR}">${MSG}</p>
    </div>
    <div class="container mt-4">
        <h1 class="text-center">Welcome to Employee Management System</h1>
        <p class="text-center">Select an operation to manage employees:</p>
        <div class="d-flex justify-content-center mt-4">
            <div class="list-group">
                <a href="viewUsers" class="list-group-item list-group-item-action btn btn-primary text-blue" style="color:black">View All User</a>
                <a href="addUser" class="list-group-item list-group-item-action btn btn-success text-blue">Add New User</a>
                <a href="updateUser" class="list-group-item list-group-item-action btn btn-warning text-blue">Update User</a>
                <a href="deleteUser" class="list-group-item list-group-item-action btn btn-danger text-blue">Delete User</a>
            </div>
        </div>
    </div>

    <footer class="text-center mt-5">
        <p> 2025 Employee Management System | Created By Ritik Bankhede</p>
        <a href="logout">Click To Logout</a>
    </footer>
</body>
</html>
