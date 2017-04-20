package com.onechurch.model.springjpa;

import com.onechurch.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by dc-user on 4/20/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTEst {

    @Autowired
    private UserDAO uDao;

    @Test
    public void saveUserTest(){

        User u = new User(1L, "Jeffeson", "abc123");

        uDao.save(u);
    }

}
