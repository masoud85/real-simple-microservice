package com.masoud.realsimplemocroservice.service;

import com.masoud.realsimplemocroservice.domain.Employee;
import com.masoud.realsimplemocroservice.domain.Gender;
import com.masoud.realsimplemocroservice.exception.InvalidEmployeeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTests {

    @Autowired
    private EmployeeService employeeService;

    @Test
    @Transactional
    void nameIsMandatory() {
        Employee employee = new Employee(null, null, "B", "a.b@gmail.com", "address", "+3412345678", Gender.MALE);
        InvalidEmployeeException invalidEmployeeException = assertThrows(InvalidEmployeeException.class, () -> employeeService.save(employee));
        assertNotNull(invalidEmployeeException.getMessage());
        assertTrue(invalidEmployeeException.getMessage().contains("Employee name must not be empty"));
    }

}
