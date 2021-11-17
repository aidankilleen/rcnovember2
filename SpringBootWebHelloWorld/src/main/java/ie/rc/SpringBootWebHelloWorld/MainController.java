package ie.rc.SpringBootWebHelloWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping("/db/users/edit")
	public String showEditForm(Model model, @RequestParam int id) {
		
		User user = repo.getById(id);
		model.addAttribute("user", user);
		return "editform";
	}
	
	@PostMapping("/db/users/edit")
	public String editUser(@ModelAttribute User userToEdit) {
		
		repo.save(userToEdit);
		return "useredited";
	}
	
	
	
	@RequestMapping("/db/users/add")
	public String showUserForm() {
		
		
		return "userform";
	}
	
	@RequestMapping("/db/users/doadd")
	public String addUser(@ModelAttribute User userToAdd) {
		
		repo.save(userToAdd);
		return "useradded";
	}
	
	
	
	@RequestMapping("/db/users")
	public String getUsersFromDb(Model model) {
		
		List<User> users = repo.findAll();
		
		model.addAttribute("users", users);
		
		return "userlist";
		
	}
	// /db/users/delete?id=xxx
	@RequestMapping("/db/users/delete")
	public String deleteUserConfirm(Model model, @RequestParam int id) {
		
		
		model.addAttribute("message", "user deleted");
		model.addAttribute("id", id);
		return "confirmdelete";
	}
	
	
	@RequestMapping("/db/users/dodelete")
	public String deleteUser(Model model, @RequestParam String answer, @RequestParam int id) {
		
		
		model.addAttribute("answer", answer);
		
		if (answer.equals("yes")) {
			repo.deleteById(id);
			
		}
		return "userdeleted";
	}
	
	@RequestMapping("/db/users/{id}")
	public String getUserDetails(Model model, @PathVariable("id") int id) {
		
		Optional<User> result = repo.findById(id);
		
		model.addAttribute("user", result.get());
		
		return "userdetails";
	}
	
	
	@RequestMapping("/home")
	public String homePage(Model model) {
		
		model.addAttribute("message", "this is a message");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		
		String[] messages = {"one", "two", "three"};
		model.addAttribute("messages", messages);
		return "about";
	}
	
	@RequestMapping("/user")
	public String showUser(Model model) {
		
		User user = new User(1, "Alice", "alice@gmail.com", false);
		
		model.addAttribute("user", user);
		
		return "user";
	}
	
	@RequestMapping("/users")
	public String showUsers(Model model) {

		List<User> users = new ArrayList<>();
		
		users.add(new User(1, "Alice", "alice@gmail.com", false));
		users.add(new User(2, "Bob", "bob@gmail.com", true));
		users.add(new User(3, "Carol", "carol@gmail.com", true));
		users.add(new User(4, "Dan", "dan@gmail.com", false));
		
		
		model.addAttribute("users", users);
		
		return "userlist";
	}
	
	
}










