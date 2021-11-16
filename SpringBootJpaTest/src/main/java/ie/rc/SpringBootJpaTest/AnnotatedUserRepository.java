package ie.rc.SpringBootJpaTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotatedUserRepository 
	extends JpaRepository<AnnotatedUser, Integer> {

}
