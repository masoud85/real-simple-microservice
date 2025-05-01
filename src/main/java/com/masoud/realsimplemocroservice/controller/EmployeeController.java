package com.masoud.realsimplemocroservice.controller;

import com.masoud.realsimplemocroservice.domain.Employee;
import com.masoud.realsimplemocroservice.service.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Vector;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    @NonNull
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        Vector list = new Vector();
        return employeeService.findAll();
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable("id") long id) {
        return employeeService.findById(id);
    }

    @PostMapping("/addEmployee")
    public Long addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public void deleteEmployeeById(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/updateEmployee")
    public void deleteEmployeeById(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

}
