package com.skypro.homework213mockito.service;

import com.skypro.homework213mockito.model.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private EmployeeService employeeService;
    private List<Employee> employeeList;

    @Test
    void getAllEmployees() {
        Employee employee1 = new Employee("Petr", "Ivanov", 2, 50000);
        Employee employee2 = new Employee("Vasya", "Petrov", 1, 20000);
        Employee employee3 = new Employee("Sergei", "Sidorov", 3, 40000);

        employeeList = new ArrayList<>(List.of(employee1,
                employee2, employee3));

        List<Employee> actual = new ArrayList<>();
        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee3);

        assertEquals(employeeList, actual);

    }

    @Test
    void addEmployee() {
    }

    @Test
    void getSalarySum() {
        final int expected = 110000;
        final int actual = employeeList.stream().mapToInt(Employee::getSalary).sum();

        assertEquals(expected, actual);
    }

    @Test
    void getEmployeeMinSalary() {
        final Employee actual = employeeList.stream().min(Comparator.comparingInt(Employee::getSalary)).get();
        final Employee expected = employeeService.getEmployeeMinSalary();

        assertEquals(expected, actual);

    }

    @Test
    void getEmployeeMaxSalary() {
        final Employee actual = employeeList.stream().max(Comparator.comparingInt(Employee::getSalary)).get();
        final Employee expected = employeeService.getEmployeeMaxSalary();

        assertEquals(expected, actual);

    }

    @Test
    void getEmployeesMoreSalary() {
    }
}