package ie.rc.UsersRestWebService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	public MainController() {
		
		System.out.println("Main controller instatiated");
	}

	@GetMapping("/home")
	public String home(Model model) {
		System.out.println("home() called");
		
		model.addAttribute("name", "aidan");
		return "abc";
	}
}
