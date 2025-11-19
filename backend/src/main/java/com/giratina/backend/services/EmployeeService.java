package com.giratina.backend.services;

import com.giratina.backend.dto.EmployeeTO;
import com.giratina.backend.models.Employee;
import com.giratina.backend.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEmployee(EmployeeTO employee) {
        try {
            Employee emp = Employee.builder().employeeName(employee.getEmployeeName()).salary(employee.getSalary()).location(employee.getLocation()).build();
            employeeRepository.save(emp);
        } catch (Exception e) {
            // handle
        }
        return "Success!";
    }
}
