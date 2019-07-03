package com.spring.bet.athentication;

import java.util.Map;

import com.spring.bet.entity.User;

public interface SecurityTokenGenerator {
	
	Map<String, String> generateToken(User user);

}

