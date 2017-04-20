package com.onechurch.process.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDAO userDao){
        this.userDao = userDao;
    }

    public void createUser(User user){
        if(!userDao.exists(user.getId())){
            userDao.save(user);
        }
    }

    public void deleteUser(Long id){
        if(userDao.exists(id)){
            userDao.delete(id);
        }
    }

    public Iterable<User> getAllTheMotherF(){
        return userDao.findAll();
    }

    public long total(){
        return userDao.count();
    }

    public User findByName(String name){
        return userDao.findByName(name);
    }
}
