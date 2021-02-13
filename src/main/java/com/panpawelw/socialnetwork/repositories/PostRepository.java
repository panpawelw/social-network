package com.panpawelw.socialnetwork.repositories;

import java.util.List;

import javax.transaction.Transactional;

import com.panpawelw.socialnetwork.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface PostRepository extends JpaRepository<Post,Long>{

    List<Post> findAllByOrderByCreatedDesc();

    List<Post> findAllByUserIdOrderByCreatedDesc(long id);

    Post findById(long id);
}