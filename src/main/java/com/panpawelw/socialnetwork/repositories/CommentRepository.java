package com.panpawelw.socialnetwork.repositories;

import java.util.List;

import javax.transaction.Transactional;

import com.panpawelw.socialnetwork.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostIdOrderByCreatedDesc(long id);

}