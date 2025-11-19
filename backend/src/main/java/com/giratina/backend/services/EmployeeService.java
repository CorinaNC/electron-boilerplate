package com.giratina.backend.services;

import com.giratina.backend.dto.EmployeeTO;
import com.giratina.backend.models.Employee;
import com.giratina.backend.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEmployee(EmployeeTO employeeTO) {

        // Convert EmployeeTO to Employee entity
        Employee employee = Employee.builder()
                .employeeName(employeeTO.getEmployeeName())
                .location(employeeTO.getLocation())
                .salary(employeeTO.getSalary())
                .build();

        Employee savedEmployee = employeeRepository.save(employee);
        return "Employee created " + savedEmployee;
    }

    public String deleteEmployee(String id) {
        System.out.println(employeeRepository.findById(id));
        employeeRepository.deleteById(id);
        return "Employee deleted.";
    }

    public String updateEmployee(String id, EmployeeTO employeeTO) {
        // Find existing employee
        Optional<Employee> existingEmployeeOpt = employeeRepository.findById(id);

        if (existingEmployeeOpt.isEmpty()) {
            return "Employee with id " + id + " not found.";
        }

        Employee existingEmployee = existingEmployeeOpt.get();

        // Update fields
        existingEmployee.setEmployeeName(employeeTO.getEmployeeName());
        existingEmployee.setLocation(employeeTO.getLocation());
        existingEmployee.setSalary(employeeTO.getSalary());

        Employee savedEmployee = employeeRepository.save(existingEmployee);
        return "Employee updated: " + savedEmployee.getEmployeeName();
    }
}