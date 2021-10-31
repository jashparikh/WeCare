package com.springboot.wecare.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.wecare.model.Login;
import com.springboot.wecare.service.ILoginService;

@RestController
public class LoginController {

	@Autowired
	ILoginService loginService;

	@GetMapping("/getLoginDetails")
	public Login getLoginDetails(Login login) {

		System.out.println("Get all data..");

		return loginService.getLoginDetails(login.getLoginId());
	}

	@CrossOrigin
	@PostMapping("/addLogin")
	public String addLogin(@RequestBody @Valid Login login) {
		String contact = loginService.addLogin(login);

		return contact;
	}

	@CrossOrigin
	@PutMapping("/updateLoginDetails")
	public String updateLoginDetails(@RequestBody @Valid Login login) {
		String response = loginService.updateLoginDetails(login);

		return response;
	}

	@CrossOrigin
	@DeleteMapping("/deleteLogin")
	public String deleteLogin(@RequestBody @Valid Login login) {
		// System.out.println("*************************" + login +
		
		// "**************************************");
		String response = loginService.deleteLogin(login.getLoginId());

		return response;
	}

	@GetMapping("/validateLogin")
	public String validateLogin(Login login) {

		return loginService.validateLogin(login);
	}

	@CrossOrigin
	@PutMapping("/lockUser")
	public String lockUser(@RequestBody @Valid Login login) {
		String response = loginService.lockUser(login.getLoginId());

		return response;
	}

	@CrossOrigin
	@PutMapping("/unlockUser")
	public String unlockUser(@RequestBody @Valid Login login) {
		String response = loginService.unlockUser(login.getLoginId());

		return response;
	}

}
