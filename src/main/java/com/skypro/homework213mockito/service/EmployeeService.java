package com.skypro.homework213mockito.service;

import com.skypro.homework213mockito.model.Employee;
import com.skypro.homework213mockito.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.maxBy;

@Service
public class EmployeeService {

    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Данные работника необходимо заполнить!");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());
        this.employees.put(employee.getId(), employee);
        return employee;
    }

    public int getSalarySum() {
        return employees.values().stream().
                mapToInt(Employee::getSalary)
                .sum();
    }

    public Employee getEmployeeMinSalary() {
        return employees.values().stream().min(Comparator.comparing(Employee::getSalary)).get();
    }

    public Employee getEmployeeMaxSalary() {
        return employees.values().stream().max(Comparator.comparing(Employee::getSalary)).get();
    }

    public Employee getEmployeesMoreSalary() {
        return employees.values().stream().collect(collectingAndThen(maxBy(comparingInt(e -> e.getSalary())), Optional::get));

    }
}
