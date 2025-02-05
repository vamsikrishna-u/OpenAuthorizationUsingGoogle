package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Users {
	
	@Id
	private int id;
	@NotNull
	private String userName;
	@NotNull
	@Size(min=3)
	private String password;
	private String email;
	

}
