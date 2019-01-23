package com.onechurch.process.controller;

import com.onechurch.process.domain.User;
import com.onechurch.process.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


// http://www.restapitutorial.com/lessons/httpmethods.html
@RequestMapping("v1")
@RestController
public class UserController {
    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    protected UserController(){
        super();
    }

    @RequestMapping(path="admin/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        userServiceImpl.createUser(user);
    }

    @RequestMapping(path="admin/users/{id}", method = RequestMethod.DELETE)
//    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable(name="id") long id){
        userServiceImpl.deleteUser(id);
    }

    @RequestMapping(path="users", method = RequestMethod.GET)
    public Iterable<User>  findAll(){
        return userServiceImpl.getAllTheMotherF();
    }

    @RequestMapping(path="users/{id}", method = RequestMethod.GET)
    public User  findById(@PathVariable(name="id") long id){
        return userServiceImpl.findUserById(id);
    }

    @RequestMapping(path="admin/users", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user){
        userServiceImpl.updateUser(user);
    }

}
