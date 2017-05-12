package com.onechurch.process.controller;

import com.onechurch.process.domain.Greeting;
import com.onechurch.process.domain.User;
import com.onechurch.process.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


// http://www.restapitutorial.com/lessons/httpmethods.html
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

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name="id") long id){
        userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User>  findAll(){
        return userService.getAllTheMotherF();
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public User  findById(@PathVariable(name="id") long id){
        return userService.findUserById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

}
