package com.spring.bet.repo;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;


public interface BetRepositoryCustom {

	
	public List<?> getTotalNoOfBetsSoldPerHour();

}
