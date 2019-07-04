package com.spring.bet.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;

import com.spring.bet.validator.BetTypeConstraint;
import com.spring.bet.validator.DateConstraint;


@Table(name = "bet")
@Entity
public class Bet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bet_id")
	private int betId;

	@DateConstraint
	@Column(name = "date")
	private Timestamp date;

	@BetTypeConstraint
	@Column(name = "bet_type")
	private String betType;

	@Column(name = "prop_number")
	private long propNumber;

	@Column(name = "customer_id")
	private long customerId;

	@Max(value = 20000, message = "Maximum Investment Amount is $20,000")
	@Column(name = "investment_amount")
	private double investmentAmount;
	
	public Bet() {
		
	}
	
	public Bet(int betId, Timestamp date, String betType, long propNumber, long customerId, double investmentAmount) {
		this.betId = betId;
		this.date = date;
		this.betType = betType;
		this.propNumber = propNumber;
		this.customerId = customerId;
		this.investmentAmount = investmentAmount;
	}

	public int getBetId() {
		return betId;
	}

	public void setBetId(int betId) {
		this.betId = betId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getBetType() {
		return betType;
	}

	public void setBetType(String betType) {
		this.betType = betType;
	}

	public long getPropNumber() {
		return propNumber;
	}

	public void setPropNumber(long propNumber) {
		this.propNumber = propNumber;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public double getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(double investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

}
