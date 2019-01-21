package com.onechurch.Domain;

import com.onechurch.process.domain.User;
import org.junit.Test;

/**
 * Created by dc-user on 4/20/2017.
 */
public class UserTest {

    @Test
    public void shouldCreateUserObject(){
        User u = new User(1L, "Jeffeson", "JeffersonMira", "abc123", false);
        System.out.print(u.toString());
    }

}
