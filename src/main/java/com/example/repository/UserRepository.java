package com.example.repository;

import com.example.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Yushun Shao
 * @Date 2023/8/1 14:47
 * @Description user repository
 * MongoRepository<T, ID> T为实体类， ID为id的类型
 */

public interface UserRepository extends MongoRepository<User, String> {
    /**
     * 根据名称删除
     * @param name
     */
    void deleteByName(String name);
}
