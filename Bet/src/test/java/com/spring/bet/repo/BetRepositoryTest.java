package com.spring.bet.repo;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.bet.entity.Bet;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
@Transactional
public class BetRepositoryTest {

	@Autowired
	private BetRepository betRepository;
	
	public BetRepositoryTest() {
		
	}
	
	
	
	@Test
	public void testSaveBet() {
		
		Bet bet = new Bet(8956,  new Date(Calendar.getInstance().getTime().getTime()), "WIN", 104567L, 1080L, 100);
		betRepository.save(bet);
		assertNotNull(betRepository.findById(bet.getBetId()));				
	}
	
	@Test
	public void testGetTotalInvestmentPerBetType() {
		Bet bet = new Bet(8958,  new Date(Calendar.getInstance().getTime().getTime()), "WIN", 104567L, 1080L, 100);
		betRepository.save(bet);
		Object[] totalInvestment = betRepository.getTotalInvestmentPerBetType();
		System.out.println("length  "+totalInvestment.length);
		assertNotNull(totalInvestment);
		
	}
	
	@Test
	public void testGetTotalInvestmentPerCustomerID() {
		Bet bet = new Bet(8959,  new Date(Calendar.getInstance().getTime().getTime()), "WIN", 104567L, 1081L, 100);
		betRepository.save(bet);
		 bet = new Bet(8960,  new Date(Calendar.getInstance().getTime().getTime()), "WIN", 104567L, 1082L, 100);
		Object[] totalInvestment = betRepository.getTotalInvestmentPerCustomerID();
		assertNotNull(totalInvestment);
	}
	
	@Test
	public void testGetTotalBetsSoldPerBetType() {
		Bet bet = new Bet(8961,  new Date(Calendar.getInstance().getTime().getTime()), "PLACE", 104567L, 1081L, 100);
		betRepository.save(bet);
		 bet = new Bet(8962,  new Date(Calendar.getInstance().getTime().getTime()), "TRIFECTA", 104567L, 1082L, 100);
		 betRepository.save(bet);
		 Object[] totalInvestment = betRepository.getTotalBetsSoldPerBetType();
		 assertNotNull(totalInvestment);
	}
}
