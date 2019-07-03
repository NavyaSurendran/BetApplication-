package com.spring.bet.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.bet.entity.Bet;
import com.spring.bet.service.BetService;

@RunWith(SpringRunner.class)
@WebMvcTest(BetController.class)
@EnableJpaRepositories(basePackages="com.spring.bet.repo", entityManagerFactoryRef="emf")
public class BetControllerTest {
	
	@Autowired
	private transient MockMvc mvc;
	
	@MockBean
	private transient BetService service;
	
	@InjectMocks
	private BetController controller;

	private Bet bet;
	
	static List<Bet> bets;	

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		bets = new ArrayList<>();
		bet = new Bet(1111,  new Date(Calendar.getInstance().getTime().getTime()), "WIN", 104567L, 1080L, 100);
		bets.add(bet);
		bet = new Bet(1112,  new Date(Calendar.getInstance().getTime().getTime()), "PLACE", 104567L, 1080L, 100);
		bets.add(bet);
		bet = new Bet(1113,  new Date(Calendar.getInstance().getTime().getTime()), "DOUBLE", 104567L, 1080L, 100);
		bets.add(bet);
	}

	@Test
	public void saveNewBetTest() throws Exception {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuYXZ5YSIsImlhdCI6MTU2MjEzNTY5M30.uEIcnX3VtJ7fe07EBTOq0FoIvTDVujb-hvkuONnMzc8";
		when(service.saveBet(bet)).thenReturn(true);
		mvc.perform(post("/api/v1/movie")
				.header("authorization", "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(bet)))
			.andExpect(status().isCreated());
		verify(service, times(1)).saveBet(Mockito.any(Bet.class));		
	}

	private static String jsonToString(final Object obj) {
		String result;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			result = jsonContent;
			} catch (JsonProcessingException e) {
				result = "JSON Parsing error";				
			}
		return result;
	}
}
