package com.example.myapp.responsePojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ProfileResponsePojo {
    

	private Integer id;
    private String name;
    private String email;
    private String number;
    
    public ProfileResponsePojo(Integer id, String name, String email, String number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.number = number;
	}
    
    public ProfileResponsePojo() {
		
	}
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "ProfileResponsePojo [id=" + id + ", name=" + name + ", email=" + email + ", number=" + number + "]";
	}
}
