package com.example.myapp.responsePojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ProfileRequestPojo {
    private Integer id;
    
    public ProfileRequestPojo(Integer id) {
		super();
		this.id = id;
	}
    
    public ProfileRequestPojo() {
		
	}

	@Override
	public String toString() {
		return "ProfileRequestPojo [id=" + id + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
