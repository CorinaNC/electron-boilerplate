package com.giratina.backend.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(value = "employees")
@Data
@Builder
public class EmployeeTO {
    @Id
    private String id;
    @Field(name = "employee_name")
    private String employeeName;
    private String location;
    private Double salary;
}
