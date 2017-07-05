package theFallen;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FallenController {

	@Autowired FallenUserRepository repository;
	
	//Landingpage that everyone can see even without login creds
	@RequestMapping("/")
	public String landingPage(){
		return "landingpage";
	}
	
	//Custom login page 
	@RequestMapping("/login")
	public String loginPage(Model fallenModel){
		fallenModel.addAttribute("fallenCredsObject", new FallenUser());
		return "login";
	}
	
	//Custom signup page to add new users
	@RequestMapping("/signup")
	public String signupPage(@Valid FallenUser fallenCredsObject, BindingResult thatWhichBinds, Model anotherModel){
		repository.save(fallenCredsObject);
		anotherModel.addAttribute("fallenCredsObject", fallenCredsObject);
		return "signuppage";
	}
	
}
