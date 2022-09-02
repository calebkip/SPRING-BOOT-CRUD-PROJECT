package com.example.projectfour.Service;

import com.example.projectfour.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById (Long id);
    Employee updateEmployee(Employee employee,long id);
    void deleteEmployee(long id);
}
