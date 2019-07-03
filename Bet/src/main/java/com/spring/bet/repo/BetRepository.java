package com.spring.bet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.bet.entity.Bet;

@Repository
public interface BetRepository extends JpaRepository<Bet, Integer>, BetRepositoryCustom{
	
	
	
	@Query("SELECT b.betType, SUM(b.investmentAmount)  from Bet b GROUP BY b.betType")
	public Object[] getTotalInvestmentPerBetType();
	
	@Query("SELECT b.customerId, SUM(b.investmentAmount) from Bet b GROUP BY b.customerId")
	public Object[] getTotalInvestmentPerCustomerID();
	
	@Query("SELECT b.betType, COUNT(*) from Bet b GROUP BY b.betType")
	public Object[] getTotalBetsSoldPerBetType();
	
	
	
}
