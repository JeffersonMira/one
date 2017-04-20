package com.onechurch.service;

import com.onechurch.domain.User;
import com.onechurch.model.springjpa.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDAO userDao;

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
