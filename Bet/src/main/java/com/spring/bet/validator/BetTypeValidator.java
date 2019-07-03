package com.spring.bet.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BetTypeValidator implements ConstraintValidator<BetTypeConstraint, String> {

	
	List<String> betType = Arrays.asList("WIN", "PLACE", "TRIFECTA", "DOUBLE", "QUADDIE");
	
	 @Override
	 public void initialize(BetTypeConstraint betType) {
	 }
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return  betType.contains(value);
	}

}
