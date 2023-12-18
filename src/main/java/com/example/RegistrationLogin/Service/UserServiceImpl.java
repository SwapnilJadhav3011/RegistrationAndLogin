package com.example.RegistrationLogin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RegistrationLogin.Entity.User;
import com.example.RegistrationLogin.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUserByEmailId(String tempEmailId) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(tempEmailId);
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User getUserByEmailAndPassword(String tempEmailId, String tempPass) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailAndPassword(tempEmailId , tempPass);
	}

}
