package com.giratina.backend.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder(setterPrefix = "set")
@Document(collection = "users")
public class User {
    @Id
    private String id;

	private String name;
	private String email;
	private String password;
}