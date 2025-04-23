package com.masoud.realsimplemocroservice.repository;

import com.masoud.realsimplemocroservice.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
