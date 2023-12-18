package com.example.RegistrationLogin.Service;

import com.example.RegistrationLogin.Entity.User;

public interface UserService {

	public User getUserByEmailId(String tempEmailId);

	public User saveUser(User user);

	public User getUserByEmailAndPassword(String tempEmailId, String tempPass);

}
