package org.example;

import org.example.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {

    @Test
    void createUserObjectTest() {

        User user = new User("John", "john@test.com");

        assertEquals("John", user.getName());
        assertEquals("john@test.com", user.getEmail());
    }

    @Test
    void setUserIdTest() {

        User user = new User();
        user.setId(10);

        assertEquals(10, user.getId());
    }
}
