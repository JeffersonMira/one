package com.onechurch.process.service.Impl;

import com.onechurch.process.domain.User;
import com.onechurch.process.persistence.springjpa.UserPersistance;
import com.onechurch.process.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserPersistance userPersistance;

    @Autowired
    public UserServiceImpl(UserPersistance userPersistance){
        this.userPersistance = userPersistance;
    }

    public void createUser(User user){
        User userPersisted = userPersistance.findByUsername(user.getUsername());

        if(null == userPersisted){
            userPersistance.save(user);
        }
    }

    public void updateUser(User user){
        if(userPersistance.exists(user.getId())){
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

    public User findUserById(Long id){
        return userPersistance.findOne(id);
    }

    public long total(){
        return userPersistance.count();
    }

    public User findByName(String username){
        return userPersistance.findByUsername(username);
    }
}
