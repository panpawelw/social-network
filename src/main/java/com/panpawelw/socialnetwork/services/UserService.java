package com.panpawelw.socialnetwork.services;

import com.panpawelw.socialnetwork.entities.User;
import com.panpawelw.socialnetwork.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository repository;

  @Autowired
  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public User findUserById(long id) {
    return repository.findById(id);
  }

  public long saveUser(User user) {
    return repository.saveAndFlush(user).getId();
  }
}
