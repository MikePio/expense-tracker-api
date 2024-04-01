package com.java.expensetrackerapi.db.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/users")
public class UserController {
  
  @PostMapping("/registrer")
  public String registerUser(@RequestBody Map<String, Object> userMap) {
    //TODO: process POST request
    
    String firstName = (String) userMap.get("firstName");
    String lastName = (String) userMap.get("lastName");
    String email = (String) userMap.get("email");
    String password = (String) userMap.get("password");

    return firstName + " " + lastName + " " + email + " " + password;
  }
  

}
