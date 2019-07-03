package com.spring.bet.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

@Component
public class BetRepositoryCustomImpl implements BetRepositoryCustom{
	
	@PersistenceContext
    private EntityManager entityManager;

	
    public List<?> getTotalNoOfBetsSoldPerHour() {
    	  Query query = entityManager.createNativeQuery("SELECT DATEPART(HOUR , b.date) AS Hour, COUNT(*) from Bet b GROUP BY  b.date, DATEPART(HOUR , b.date)");
    	  return query.getResultList();
    }

}
