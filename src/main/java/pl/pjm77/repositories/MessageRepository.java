package pl.pjm77.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pjm77.entities.Message;
import pl.pjm77.entities.User;

@Transactional
public interface MessageRepository extends JpaRepository<Message, Long>{
	
	List<Message> findAllByReceiverIdOrderByCreatedDesc(long id);
	
	List<Message> findAllBySenderIdOrderByCreatedDesc(long id);

	Message findById(long id);
}