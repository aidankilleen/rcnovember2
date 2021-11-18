package ie.rc.UsersRestWebService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("/test")
	public User testMethod() {
		
		User u = new User (1, "Alice", "alice@gmail.com", false);
		return u;
	}
	
	@GetMapping("")
	public List<User> getUsers() {
		
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		
		Optional<User> u = userRepository.findById(id);
		
		if (u.isPresent() ) {
			return new ResponseEntity<>(u.get(), HttpStatus.OK);
		} else {
			// return 404
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			
		}
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		
		userRepository.deleteById(id);
	}
	
	@PostMapping("")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		
		userRepository.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
		
		userRepository.save(user);
		return user;
	}
}
