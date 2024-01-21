package com.narainox.blogappliactionbackend.repository;

import com.narainox.blogappliactionbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserNameAndPassword(String userName,String password);
}
