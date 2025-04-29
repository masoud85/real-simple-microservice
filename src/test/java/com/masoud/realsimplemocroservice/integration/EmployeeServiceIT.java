package com.masoud.realsimplemocroservice.integration;

import com.masoud.realsimplemocroservice.domain.Employee;
import com.masoud.realsimplemocroservice.domain.Gender;
import com.masoud.realsimplemocroservice.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeServiceIT {

    @Autowired
    private EmployeeService employeeService;

    Employee employee = new Employee(null, "A", "B", "a.b@gmail.com", "address", "+3412345678", Gender.MALE);

    @Test
    void saveEmployeeCorrectly() {
        Long id = employeeService.save(employee);
        assertNotEquals(null, id);
    }

    @Test
    void removeExistingEmployee() {
        Long savedEmployeeId = employeeService.save(employee);
        assertNotNull(employeeService.findById(savedEmployeeId));
        employeeService.deleteEmployeeById(savedEmployeeId);
        assertNull(employeeService.findById(savedEmployeeId));
    }

}
