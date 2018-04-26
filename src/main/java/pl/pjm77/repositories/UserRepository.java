package pl.pjm77.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.pjm77.entities.User;

@Component
@Transactional
public class UserRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void saveUser(User entity) {
		entityManager.persist(entity);
	}
	
}