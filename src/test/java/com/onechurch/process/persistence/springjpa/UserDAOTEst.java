package com.onechurch.process.persistence.springjpa;

import com.onechurch.process.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dc-user on 4/20/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTEst {

    @Autowired
    private UserPersistance uDao;

    @Test
    public void saveUserTest(){

        User u = new User(1L, "Jeffeson", "abc123");

        uDao.save(u);
    }

}
