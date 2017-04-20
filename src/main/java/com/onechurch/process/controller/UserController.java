package com.onechurch.process.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dc-user on 4/20/2017.
 */
@RequestMapping("/user")
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

    @RequestMapping(path="/delete/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable(name="id") long id){
        userService.deleteUser(id);
    }

    @RequestMapping(path="/findall")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Iterable<User>  findAll(){
        return userService.getAllTheMotherF();
    }

}
