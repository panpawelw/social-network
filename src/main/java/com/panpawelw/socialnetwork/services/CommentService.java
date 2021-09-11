package com.panpawelw.socialnetwork.services;

import com.panpawelw.socialnetwork.entities.Comment;
import com.panpawelw.socialnetwork.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

  private final CommentRepository repository;

  @Autowired
  public CommentService(CommentRepository repository) {
    this.repository = repository;
  }

  public List<Comment> findAllByPostId(long id) {
    return repository.findAllByPostIdOrderByCreatedDesc(id);
  }

  public long save(Comment comment) {
    return repository.saveAndFlush(comment).getId();
  }
}
