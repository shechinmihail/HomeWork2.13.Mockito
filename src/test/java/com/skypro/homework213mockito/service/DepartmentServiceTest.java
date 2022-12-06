package com.skypro.homework213mockito.service;

import com.skypro.homework213mockito.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    private List<Employee> employeeList;

    @BeforeEach
    public void setUp() {
        Employee employee1 = new Employee("Petr", "Ivanov", 2, 50000);
        Employee employee2 = new Employee("Vasya", "Petrov", 1, 20000);
        Employee employee3 = new Employee("Sergei", "Sidorov", 3, 40000);
        Employee employee4 = new Employee("Olya", "Sergeeva", 4, 30000);
        Employee employee5 = new Employee("Ivan", "Kozlov", 1, 35000);
        Employee employee6 = new Employee("Misha", "Orlov", 2, 55000);
        Employee employee7 = new Employee("Sasha", "Ivanova", 3, 47000);
        Employee employee8 = new Employee("Luda", "Sidorova", 4, 28000);

        employeeList = new ArrayList<>(List.of(employee1,
                employee2, employee3, employee4, employee5, employee6, employee7, employee8));

        when(employeeService.getAllEmployees()).thenReturn(employeeList);
    }


    @Test // getEmployeesFromDepartment
    public void shouldReturnEmployeesFromDepartment() {
        Collection<Employee> employees = this.departmentService.getEmployeesFromDepartment(2);
        assertThat(employees).hasSize(2)
                .contains(
                        employeeList.get(0),
                        employeeList.get(5));
    }

    @Test // getSalaryOfDepartment
    public void shouldReturnSumSalaryOfDepartment() {
        assertEquals(105000, departmentService.getSalaryOfDepartment(2));
    }

    @Test // getMaxSalaryOfDepartment
    public void shouldReturnMaxSalaryOfDepartment() {
        assertEquals(47000, departmentService.getMaxSalaryOfDepartment(3));
    }

    @Test // getMinSalaryOfDepartment
    public void shouldReturnMinSalaryOfDepartment() {
        final int department = 1;
        final int actual = employeeList.stream().filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getSalary).min().orElse(0);
        final int expected = departmentService.getMinSalaryOfDepartment(department);

        assertEquals(expected, actual);
    }

    @Test // employeesGroupedByDepartment
    public void shouldReturnEmployeesGroupedByDepartment() {
        final Map<Integer, List<Employee>> actual = employeeList.stream().map(Employee::getDepartment)
                .collect(Collectors.toSet()).stream()
                .collect(Collectors.toMap(deport -> deport, deport -> employeeList.stream().filter(e -> e.getDepartment() == deport)
                        .collect(Collectors.toList())));
        final Map<Integer, List<Employee>> expected = departmentService.employeesGroupedByDepartment();

        assertEquals(expected, actual);
    }
}