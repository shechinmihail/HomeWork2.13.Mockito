package com.skypro.homework213mockito.service;

import com.skypro.homework213mockito.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


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


    }

    @Test // getSalaryOfDepartment
    public void shouldReturnSumSalaryOfDepartment() {
    }

    @Test // getMaxSalaryOfDepartment
    public void shouldReturnMaxSalaryOfDepartment() {
        employeeService.getAllEmployees();
        assertEquals(20000, departmentService.getMaxSalaryOfDepartment(3));
    }

    @Test // getMinSalaryOfDepartment
    public void shouldReturnMinSalaryOfDepartment() {
        final int department = 1;

        final int now = employeeList.stream().filter(e->e.getDepartment() == department)
                .mapToInt(Employee::getSalary).min().orElse(0);
        final int shouldBe = departmentService.getMinSalaryOfDepartment(department);

        assertEquals(shouldBe, now);
    }

    @Test // employeesGroupedByDepartment
    public void shouldReturnEmployeesGroupedByDepartment() {

    }
}