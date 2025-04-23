package com.masoud.realsimplemocroservice.service;

import com.masoud.realsimplemocroservice.controller.EmployeeController;
import com.masoud.realsimplemocroservice.domain.Employee;
import com.masoud.realsimplemocroservice.domain.Gender;
import com.masoud.realsimplemocroservice.exception.InvalidEmployeeException;
import com.masoud.realsimplemocroservice.repository.EmployeeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    @NonNull
    private EmployeeRepository employeeRepository;
    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Long save(Employee employee) {
        validateEmployee(employee);
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee.getId();
    }

    private void validateEmployee(Employee employee) {
        validateValue(employee.getName(), "Employee name must not be empty");
        validateValue(employee.getLastName(), "Employee last name must not be empty");
        validateValue(employee.getEmail(), "Employee email must not be empty");
        validateValue(employee.getMobileNumber(), "Employee mobile number must not be empty");
        validateGender(employee.getGender(), "Employee gender must not be empty");
    }

    private void validateGender(Gender gender, String message) {
        if (Objects.isNull(gender)) {
            logger.info(message);
            throw new InvalidEmployeeException(message);
        }
    }

    private void validateValue(String field, String message) {
        if (Objects.isNull(field) || field.trim().equals("")) {
            logger.info(message);
            throw new InvalidEmployeeException(message);
        }
    }

}
