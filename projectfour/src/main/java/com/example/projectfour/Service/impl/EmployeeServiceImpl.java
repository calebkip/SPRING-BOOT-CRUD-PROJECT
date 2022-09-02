package com.example.projectfour.Service.impl;

import com.example.projectfour.Exceptions.ResourceNotFoundException;
import com.example.projectfour.Model.Employee;
import com.example.projectfour.Repository.EmployeeRepository;
import com.example.projectfour.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return  employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
//       Optional< Employee> employee=employeeRepository.findById(id);
//       if(employee.isPresent()){
//           return  employee.get();
//       }else {
//           throw new ResourceNotFoundException("Employee","id","id");
//       }
        return  employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));

    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee= employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee","id",id));
                existingEmployee.setFirstname(employee.getFirstname());
                existingEmployee.setLastname(employee.getLastname());
                existingEmployee.setEmail(employee.getEmail());
                existingEmployee.setDepartment(employee.getDepartment());
                employeeRepository.save(existingEmployee);
                return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {

        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id",id));
        employeeRepository.deleteById(id);
    }


}
