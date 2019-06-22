package com.cg.service;

import com.cg.bean.Account;

public class AccountService implements Gst, Transaction{

	@Override
	public double withdraw(Account ob, double amount) {
		double new_balance=ob.getBalance()-amount;
		if(new_balance<1000.00) {
			new_balance=ob.getBalance();
			System.out.println("Insufficient Balance");
		}
		ob.setBalance(new_balance);
		return new_balance;
	}

	@Override
	public double deposite(Account ob, double amount) {
		// TODO Auto-generated method stub
		double new_balance=ob.getBalance()+amount;
		ob.setBalance(new_balance);
		return new_balance;
	}

	@Override
	public double transferMoney(Account from, Account to, double amount) {
		// TODO Auto-generated method stub
		double w=withdraw(from, amount);
		if(w!=from.getBalance()) {
			deposite(to, amount);
			return 1;
		}
		return 0;
	}

	@Override
	public double calculateTax(double PCT, double amount) {
		// TODO Auto-generated method stub
		return amount*Gst.PCT_5;
	}

}
