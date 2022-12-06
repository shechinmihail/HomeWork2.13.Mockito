package com.skypro.homework213mockito.service;

import com.skypro.homework213mockito.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    @Autowired
    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public List<Employee> getEmployeesFromDepartment(int idDepartment) {
        return employeeService.getAllEmployees().stream().filter(employee -> employee.getDepartment() == idDepartment)
                .collect(Collectors.toList());
    }


    public int getSalaryOfDepartment(int idDepartment) {
        return getEmployeesFromDepartment(idDepartment).stream().mapToInt(Employee::getSalary).sum();
    }


    public int getMaxSalaryOfDepartment(int idDepartment) {
        return getEmployeesFromDepartment(idDepartment).stream().mapToInt(Employee::getSalary).max().orElseThrow();
    }


    public int getMinSalaryOfDepartment(int idDepartment) {
        return getEmployeesFromDepartment(idDepartment).stream().mapToInt(Employee::getSalary).min().orElseThrow();
    }


    public Map<Integer, List<Employee>> employeesGroupedByDepartment() {
        return employeeService.getAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
