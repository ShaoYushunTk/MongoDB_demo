package com.example.service;

import com.example.pojo.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Yushun Shao
 * @Date 2023/8/1 14:54
 * @Description user service
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User insertUser(String name, int age){
        User user = new User(name, age);
        return userRepository.insert(user);
    }

    public void insertUserList(List<User> users){
        userRepository.insert(users);
    }

    public User getUserById(String id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUserByName(String name){
        Criteria criteria = Criteria.where("name").is(name);
        Query query = new Query(criteria);
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }

    public List<User> getUserByAgeRange(int gtAge, int ltAge){
        Criteria criteria = Criteria.where("age").lte(ltAge).gte(gtAge);
        Query query = new Query(criteria);
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public void deleteByName(String name){
        userRepository.deleteByName(name);
    }

    public void deleteByAge(int age){
        Criteria criteria = Criteria.where("age").is(age);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, "users");
    }

}
