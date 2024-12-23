package com.employeemanagmentssystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagmentssystem.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
