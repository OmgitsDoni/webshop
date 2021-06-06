package hu.citec.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.citec.spring.repository.ProductRepository;
import hu.citec.spring.service.ProductService;

@Controller
//@RequestMapping("/")
public class LoginController {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ProductService service;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String doLogin(@RequestParam String username, Model model) {
		
		if (service.findUser(username)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", username);
			return "redirect:/product/";
		} else {
			model.addAttribute("wrong", "Rossz felhasználónév és/vagy jelszó!");
			return "login";
		}
	}
}