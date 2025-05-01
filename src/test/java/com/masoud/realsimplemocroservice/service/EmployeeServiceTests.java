package com.masoud.realsimplemocroservice.service;

import com.masoud.realsimplemocroservice.domain.Employee;
import com.masoud.realsimplemocroservice.domain.Gender;
import com.masoud.realsimplemocroservice.exception.InvalidEmployeeException;
import com.masoud.realsimplemocroservice.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    @Transactional
    void nameIsMandatory() {
//        Mock the repository
//        EmployeeRepository mockRepo = mock(EmployeeRepository.class);
//
//         Use real service with mocked repository
//        EmployeeService employeeService = new EmployeeService(mockRepo);

        Employee employee = new Employee(null, null, "B", "a.b@gmail.com", "address", "+3412345678", Gender.MALE);
        InvalidEmployeeException invalidEmployeeException = assertThrows(InvalidEmployeeException.class, () -> employeeService.saveEmployee(employee));
        assertNotNull(invalidEmployeeException.getMessage());
        assertTrue(invalidEmployeeException.getMessage().contains("Employee name must not be empty"));
    }

}
