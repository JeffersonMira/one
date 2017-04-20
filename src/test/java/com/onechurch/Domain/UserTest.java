package com.onechurch.Domain;

import com.onechurch.domain.User;
import org.junit.Test;

/**
 * Created by dc-user on 4/20/2017.
 */
public class UserTest {

    @Test
    public void shouldCreateUserObject(){
        User u = new User(1L, "Jeffeson", "abc123");
        System.out.print(u.toString());
    }

}
