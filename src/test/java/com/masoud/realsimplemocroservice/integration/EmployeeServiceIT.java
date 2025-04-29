package com.masoud.realsimplemocroservice.integration;

import com.masoud.realsimplemocroservice.domain.Employee;
import com.masoud.realsimplemocroservice.domain.Gender;
import com.masoud.realsimplemocroservice.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class EmployeeServiceIT {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void saveEmployeeCorrectly() {
        Employee employee = new Employee(null, "A", "B", "a.b@gmail.com", "address", "+3412345678", Gender.MALE);
        Long id = employeeService.save(employee);
        assertNotEquals(null, id);
    }

}
