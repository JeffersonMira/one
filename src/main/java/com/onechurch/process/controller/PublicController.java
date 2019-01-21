package com.onechurch.process.controller;

import com.onechurch.process.domain.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dc-user on 4/20/2017.
 */
@RequestMapping("/")
@RestController
public class PublicController {

    protected PublicController(){
        super();
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Greeting") String value){
        return new Greeting(1,value);
    }

    @RequestMapping(path="/location" , method = RequestMethod.GET)
    public String location(){
        return "You are on a public location";
    }
}
