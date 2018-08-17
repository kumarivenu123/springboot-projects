package com.spring.validations;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ValidationController {

	@GetMapping("/")
	public ModelAndView loginPage() {
		return new ModelAndView("login", "user", new User());
	}

	@PostMapping("/login")
	public ModelAndView validateLoginPage(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("login");
		} else {
			String userName = user.getUserName();
			String password = user.getPassword();
			if (userName.equalsIgnoreCase("rama") && password.equalsIgnoreCase("rama")) {
				return new ModelAndView("success");
			} else {
				return new ModelAndView("faild");
			}
		}
	}

}
