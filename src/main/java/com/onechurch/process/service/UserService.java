package com.onechurch.process.service;

import com.onechurch.process.domain.User;
import com.onechurch.process.persistence.springjpa.UserPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserPersistance userPersistance;

    @Autowired
    public UserService(UserPersistance userPersistance){
        this.userPersistance = userPersistance;
    }

    public void createUser(User user){
        if(!userPersistance.exists(user.getId())){
            userPersistance.save(user);
        }
    }

    public void deleteUser(Long id){
        if(userPersistance.exists(id)){
            userPersistance.delete(id);
        }
    }

    public Iterable<User> getAllTheMotherF(){
        return userPersistance.findAll();
    }

    public long total(){
        return userPersistance.count();
    }

    public User findByName(String name){
        return userPersistance.findByName(name);
    }
}
