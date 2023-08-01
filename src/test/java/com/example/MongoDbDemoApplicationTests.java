package com.example;

import com.example.pojo.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MongoDbDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetAll() {
        List<User> users = userService.getAll();
        System.out.println(users);
    }

    @Test
    void testGetUserById(){
        User user = userService.getUserById("64c8c9bc2d5c0427b20cf25a");

    }

    @Test
    void testGetUserByName(){
        List<User> users = userService.getUserByName("tom");
        System.out.println(users);
    }

    @Test
    void testGetUserByAgeRange(){
        List<User> users = userService.getUserByAgeRange(9, 16);
        System.out.println(users);
    }

    @Test
    void testInsert(){
        userService.insertUser("test", 99);
        testGetAll();
    }

    @Test
    void testDeleteByName(){
        userService.deleteByName("Tom");
        testGetAll();
    }

    @Test
    void testDeleteByAge(){
        testGetAll();
        userService.deleteByAge(99);
        testGetAll();
    }

}
