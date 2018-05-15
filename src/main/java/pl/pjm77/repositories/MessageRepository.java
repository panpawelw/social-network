package pl.pjm77.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pjm77.entities.Message;

@Transactional
public interface MessageRepository extends JpaRepository<Message, Long>{

}