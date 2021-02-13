package com.panpawelw.socialnetwork.repositories;

import javax.transaction.Transactional;

import com.panpawelw.socialnetwork.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String Username);

    User findById(long id);
}