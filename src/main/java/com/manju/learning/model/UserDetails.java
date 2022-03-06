package com.manju.learning.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection="UserDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
	
	@Id
	private int id;
	private String name;
	private String gender;

}
