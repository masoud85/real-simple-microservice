package com.masoud.realsimplemocroservice.controller;

import com.masoud.realsimplemocroservice.domain.Employee;
import com.masoud.realsimplemocroservice.service.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    @NonNull
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable("id") long id) {
        return employeeService.findById(id);
    }

    @PostMapping("/addEmployee")
    public Long addEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }


}
