package com.skypro.homework213mockito.model;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int department;
    private final int salary;
    private static int counter = 1;
    private final int id;

    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firtname='" + firstName + '\'' +
                ", lostname='" + lastName + '\'' +
                ", departament=" + department +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}
