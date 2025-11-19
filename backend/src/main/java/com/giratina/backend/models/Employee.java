package com.giratina.backend.models;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Builder
@Document(value = "employee")
public class Employee {
    private String id;
    private String employeeName;
    private String location;
    private BigDecimal salary;
}
