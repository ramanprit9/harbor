package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import token.RToken;
import token.TokenType;
import trader.Trader;

public class Controller {
	private HashSet<Trader> traders;
	
	public Controller() {
		traders = new HashSet<Trader>();
	}
	
	public boolean addTrader(String fName, String lName, String id) {
		Trader trader = new Trader(fName, lName, id);
		/* TODO: return false if the trader already exists */
		
		traders.add(trader);
		trader.addRToken(new RToken(1000)); //By default, give 2 RTokens to all traders
		trader.addRToken(new RToken(1000));
		return true;
	}
	
	public boolean askQuestion(Trader questionnaire) {
		if (questionnaire.getBalance() == 0) {
			return false;
		}
		return true;
	}
	
	public boolean assignOracle (Trader questionnaire, Trader oracle) {
		//return RToken.transferFrom(questionnaire, oracle, 1);
		return false;
	}
	
}
