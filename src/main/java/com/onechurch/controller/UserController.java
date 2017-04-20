package com.onechurch.controller;

import com.onechurch.domain.Greeting;
import com.onechurch.domain.User;
import com.onechurch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dc-user on 4/20/2017.
 */
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    protected UserController(){
        super();
    }

    @RequestMapping(path="/create" , method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }


    @RequestMapping(path="/greeting" , method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Greeting") String value){
        return new Greeting(1,value);
    }


}
