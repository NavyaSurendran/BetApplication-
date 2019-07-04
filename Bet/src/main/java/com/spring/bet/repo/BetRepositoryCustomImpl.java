package com.spring.bet.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Transactional()
public class BetRepositoryCustomImpl implements BetRepositoryCustom{
	
	@PersistenceContext
    private EntityManager entityManager;

	
    public List<?> getTotalNoOfBetsSoldPerHour() {
    	  Query query = entityManager.createNativeQuery("SELECT hour( b.date), COUNT(*) from Bet b GROUP BY  b.date, hour( b.date)");
    	  return query.getResultList();
    }

}
