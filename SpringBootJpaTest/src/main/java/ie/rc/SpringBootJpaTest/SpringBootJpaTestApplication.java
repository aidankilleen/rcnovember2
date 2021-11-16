package ie.rc.SpringBootJpaTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaTestApplication implements CommandLineRunner {

	@Autowired
	AnnotatedUserRepository repo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<AnnotatedUser> users = repo.findAll();
		
		for (AnnotatedUser u: users) {
			
			System.out.println(u);
		}
	}

}
