package com.skypro.homework213mockito.controller;

import com.skypro.homework213mockito.model.Employee;
import com.skypro.homework213mockito.record.EmployeeRequest;
import com.skypro.homework213mockito.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employee/salary/sum")
    public int getSalarySum() {
        return this.employeeService.getSalarySum();
    }

    @GetMapping("/employee/salary/min")
    public Employee getEmployeeMinSalary() {
        return this.employeeService.getEmployeeMinSalary();
    }

    @GetMapping("/employee/salary/max")
    public Employee getEmployeeMaxSalary() {
        return this.employeeService.getEmployeeMaxSalary();
    }

    @GetMapping("/employee/high-salary")
    public Employee getEmployeeMoreSalary() {
        return this.employeeService.getEmployeesMoreSalary();
    }
}
