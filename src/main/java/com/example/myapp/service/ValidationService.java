package com.example.myapp.service;

import com.example.myapp.model.Users;
import com.example.myapp.responsePojo.User;
import com.example.myapp.utility.RequestValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    private static final Logger logger = LogManager.getLogger(ValidationService.class);

    public Boolean ValidateProfile(User user){
        if (user.getName() == "" || user.getName()== null){
            throw new RequestValidationException("Please provide user name..");
        }else if (user.getNumber() == ""){
            throw new RequestValidationException("Please provide valid mobile number..");
        } else if (user.getId() == null) {
            throw new RequestValidationException("Please provide valid id..");
        } else if (user.getEmail()==null || user.getEmail()=="") {
            throw new RequestValidationException("Please Provide valid email..");
        } else if (user.getPassword()==null || user.getPassword()=="") {
            throw new RequestValidationException("Please provide valid password...");
        }
        return true;
    }
}
