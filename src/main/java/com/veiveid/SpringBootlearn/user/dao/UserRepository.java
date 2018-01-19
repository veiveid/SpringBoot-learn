package com.veiveid.SpringBootlearn.user.dao;

import com.veiveid.SpringBootlearn.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    User findByNameAndAge(String name,Integer age);

}