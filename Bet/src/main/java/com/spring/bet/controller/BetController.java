package com.spring.bet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.bet.entity.Bet;
import com.spring.bet.exception.BetAlreadyExistsException;
import com.spring.bet.service.BetService;

import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping(path="/api/v1/bet")
public class BetController {
	

	private BetService  betService;
	
	@Autowired
	public BetController(BetService  betService) {
		this.betService = betService;
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> saveNewBet(@Valid @RequestBody final Bet bet, HttpServletRequest request, HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		final String authHeader = request.getHeader("authorization");
		System.out.println(authHeader);
		final String token = authHeader.substring(7);
		System.out.println(token);
		String userId =Jwts.parser()
							.setSigningKey("secretKey")
							.parseClaimsJws(token)
							.getBody()
							.getSubject();
		
		

		try {
			betService.saveBet(bet);
		} catch (BetAlreadyExistsException e) {
			responseEntity = new ResponseEntity<String>("{\"message\":\""+e.getMessage()+"\"}",HttpStatus.CONFLICT);
		}
		responseEntity = new ResponseEntity<Bet>(bet,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path="/totalInvestment/betType")
	public ResponseEntity<?> getTotalInvestentPerBetType(HttpServletRequest request, HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId =Jwts.parser()
							.setSigningKey("secretKey")
							.parseClaimsJws(token)
							.getBody()
							.getSubject();
		final Object[] totalInvestment = betService.getTotalInvestmentPerBetType();
		responseEntity = new ResponseEntity<>(totalInvestment,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path="/totalInvestment/customerId")
	public ResponseEntity<?> getTotalInvestmentPerCustomerID(HttpServletRequest request, HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId =Jwts.parser()
							.setSigningKey("secretKey")
							.parseClaimsJws(token)
							.getBody()
							.getSubject();
		final Object[] totalInvestment = betService.getTotalInvestmentPerCustomerID();
		responseEntity = new ResponseEntity<>(totalInvestment,HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path="/bets/betType")
	public ResponseEntity<?> getTotalBetsSoldPerBetType(HttpServletRequest request, HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId =Jwts.parser()
							.setSigningKey("secretKey")
							.parseClaimsJws(token)
							.getBody()
							.getSubject();
		final Object[] totalInvestment = betService.getTotalBetsSoldPerBetType();
		responseEntity = new ResponseEntity<>(totalInvestment,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path="/bets/hour")
	public ResponseEntity<?> getTotalNoOfBetsSoldPerHour(HttpServletRequest request, HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId =Jwts.parser()
							.setSigningKey("secretKey")
							.parseClaimsJws(token)
							.getBody()
							.getSubject();
		final List<?> totalInvestment = betService.getTotalNoOfBetsSoldPerHour();
		responseEntity = new ResponseEntity<>(totalInvestment,HttpStatus.OK);
		return responseEntity;
	}


}
