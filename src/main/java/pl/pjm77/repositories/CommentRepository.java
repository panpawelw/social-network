package pl.pjm77.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pjm77.entities.Comment;

@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long> {

}