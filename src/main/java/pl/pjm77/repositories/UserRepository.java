package pl.pjm77.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pjm77.entities.User;

@Transactional
public interface UserRepository extends JpaRepository<User,Long>{

	User findByUsername(String Username);
	
	User findById(long id);
}

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.transaction.Transactional;
//
//import org.hibernate.Criteria;
//import org.springframework.stereotype.Component;
//
//import pl.pjm77.entities.User;
//
//@Component
//@Transactional
//public class UserRepository {
//	
//	@PersistenceContext
//	EntityManager entityManager;
//	
//	public void saveUser(User entity) {
//		entityManager.persist(entity);
//	}
//	
//	public User findUserByUsername(String username) {
//		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.username LIKE :username").setParameter("username", username);
//		User user = (User) query.getSingleResult();
//		return user;
//	}             
//}