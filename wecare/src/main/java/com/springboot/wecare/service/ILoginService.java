package com.springboot.wecare.service;

import javax.validation.Valid;

import com.springboot.wecare.model.Login;

public interface ILoginService {

	String addLogin(@Valid Login login);

	Login getLoginDetails(Long loginId);

	String deleteLogin(Long loginId);

	String updateLoginDetails(@Valid Login login);

	String validateLogin(Login login);

	String lockUser(Long loginId);

	String unlockUser(Long loginId);

}
