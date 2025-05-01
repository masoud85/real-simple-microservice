package com.masoud.realsimplemocroservice.integration;

import com.masoud.realsimplemocroservice.domain.Employee;
import com.masoud.realsimplemocroservice.domain.Gender;
import com.masoud.realsimplemocroservice.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class EmployeeServiceIT {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private EmployeeService employeeService;

    Employee employee = new Employee(null, "Ali", "Karimi", "ali.karimi@gmail.com", "address", "+3412345678", Gender.MALE);

    @Test
    void saveEmployeeCorrectly() {
        Long id = employeeService.saveEmployee(employee);
        assertNotEquals(null, id);
    }

    @Test
    void removeExistingEmployee() {
        Long savedEmployeeId = employeeService.saveEmployee(employee);
        assertNotNull(employeeService.findById(savedEmployeeId));
        employeeService.deleteEmployeeById(savedEmployeeId);
        assertNull(employeeService.findById(savedEmployeeId));
    }

    @Test
    void updateEmployeeCorrectly() {
        Long savedEmployeeId = employeeService.saveEmployee(employee);
        String name = employeeService.findById(savedEmployeeId).getName();
        employee.setName("AnotherName");
        employeeService.updateEmployee(employee);
        assertNotEquals(name , employeeService.findById(savedEmployeeId).getName());
    }

    @Test
    public void findByIdCorrectly() {
        Long id = employeeService.saveEmployee(employee);
        Employee employee = employeeService.findById(id);
        assertNotNull(employee);
    }

}
