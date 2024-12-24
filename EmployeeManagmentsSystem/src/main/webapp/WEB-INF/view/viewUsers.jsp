<%@page import="java.util.Objects"%>
<%@page import="com.employeemanagmentssystem.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored=false %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View All Users</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
           <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>USERNAME</th>
                    <th>PASSWORD</th>
                    <th>EMAIL</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Retrieve the list from the request scope
                    @SuppressWarnings("unchecked")
                    List<User> users = (List<User>) request.getAttribute("users");
                    for (User user : users) {
                %>
                <tr>
                    <td><%= user.getUsername() %></td>
                    <td><%= user.getPassword() %></td>
                    <td><%= user.getEmail() %></td>
                </tr>
                <%
                        }
                %>
            </tbody>
        </table>
        <a href="/home" class="btn btn-primary">Back to Home</a>
    </div>
</body>
</html>
