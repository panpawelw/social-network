package pl.pjm77.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pjm77.entities.Twat;

@Transactional
public interface TwatRepository extends JpaRepository<Twat,Long>{

	List<Twat> findAllByOrderByCreatedDesc();
	
	List<Twat> findAllByUserIdOrderByCreatedDesc(long id);
	
	Twat findById(long id);
}