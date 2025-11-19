package com.giratina.backend;
import com.giratina.backend.dto.EmployeeTO;
import com.giratina.backend.models.Employee;
import com.giratina.backend.repositories.EmployeeRepository;
import com.giratina.backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createEmployee(@RequestBody EmployeeTO employeeTO) {
        String result = employeeService.createEmployee(employeeTO);
        return result;
    }
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteEmployee(@RequestBody EmployeeTO employeeTO) {
        String result = employeeService.deleteEmployee(employeeTO.getId());
        return result;
    }
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateEmployee(@PathVariable String id, @RequestBody EmployeeTO employeeTO) {
        String result = employeeService.updateEmployee(id, employeeTO);
        return result;
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @GetMapping("/test")
    public String testConnection() {
        try {
            long count = employeeRepository.count();
            return "MongoDB connection successful! Total employees: " + count;
        } catch (Exception e) {
            return "MongoDB connection failed: " + e.getMessage();
        }
    }


}
