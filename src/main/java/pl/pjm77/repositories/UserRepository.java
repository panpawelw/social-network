package pl.pjm77.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pjm77.entities.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String Username);
	
	User findById(long id);
	
//	@Modifying
//	@Query("update User u set u.username = ?1, u.password = ?2, u.email = ?3 where u.id = ?4")
//	void updateUserInfoById(String username, String password, String email, long Id);
}