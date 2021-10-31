package com.springboot.wecare.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.wecare.model.Login;
import com.springboot.wecare.repository.LoginRepository;

@Service
public class LoginService implements ILoginService {

	@Autowired
	LoginRepository loginRepository;

	@Override
	@Transactional
	public String addLogin(@Valid Login login) {
		// TODO Auto-generated method stub
		try {
			loginRepository.save(login);

		} catch (Exception e) {
			return e.getMessage();
		}

		return "login Saved";
	}

	@Override
	@Transactional
	public Login getLoginDetails(Long loginId) {
		// TODO Auto-generated method stub
		Optional<Login> login;
		Login errorLogin = new Login();
		try {
			login = loginRepository.findByLoginId(loginId);

		} catch (Exception e) {
			return errorLogin;
		}

		return login.get();
	}

	@Override
	@Transactional
	public String deleteLogin(Long loginId) {
		try {

			Optional<Login> login = loginRepository.findByLoginId(loginId);

			loginRepository.delete(login.get());

		} catch (Exception e) {

			return e.getMessage();
		}

		return "User Deleted";
	}

	@Override
	@Transactional
	public String updateLoginDetails(@Valid Login login) {
		// TODO Auto-generated method stub
		Optional<Login> searchRecord = loginRepository.findByLoginId(login.getLoginId());

		if (searchRecord.isPresent()) {

			try {

				Login updateLogin = searchRecord.get();

				updateLogin.setUserName(login.getUserName());
				updateLogin.setPassword(login.getPassword());
				updateLogin.setIsLocked("NO");

				loginRepository.save(updateLogin);

			} catch (Exception e) {
				return e.getMessage();
			}

		} else {

			return "Record doesn't exist";

		}
		return "User Updated";

	}

	@Override
	@Transactional
	public String validateLogin(Login login) {
		Optional<Login> loginDetails;
		try {
			loginDetails = loginRepository.findByLoginId(login.getLoginId());

		} catch (Exception e) {
			return e.getMessage();
		}

		String userName = loginDetails.get().getUserName();
		String password = loginDetails.get().getPassword();

		if (login.getUserName() == userName && login.getPassword() == password) {
			return "valid user";
		} else
			return "invalid user";
	}

	@Override
	@Transactional
	public String lockUser(Long loginId) {
		// TODO Auto-generated method stub
		Optional<Login> searchRecord = loginRepository.findByLoginId(loginId);

		if (searchRecord.isPresent()) {

			try {

				Login updateLogin = searchRecord.get();

				updateLogin.setIsLocked("YES");

				loginRepository.save(updateLogin);

			} catch (Exception e) {
				return e.getMessage();
			}

		} else {

			return "Record doesn't exist";

		}
		return "User login access locked";
	}

	@Override
	@Transactional
	public String unlockUser(Long loginId) {
		// TODO Auto-generated method stub
		Optional<Login> searchRecord = loginRepository.findByLoginId(loginId);

		if (searchRecord.isPresent()) {

			try {

				Login updateLogin = searchRecord.get();

				updateLogin.setIsLocked("NO");

				loginRepository.save(updateLogin);

			} catch (Exception e) {
				return e.getMessage();
			}

		} else {

			return "Record doesn't exist";

		}
		return "User login access Unlocked";

	}

}
