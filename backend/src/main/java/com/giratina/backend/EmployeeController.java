package com.giratina.backend;
import com.giratina.backend.dto.EmployeeTO;
import com.giratina.backend.models.Employee;
import com.giratina.backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createEmployee(@RequestBody EmployeeTO employee) {
        return employeeService.createEmployee(employee);
    }
}
