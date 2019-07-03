package com.spring.bet.validator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<DateConstraint, Date>{
	
	 
	
	 @Override
	 public void initialize(DateConstraint date) {
	 }
	
	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		// Only use the date for comparison
        Calendar calendar = Calendar.getInstance(); 
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date today = calendar.getTime();

        // Your date must be after today or today (== not before today)
        return !value.before(today) ;
	}

}
