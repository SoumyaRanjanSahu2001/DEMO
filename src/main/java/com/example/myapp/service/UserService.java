package com.example.myapp.service;

import com.example.myapp.model.Users;
import com.example.myapp.repository.UserRepository;
import com.example.myapp.responsePojo.ProfileResponsePojo;
import com.example.myapp.responsePojo.User;
import com.example.myapp.utility.UserNotFoundException;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> getProfile(Integer id){
        logger.info("Entering into getProfile..........");
        ProfileResponsePojo res = new ProfileResponsePojo();
        Users user = new Users();
       try {
           user = userRepository.findById(id).orElse(null);
           if (user==null){
               throw new UserNotFoundException("User not found..Please provide valid id.");
           }
       }catch (UserNotFoundException n){
           logger.info("User Not found exception...");
           return new ResponseEntity<>( "User Not exist with the given id. Please provide a valid id..", HttpStatus.OK);
       }catch (Exception e){
           logger.info("Exception Occured"+e.getMessage());
       }

           res.setEmail(user.getEmail());
           res.setId(user.getId());
           res.setName(user.getName());
           res.setNumber(user.getNumber());

        return  new ResponseEntity<>(res,HttpStatus.OK);
    }

    public String setProfile( User user){
        logger.info("Entering into setProfile............");

        try{
            Users u = new Users(user.getId(),user.getName(),user.getEmail(),user.getPassword(),user.getNumber());
            userRepository.save(u);
        }catch (Exception e){
            logger.info("Exception occurred: "+e.getMessage());
        }
        return "Profile set successfully....";
    }
}
