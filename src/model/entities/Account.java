package model.entities;

import model.exceptions.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public double getBalance() {
		return this.balance;
	}

	public void deposit(double value) {
		this.balance += value;
	}
	
	public void withdraw(double value) throws DomainException {
		validateWithdraw(value);	
		balance -= value;
	}
	

	public void validateWithdraw(double value) throws DomainException {
		if((balance+withdrawLimit) >= value) {
			
			this.balance -= value;
		}
			else {
				throw new DomainException("Saldo insuficiente para o saque");
			}
		}
	}

