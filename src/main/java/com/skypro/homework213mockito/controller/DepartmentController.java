package com.skypro.homework213mockito.controller;

import com.skypro.homework213mockito.model.Employee;
import com.skypro.homework213mockito.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesFromDepartment(@PathVariable("id") int idDepartment) {
        return departmentService.getEmployeesFromDepartment(idDepartment);
    }

    @GetMapping("/{id}salary/sum")
    public int getSalaryOfDepartment(@PathVariable("id") int idDepartment) {
        return departmentService.getSalaryOfDepartment(idDepartment);
    }

    @GetMapping("/{id}salary/max")
    public int getMaxSalaryOfDepartment(@PathVariable("id") int idDepartment) {
        return departmentService.getMaxSalaryOfDepartment(idDepartment);
    }

    @GetMapping("/{id}salary/min")
    public int getMinSalaryOfDepartment(@PathVariable("id") int idDepartment) {
        return departmentService.getMinSalaryOfDepartment(idDepartment);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> employeesGroupedByDepartment() {
        return departmentService.employeesGroupedByDepartment();
    }
}
