package com.employeemanagmentssystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employeemanagmentssystem.pojo.User;

public interface UserRepository extends JpaRepository<User,String> {
}
