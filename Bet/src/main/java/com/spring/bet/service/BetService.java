package com.spring.bet.service;

import java.util.List;

import com.spring.bet.entity.Bet;
import com.spring.bet.exception.BetAlreadyExistsException;

public interface BetService {
	
	public boolean saveBet (Bet bet) throws BetAlreadyExistsException;
	
	public Object[] getTotalInvestmentPerBetType();
	
	public Object[] getTotalInvestmentPerCustomerID();
	
	public Object[] getTotalBetsSoldPerBetType();
	
	public List<?> getTotalNoOfBetsSoldPerHour();
}
