package com.spring.bet.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.spring.bet.entity.Bet;
import com.spring.bet.exception.BetAlreadyExistsException;
import com.spring.bet.repo.BetRepository;

public class BetServiceImplTest {
	
	@Mock
	private transient BetRepository  repo;
	
	private transient Bet bet;
	
	@InjectMocks
	private BetServiceImpl service;
	
	transient Optional<Bet> options;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		bet = new Bet(1236,  new Date(Calendar.getInstance().getTime().getTime()), "WIN", 104567L, 1080L, 100);
		options = Optional.of(bet);
	}
	
	@Test
	public void testMockCreation() {
		assertNotNull("JPA repo creation failed", bet);
	}
	
	@Test
	public void testSaveBetSuccess() throws BetAlreadyExistsException{
		when(repo.save(bet)).thenReturn(bet);
		final boolean flag = service.saveBet(bet);
		assertTrue("Saving Bet success", flag);
		verify(repo,times(1)).save(bet);	
		verify(repo,times(1)).findById(bet.getBetId());			
	}
	
	@Test(expected =BetAlreadyExistsException.class)
	public void testSaveMovieFailure() throws BetAlreadyExistsException{
		when(repo.findById(1236)).thenReturn(options);		
		when(repo.save(bet)).thenReturn(bet);
		final boolean flag = service.saveBet(bet);
	
		assertFalse("Saving Bet failed",flag);		
		verify(repo,times(1)).findById(bet.getBetId());			
	}
	
	/*@Test
	public void testGetTotalInvestmentPerBetType() {
		Object[] totalInvestment;
		totalInvestment[0] = new Object("WIN", 200);
		
		when(repo.findByUserId("jon")).thenReturn(movies);		
		List<Movie> mvs = service.getMyMovies("jon");
		assertEquals("fetching all movies  failed",movies.size(), mvs.size());		
		verify(repo,times(1)).findByUserId("jon");
		
	}*/

}
