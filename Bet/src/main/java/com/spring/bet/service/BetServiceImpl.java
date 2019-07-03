package com.spring.bet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bet.entity.Bet;
import com.spring.bet.exception.BetAlreadyExistsException;
import com.spring.bet.repo.BetRepository;

@Service
public class BetServiceImpl implements BetService {
	
	
	private BetRepository betRepository;
	
	@Autowired
	public BetServiceImpl(BetRepository betRepository) {
		super();
		this.betRepository = betRepository;
	}

	@Override
	public boolean saveBet(Bet bet) throws BetAlreadyExistsException {
		
		final Optional<Bet> object = betRepository.findById(bet.getBetId());
		if (object.isPresent()) {
			throw new BetAlreadyExistsException("Could not save, Bet already exsits");
		}
		betRepository.save(bet);	
		return true;
	}

	@Override
	public Object[] getTotalInvestmentPerBetType() {
		Object[] investmentArray= betRepository.getTotalInvestmentPerBetType();
		return investmentArray;
	}

	@Override
	public Object[] getTotalInvestmentPerCustomerID() {
		return betRepository.getTotalInvestmentPerCustomerID();
	}

	@Override
	public Object[] getTotalBetsSoldPerBetType() {
		return betRepository.getTotalBetsSoldPerBetType();
	}

	@Override
	public List<?> getTotalNoOfBetsSoldPerHour() {
		return betRepository.getTotalNoOfBetsSoldPerHour();
	}

}
