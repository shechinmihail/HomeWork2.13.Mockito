package com.skypro.homework213mockito.service;

import com.skypro.homework213mockito.model.Employee;
import com.skypro.homework213mockito.record.EmployeeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class EmployeeServiceTest {
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        this.employeeService = new EmployeeService();
        Stream.of(
                new EmployeeRequest("Petr", "Ivanov", 2, 50000),
                new EmployeeRequest("Vasya", "Petrov", 1, 20000),
                new EmployeeRequest("Sergei", "Sidorov", 3, 40000),
                new EmployeeRequest("Olya", "Sergeeva", 4, 30000),
                new EmployeeRequest("Ivan", "Kozlov", 1, 35000),
                new EmployeeRequest("Misha", "Orlov", 2, 55000)
        ).forEach(employeeService::addEmployee);
    }

    @Test
    void getAllEmployees() {
        Collection<Employee> employees = employeeService.getAllEmployees();
        assertThat(employees).hasSize(6);
        assertThat(employees).first().extracting(Employee::getFirstName)
                .isEqualTo("Petr");
    }

    @Test
    void addEmployee() {
        EmployeeRequest request = new EmployeeRequest("Test", "Test", 2, 20000);
        Employee result = employeeService.addEmployee(request);
        assertEquals(request.getFirstName(), result.getFirstName());
        assertEquals(request.getLastName(), result.getLastName());
        assertEquals(request.getDepartment(), result.getDepartment());
        assertEquals(request.getSalary(), result.getSalary());
        assertThat(employeeService.getAllEmployees()).contains(result);

    }

    @Test
    void getSalarySum() {
        int sum = employeeService.getSalarySum();
        assertThat(sum).isEqualTo(230000);
    }

    @Test
    void getEmployeeMinSalary() {
        Employee actual = employeeService.getEmployeeMinSalary();
        assertThat(actual).isNotNull().extracting(Employee::getFirstName).isEqualTo("Vasya");
    }

    @Test
    void getEmployeeMaxSalary() {
        Employee actual = employeeService.getEmployeeMaxSalary();
        assertThat(actual).isNotNull().extracting(Employee::getFirstName).isEqualTo("Misha");
    }
}