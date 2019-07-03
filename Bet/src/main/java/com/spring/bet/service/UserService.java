package com.spring.bet.service;

import com.spring.bet.entity.User;
import com.spring.bet.exception.UserAlreadyExsitsException;
import com.spring.bet.exception.UserNotFoundException;

public interface UserService {

	boolean saveUser (User user) throws UserAlreadyExsitsException, UserNotFoundException;
	User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;

}
