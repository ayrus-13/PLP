package com.cg.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ams.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
