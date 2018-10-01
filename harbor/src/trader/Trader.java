package trader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import token.RToken;
import token.TokenType;

public class Trader {
	private String firstName;
	private String lastName;
	private String id;
	List<RToken> rTokens;
	
	private List<String> transferredTransactions;
	private List<String> receivedTransactions;
	
	public Trader(String fName, String lName, String id) {
		this.firstName = fName;
		this.lastName = lName;
		this.id = id;
		transferredTransactions = new ArrayList<String>();
		receivedTransactions = new ArrayList<String>();
		rTokens = new ArrayList<RToken>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBalance() {
		return rTokens.size();
	}
	
	public void addRToken(RToken token) {
		rTokens.add(token);
	}
	
	public RToken removeToken() {
		return rTokens.remove(rTokens.size()-1);
	}
	
	public void addTransferEvent(String transaction) {
		transferredTransactions.add(transaction);
	}
	
	public void addReceivedEvent(String transaction) {
		receivedTransactions.add(transaction);
	}
	
}
