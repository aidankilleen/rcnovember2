package ie.rc.SpringBootHelloWorld;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// our main business object for dealing with users
@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public void doSomethingWithUsers() {
		
		List<User> users = dao.getUsers();
		
		for (User u: users) {
			System.out.println(u);
		}
	}
}
