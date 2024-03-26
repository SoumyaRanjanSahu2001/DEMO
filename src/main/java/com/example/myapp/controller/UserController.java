package com.example.myapp.controller;

import com.example.myapp.model.Users;
import com.example.myapp.myException;
import com.example.myapp.responsePojo.*;
import com.example.myapp.service.UserService;
import com.example.myapp.service.ValidationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private ValidationService validationService;

    @GetMapping("/")
    public String getmessage(){
        return "Hii";
    }
    @GetMapping("/getmessage")
    public String getmessage(){
        return "Welcome";
    }
    @PostMapping("/getProfile")
    public ResponseEntity<?> getUserData(@RequestBody ProfileRequestPojo req){
         return service.getProfile(req.getId());
    }
    @PostMapping("/setProfile")
    public String setUserData(@Valid @RequestBody User user, BindingResult result){
        try {
            if (result.hasErrors()) throw new myException(result.getFieldError().getDefaultMessage());
        }catch (myException e){
            return e.getMessage();
        }
        validationService.ValidateProfile(user);

         return service.setProfile(user);
    }

    @PostMapping("/setxml")
    public ResponseEntity<?> convertJsonToXML(@RequestBody Payee user) throws JAXBException {
        StringWriter sw = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(Payee.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(user,sw);

        // Set Content-Type header to indicate XML format
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/xml");

        // Return ResponseEntity with XML content and appropriate headers
        return new ResponseEntity<>(sw.toString(), headers, HttpStatus.OK);
    }

    @PostMapping("/setJson")
    public ResponseEntity<?> convertXMLToJSON(@RequestBody String xml) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(ReqPay.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ReqPay Payee = (ReqPay) unmarshaller.unmarshal(new StringReader(xml));

        System.out.println(Payee);
        String p = new Gson().toJson(Payee);
        // Set Content-Type header to indicate XML format
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        // Return ResponseEntity with XML content and appropriate headers
        return new ResponseEntity<>(p, headers, HttpStatus.OK);
    }
}
