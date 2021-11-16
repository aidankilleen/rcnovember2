package ie.rc.SpringBootJpaTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaTestApplication implements CommandLineRunner {

	@Autowired
	private UserDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		try {
		dao.deleteUser(12);
		}
		catch(Exception ex) {
			// do nothing
		}
		
		User newUser = new User("XXXNEW", "XXXnew.user@gmail.com", false);
		
		
		User addedUser = dao.addUser(newUser);
		
		
		System.out.println(addedUser);
		
		
		User u5 = dao.getUser(5);
		
		System.out.println(u5);
		
		
		u5.setName("CHANGED");
		u5.setEmail("changed@gmail.com");
		u5.setActive(!u5.isActive());
		
		
		dao.updateUser(u5);
		
		
		
		
		List<User> users = dao.getUsers();
		
		for (User u: users) {
			
			System.out.println(u);
		}
	}

}
